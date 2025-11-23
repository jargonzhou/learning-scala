package layout

abstract class Element { // extends scala.AnyRef
  import Element.elem // import methods from companion object

  // abstract method
  def contents: Array[String]

  // parameterless method
  def height: Int = contents.length
  def width: Int = if (height == 0) 0 else contents(0).length
  // field
  // val height: Int = contents.length
  // val width: Int = if (height == 0) 0 else contents(0).length

  // def above(that: Element): Element = new ArrayElement(
  //   this.contents ++ that.contents
  // )
  // def above(that: Element): Element = elem(this.contents ++ that.contents)
  // def beside(that: Element): Element = elem(
  //   for ((line1, line2) <- this.contents zip that.contents)
  //     yield line1 + line2
  // )
  def above(that: Element): Element = {
    val this1 = this widen that.width
    val that1 = that widen this.width
    elem(this1.contents ++ that1.contents)
  }
  def beside(that: Element): Element = {
    val this1 = this heighten that.height
    val that1 = that heighten this.height
    elem(
      for ((line1, line2) <- this1.contents zip that1.contents)
        yield line1 + line2
    )
  }

  def widen(w: Int): Element =
    if (w <= width) this
    else {
      val left = elem(' ', (w - width) / 2, height)
      val right = elem(' ', w - width - left.width, height)
      left beside this beside right
    }
  def heighten(h: Int): Element =
    if (h <= height) this
    else {
      val top = elem(' ', width, (h - height) / 2)
      val bot = elem(' ', width, h - height - top.height)
      top above this above bot
    }

  override def toString: String = contents mkString "\n"
}

/** companion object of class [[Element]]: the factory object for layout
  * elements.
  */
object Element {

  /** private */
  class ArrayElement(val contents: Array[String]) extends Element

  /** private */
  class LineElement(s: String) extends ArrayElement(Array(s)) {
    override def width: Int = s.length
    override def height: Int = 1
  }

  /** private */
  class UniformElement(
      ch: Char,
      override val width: Int,
      override val height: Int
  ) extends Element {
    private val line = ch.toString * width
    def contents: Array[String] = Array.fill(height)(line)
  }

  def elem(contents: Array[String]): Element = new ArrayElement(contents)

  def elem(chr: Char, width: Int, height: Int): Element =
    new UniformElement(chr, width, height)

  def elem(line: String): Element = new LineElement(line)
}

// class ArrayElement(conts: Array[String]) extends Element {
//   def contents: Array[String] = conts
//   // use a field to override a parameterless method
//   // val contents: Array[String] = conts // NPE: Cannot read the array length because the return value of "Element.contents()" is null
// }

// parametric field: define a parameter and field with the same name at the same time
// class ArrayElement(val contents: Array[String]) extends Element

class Cat {
  val dangerous = false
}

class Tiger(override val dangerous: Boolean, private var age: Int) extends Cat
// same as
class Tiger2(param1: Boolean, param2: Int) extends Cat {
  override val dangerous: Boolean = param1
  private var age = param2
}

// class LineElement(s: String) extends ArrayElement(Array(s)) { // invoke superclass constructors
//   override def width: Int = s.length
//   override def height: Int = 1
// }

// more forms of Element
// class UniformElement(
//     ch: Char,
//     override val width: Int,
//     override val height: Int
// ) extends Element {
//   private val line = ch.toString * width
//   def contents: Array[String] = Array.fill(height)(line)
// }

//
// examples for dynamically bound
//
abstract class Element2 {
  def demo(): String = "Element's implementation invoked"

}

class ArrayElement2 extends Element2 {
  override def demo(): String = "ArrayElement's implementation invoked"
}

// final class
final class LineElement2 extends ArrayElement2 {
  // final members
  final override def demo(): String = "LineElement's implementation invoked"
}

class UniformElement2 extends Element2
