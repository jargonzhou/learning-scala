class RationalTests extends munit.FunSuite {
  test("add") {
    val oneHalf = new Rational(1, 2)
    val twoThirds = new Rational(2, 3)
    val result = oneHalf add twoThirds
    assertEquals(result.numer, 7)
    assertEquals(result.denom, 6)
  }

  test("constructor") {
    val y = new Rational(3)
    assertEquals(y.numer, 3)
    assertEquals(y.denom, 1)

    val z = new Rational(66, 42)
    assertEquals(z.numer, 11)
    assertEquals(z.denom, 7)
  }

  test("operators") {
    val x = new Rational(1, 2)
    val y = new Rational(2, 3)
    val z = x + y
    assertEquals(z.numer, 7)
    assertEquals(z.denom, 6)

    val zz = x + x * y
    assertEquals(zz.numer, 5)
    assertEquals(zz.denom, 6)

    val zzz = (x + x) * y
    assertEquals(zzz.numer, 2)
    assertEquals(zzz.denom, 3)
  }

  test("2 * r") {
    import Implicits._

    val r = new Rational(2, 3)
    val result = 2 * r
    assertEquals(result.numer, 4)
    assertEquals(result.denom, 3)
  }
}
