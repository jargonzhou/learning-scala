/** Rational numbers.
  *
  * @constructor
  *   construct a rational number.
  * @param n
  *   numerator
  * @param d
  *   denominator
  */
class Rational(n: Int, d: Int) extends Ordered[Rational] {
  // precondition
  require(d != 0)

  // private fields
  private val g = gcd(n.abs, d.abs)
  val numer: Int = n / g
  val denom: Int = d / g

  // auxiliary constructor
  def this(n: Int) = this(n, 1)

  override def toString(): String = s"$numer/$denom"

  def add(that: Rational): Rational =
    new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

  def lessThan(that: Rational) =
    // self reference
    this.numer * that.denom < that.numer * this.denom

  def max(that: Rational) = if (this.lessThan(that)) that else this

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  //
  // operators
  //
  def +(that: Rational): Rational =
    new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

  def +(i: Int): Rational =
    new Rational(numer + i * denom, denom)

  def -(that: Rational): Rational =
    new Rational(numer * that.denom - that.numer * denom, denom * that.denom)

  def -(i: Int): Rational = new Rational(numer - i * denom, denom)

  def *(that: Rational): Rational =
    new Rational(numer * that.numer, denom * that.denom)

  def *(i: Int): Rational = new Rational(numer * i, denom)

  def /(that: Rational): Rational =
    new Rational(numer * that.denom, denom * that.numer)

  def /(i: Int): Rational =
    new Rational(numer, denom * i)

  //
  // Ordered trait
  //
  override def compare(that: Rational): Int =
    (this.numer * that.denom) - (that.numer * this.denom)
}
