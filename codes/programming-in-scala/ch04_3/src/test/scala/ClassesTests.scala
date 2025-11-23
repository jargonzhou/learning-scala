class ClassesTests extends munit.FunSuite:
  test("case class") {
    val q = Person("sally", 39)
    println(q)
    println(q.appendToName(" Smith"))
  }
