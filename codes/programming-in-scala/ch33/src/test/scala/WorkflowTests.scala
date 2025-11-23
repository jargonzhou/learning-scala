class WorkflowTests extends munit.FunSuite {
  val input = """
read input name, country
switch:
  country == "PT" ->
    call service "A"
    exit
  otherwise ->
    call service "B"
    switch:
      name == "unknown" ->
        exit
      otherwise ->
        call service "C"
        exit"""

  test("workflow lexer") {
    import parsers._

    WorkflowLexer(input) match {
      case Left(e) => e
      case Right(tokens) =>
        tokens foreach { t =>
          println(t)
          println(t.pos.longString) // postion of token
          println
        }
    }
// NEED keep pos of INDENT and DEDENT
  }

  test("workflow compiler") {
    import parsers._
    import pprint._

    pprintln(WorkflowCompiler(input))
  }
}
