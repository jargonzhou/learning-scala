import scala.concurrent.ExecutionContext.Implicits.global

class AsyncMathLibTests extends munit.FunSuite {
  test("square") {
    for {
      squareOf3 <- AsyncMathLib.square(3)
      squareOfMinus4 <- AsyncMathLib.square(-4)
    } yield {
      assertEquals(squareOf3, 9)
      assertEquals(squareOfMinus4, 16)
    }
  }
}
