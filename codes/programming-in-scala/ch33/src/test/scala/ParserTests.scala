class ParserTests extends munit.FunSuite {
  test("parse expr") {
    import parsers.Arith._

    var input = "2 * (3 + 7)"
    var pr = parseAll(expr, input)
    println(pr)

    input = "2 * (3 + 7))"
    pr = parseAll(expr, input)
    println(pr)
  }

  test("regex parser") {
    import scala.util.parsing.combinator.RegexParsers
    object MyParsers extends RegexParsers {
      // identifier
      val ident: Parser[String] = """[a-zA-Z_]\w*""".r
    }

    import MyParsers._
    var pr = parseAll(ident, "abc")
    println(pr)
    pr = parseAll(ident, ".abc")
    println(pr)
  }

  test("JSON") {
    import parsers._
    var input = """
{
  "address book": {
    "name": "John Smith",
    "address": {
      "street": "10 Market Street",
      "city" : "San Francisco, CA",
      "zip" : 94111
    },
    "phone numbers": [
      "408 338-4238",
      "408 111-6892"
    ]
  }
}"""
    val pr = ParseJSON.parseAll(ParseJSON.value, input)
    println(pr)

    val pr2 = ParseJSONAsMap.parseAll(ParseJSONAsMap.value, input)
    println(pr2)
    import pprint._
    pprintln(pr2)
  }

}
