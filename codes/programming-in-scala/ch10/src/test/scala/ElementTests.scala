import layout._
import layout.Element._

class ElementTests extends munit.FunSuite {
  test("element creation") {
    val e: Element = new ArrayElement(Array("hello"))

    assert(e != null, "e is not null")
    println(e.contents.sameElements(Array("hello")))
  }

  test("polymorphism") {
    val e1: Element = new ArrayElement(Array("hello", "world"))
    val ae: ArrayElement = new LineElement("hello")
    assert(e1.isInstanceOf[Element])
    assert(ae.isInstanceOf[ArrayElement])
    assert(ae.isInstanceOf[Element])

    val e2: Element = ae
    assert(e2.isInstanceOf[Element])
    assert(e2.isInstanceOf[ArrayElement])
    val e3: Element = new UniformElement('x', 2, 3)
    assert(e3.isInstanceOf[Element])
    assert(e3.isInstanceOf[UniformElement])
  }

  test("dynamic binding") {
    assertEquals[String, String](
      invokeDemo(new ArrayElement2),
      "ArrayElement's implementation invoked"
    )
    assertEquals[String, String](
      invokeDemo(new LineElement2),
      "LineElement's implementation invoked"
    )
    assertEquals[String, String](
      invokeDemo(new UniformElement2),
      "Element's implementation invoked"
    )
  }

  def invokeDemo(e: Element2): String = e.demo()

  test("Spiral") {
    val spiral = Spiral.spiral(17, 0)
    println(spiral)
  }
}
