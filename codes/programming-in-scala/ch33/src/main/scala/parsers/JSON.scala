package parsers

import scala.util.parsing.combinator._

/** JSON
  * ```
  * value ::= obj | arr | stringLiteral | floatingPointNumber | "null" | "true" | "false".
  * obj ::= "{" [members] "}".
  * arr ::= "[" [values] "]".
  * members ::= member \{"," member\}.
  * member ::= stringLiteral ":" value.
  * values ::= value \{"," value\}
  * ```
  */
object ParseJSON extends JavaTokenParsers {
  def value: Parser[Any] =
    obj | arr | stringLiteral | floatingPointNumber | "null" | "true" | "false"
  def obj: Parser[Any] = "{" ~ repsep(member, ",") ~ "}"
  def arr: Parser[Any] = "[" ~ repsep(value, ",") ~ "]"
  def member: Parser[Any] = stringLiteral ~ ":" ~ value
}

object ParseJSONAsMap extends JavaTokenParsers {
  def value: Parser[Any] = (
    obj
      | arr
      | stringLiteral
      | floatingPointNumber ^^ (_.toDouble)
      | "null" ^^ (_ => null)
      | "true" ^^ (_ => true)
      | "false" ^^ (_ => false)
  )

  def obj: Parser[Map[String, Any]] =
    "{" ~> repsep(member, ",") <~ "}" ^^ (Map() ++ _)
  def arr: Parser[List[Any]] = "[" ~> repsep(value, ",") <~ "]"
  def member: Parser[(String, Any)] = stringLiteral ~ ":" ~ value ^^ {
    case name ~ ":" ~ value => (name, value)
    case _                  => null
  }
}
