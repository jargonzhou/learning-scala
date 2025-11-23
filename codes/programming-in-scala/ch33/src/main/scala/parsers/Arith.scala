package parsers

import scala.util.parsing.combinator._

/** Grammar
  * ```
  * expr ::= term \{"+" term | "-" term\}.
  * term ::= factor \{"*" factor | "/" factor\}.
  * factor ::= floatingPointNumber | "(" expr ")".
  * ```
  */
object Arith extends JavaTokenParsers {
  def expr: Parser[Any] = term ~ rep("+" ~ term | "-" ~ term)
  def term: Parser[Any] = factor ~ rep("*" ~ factor | "/" ~ factor)
  def factor: Parser[Any] = floatingPointNumber | "(" ~ expr ~ ")"
}
