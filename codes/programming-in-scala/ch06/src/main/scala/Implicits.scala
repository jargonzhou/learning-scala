/** Implicit definitions.
  *
  * @see
  *   [[scala.Predef]]
  */
object Implicits {
  //
  // implicit conversion
  //
  implicit def intToRational(x: Int): Rational = new Rational(x)
}
