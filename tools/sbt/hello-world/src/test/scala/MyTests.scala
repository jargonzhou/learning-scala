// MUnit: https://docs.scala-lang.org/toolkit/testing-suite.html
class MyTests extends munit.FunSuite {
  test("sum of two integers") {
    val obtained = 2 + 2
    // val obtained = 2 + 3
    val expected = 4
    assertEquals(obtained, expected)
  }

  test("all even numbers") {
    val input: List[Int] = List(1, 2, 3, 4)
    val obtainedResults: List[Int] = input.map(_ * 2)
    // check that obtained values are all even numbers
    assert(obtainedResults.forall(x => x % 2 == 0))
  }
}
