// Building a lexer and parser with Scala's Parser Combinators
// https://enear.github.io/2016/03/31/parser-combinators/

import scala.util.parsing.combinator._
import scala.util.parsing.input.{Reader, Positional, Position, NoPosition}

//
// Error
//
trait WorkflowCompilationError
case class WorkflowLexerError(location: Location, msg: String)
    extends WorkflowCompilationError
case class WorkflowParserError(location: Location, msg: String)
    extends WorkflowCompilationError

case class Location(line: Int, column: Int) {
  override def toString = s"$line:$column"
}

//
// Lexer
//

// tokens
sealed trait WorkflowToken extends Positional
case class TIDENTIFIER(str: String) extends WorkflowToken
case class TLITERAL(str: String) extends WorkflowToken
case class TINDENTATION(spaces: Int) extends WorkflowToken
case object TEXIT extends WorkflowToken
case object TREADINPUT extends WorkflowToken
case object TCALLSERVICE extends WorkflowToken
case object TSWITCH extends WorkflowToken
case object TOTHERWISE extends WorkflowToken
case object TCOLON extends WorkflowToken
case object TARROW extends WorkflowToken
case object TEQUALS extends WorkflowToken
case object TCOMMA extends WorkflowToken
case object TINDENT extends WorkflowToken
case object TDEDENT extends WorkflowToken

object WorkflowLexer extends RegexParsers {
  override def skipWhitespace = true
  override val whiteSpace = "[ \t\r\f]+".r

  def apply(input: String): Either[WorkflowLexerError, List[WorkflowToken]] = {
    (parse(tokens, input): @unchecked) match {
      case NoSuccess(msg, next) =>
        Left(WorkflowLexerError(Location(next.pos.line, next.pos.column), msg))
      case Success(result, next) => Right(result)
    }
  }

  def identifier: Parser[TIDENTIFIER] = positioned {
    "[a-zA-Z_][a-zA-Z0-9_]*".r ^^ { str => TIDENTIFIER(str) }
  }

  def indentation: Parser[TINDENTATION] = positioned {
    "\n[ ]*".r ^^ { whitespace =>
      val nSpaces = whitespace.length - 1
      TINDENTATION(nSpaces)
    }
  }

  def exit = positioned { "exit" ^^ (_ => TEXIT) }
  def readInput = positioned { "read input" ^^ (_ => TREADINPUT) }
  def callService = positioned { "call service" ^^ (_ => TCALLSERVICE) }
  def switch = positioned { "switch" ^^ (_ => TSWITCH) }
  def otherwise = positioned { "otherwise" ^^ (_ => TOTHERWISE) }
  def colon = positioned { ":" ^^ (_ => TCOLON) }
  def arrow = positioned { "->" ^^ (_ => TARROW) }
  def equals = positioned { "==" ^^ (_ => TEQUALS) }
  def comma = positioned { "," ^^ (_ => TCOMMA) }

  def tokens: Parser[List[WorkflowToken]] = {
    phrase(
      rep1(
        exit
          | readInput
          | callService
          | switch
          | otherwise
          | colon
          | arrow
          | equals
          | comma
          | literal
          | identifier
          | indentation
      )
    ) ^^ { rawTokens =>
      processIndentations(rawTokens)
    }
  }

  private def processIndentations(
      tokens: List[WorkflowToken],
      indents: List[Int] = List(0)
  ): List[WorkflowToken] = {

    tokens.headOption match {
      // if there is an increase in indentation level, we push this new level into the stack
      // and produce an TINDENT
      case Some(TINDENTATION(spaces)) if spaces > indents.head =>
        TINDENT :: processIndentations(tokens.tail, spaces :: indents)

      // if there is a decrease, we pop from the stack until we have matched the new level,
      // producing a TDEDENT for each pop
      case Some(TINDENTATION(spaces)) if spaces < indents.head =>
        val (dropped, kept) = indents.partition(_ > spaces)
        (dropped map (_ => TDEDENT)) ::: processIndentations(tokens.tail, kept)

      // if the indentation level stays unchanged, no tokens are produced
      case Some(TINDENTATION(spaces)) if spaces == indents.head =>
        processIndentations(tokens.tail, indents)

      // other tokens are ignored
      case Some(token) =>
        token :: processIndentations(tokens.tail, indents)

      // the final step is to produce a TDEDENT for each indentation level still remaining, thus
      // "closing" the remaining open INDENTS
      case None =>
        indents.filter(_ > 0).map(_ => TDEDENT)
    }
  }

  def literal: Parser[TLITERAL] = positioned {
    """"[^"]*"""".r ^^ { str =>
      val content = str.substring(1, str.length - 1)
      TLITERAL(content)
    }
  }
}

//
// Parser
//
import scala.util.parsing.input.Positional

sealed trait WorkflowAST extends Positional
case class AndThen(step1: WorkflowAST, step2: WorkflowAST) extends WorkflowAST
case class ReadInput(inputs: Seq[String]) extends WorkflowAST
case class CallService(serviceName: String) extends WorkflowAST
case class Choice(alternatives: Seq[ConditionThen]) extends WorkflowAST
case object Exit extends WorkflowAST

sealed trait ConditionThen extends Positional { def thenBlock: WorkflowAST }
case class IfThen(predicate: Condition, thenBlock: WorkflowAST)
    extends ConditionThen
case class OtherwiseThen(thenBlock: WorkflowAST) extends ConditionThen

sealed trait Condition extends Positional
case class Equals(factName: String, factValue: String) extends Condition

object WorkflowParser extends Parsers {
  override type Elem = WorkflowToken

  class WorkflowTokenReader(tokens: Seq[WorkflowToken])
      extends Reader[WorkflowToken] {
    override def first: WorkflowToken = tokens.head
    override def atEnd: Boolean = tokens.isEmpty
    override def pos: Position =
      tokens.headOption.map(_.pos).getOrElse(NoPosition)
    override def rest: Reader[WorkflowToken] = new WorkflowTokenReader(
      tokens.tail
    )
  }

  def apply(
      tokens: Seq[WorkflowToken]
  ): Either[WorkflowParserError, WorkflowAST] = {
    val reader = new WorkflowTokenReader(tokens)
    (program(reader): @unchecked) match {
      case NoSuccess(msg, next) =>
        Left(WorkflowParserError(Location(next.pos.line, next.pos.column), msg))
      case Success(result, next) => Right(result)
    }
  }

  private def identifier: Parser[TIDENTIFIER] = positioned {
    accept("identifier", { case id @ TIDENTIFIER(name) => id })
  }

  private def literal: Parser[TLITERAL] = positioned {
    accept("string literal", { case lit @ TLITERAL(name) => lit })
  }

  def condition: Parser[Equals] = positioned {
    (identifier ~ TEQUALS ~ literal) ^^ { case id ~ eq ~ lit =>
      Equals(id.str, lit.str)
    }
  }

  def program: Parser[WorkflowAST] = positioned {
    phrase(block)
  }

  def block: Parser[WorkflowAST] = positioned {
    rep1(statement) ^^ { case stmtList => stmtList reduceRight AndThen }
  }

  def statement: Parser[WorkflowAST] = positioned {
    val exit = TEXIT ^^ (_ => Exit)
    val readInput = TREADINPUT ~ rep(identifier ~ TCOMMA) ~ identifier ^^ {
      case read ~ inputs ~ TIDENTIFIER(lastInput) =>
        ReadInput(inputs.map(_._1.str) ++ List(lastInput))
    }
    val callService = TCALLSERVICE ~ literal ^^ {
      case call ~ TLITERAL(serviceName) => CallService(serviceName)
    }
    val switch =
      TSWITCH ~ TCOLON ~ TINDENT ~ rep1(ifThen) ~ opt(
        otherwiseThen
      ) ~ TDEDENT ^^ { case _ ~ _ ~ _ ~ ifs ~ otherwise ~ _ =>
        Choice(ifs ++ otherwise)
      }
    exit | readInput | callService | switch
  }

  def ifThen: Parser[IfThen] = positioned {
    (condition ~ TARROW ~ TINDENT ~ block ~ TDEDENT) ^^ {
      case cond ~ _ ~ _ ~ block ~ _ => IfThen(cond, block)
    }
  }

  def otherwiseThen: Parser[OtherwiseThen] = positioned {
    (TOTHERWISE ~ TARROW ~ TINDENT ~ block ~ TDEDENT) ^^ {
      case _ ~ _ ~ _ ~ block ~ _ => OtherwiseThen(block)
    }
  }
}

/** Grammar
  *
  * ```
  * <block> ::= (<statement>)+
  *
  * <statement> ::= "exit"
  * | "read input" (<identifier> ",")* <identifier>
  * | "call service" <stringLiteral>
  * | "switch" ":" TINDENT (<ifThen>)+ [otherwiseThen] TDEDENT
  *
  * <ifThen> ::= <condition> "->" TINDENT <block> TDEDENT
  *
  * <otherwiseThen> ::= "otherwise" "->" TINDENT <block> TDEDENT
  *
  * <condition> ::= <identifier> "==" <stringLiteral>
  * ```
  */
object WorkflowCompiler {
  def apply(input: String): Either[WorkflowCompilationError, WorkflowAST] = {
    for {
      tokens <- WorkflowLexer(input).right
      ast <- WorkflowParser(tokens).right
    } yield ast
  }
}
