package abstract_members

// Listing 20.1 overriding abstract vals and parameterless methods
abstract class Fruit {
  val v: String // val
  def m: String // method
}

abstract class Apple extends Fruit {
  val v: String
  val m: String // OK
}

abstract class BadApple extends Fruit {
  // ERROR: stable, immutable value required to override
  // def v: String
  def m: String
}

// Listing 20.4 a trait that uses its abstract vals
trait RationalTrait {
  val numerArg: Int
  val denomArg: Int

  require(denomArg != 0)
  private val g = gcd(numerArg, denomArg)
  val numer = numerArg / g
  val denom = denomArg / g

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  override def toString() = s"$numer/$denom"
}

// Listing 20.8 initializing a trait with lazy vals
trait LazyRationalTrait {
  val numerArg: Int
  val denomArg: Int

  // all concrete fields are lazy
  lazy val numer = numerArg / g
  lazy val denom = denomArg / g
  private lazy val g = {
    require(denomArg != 0)
    gcd(numerArg, denomArg)
  }
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
  override def toString() = s"$numer/$denom"
}
