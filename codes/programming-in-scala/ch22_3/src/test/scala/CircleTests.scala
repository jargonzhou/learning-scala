import circle.*

// https://docs.scala-lang.org/scala3/book/ca-extension-methods.html
class CircleTests extends munit.FunSuite:
  test("circle") {
    import lib.* // explicitly import extensions

    val c = Circle(0, 0, 1)
    val cf = c.circumreference
    assertEquals(cf, math.Pi * 2)
    assertEquals(c.diameter, 2.0)
    assertEquals(c.area, math.Pi)
  }
