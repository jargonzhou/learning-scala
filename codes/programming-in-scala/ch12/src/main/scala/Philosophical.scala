trait Philosophical {
  def philosophize() = {
    println("I consumer memory, therefore I am!")
  }
}

class Animal
trait HasLegs

class Frog extends Animal with Philosophical with HasLegs { // mixin traits
  override def toString(): String = "green"

  override def philosophize(): Unit = {
    println("It ain't easy being " + toString + "!")
  }
}
