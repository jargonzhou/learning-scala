class MathSuite extends munit.FunSuite {
  // ignore
  test("addition".ignore) {
    assert(1 + 1 == 2)
  }

  test("multiplication") {
    assert(3 * 7 == 21)
  }
  // only
  // test("multiplication".only) {
  //   assert(3 * 7 == 21)
  // }

  test("remainder") {
    assert(13 % 5 == 3)
  }
}
