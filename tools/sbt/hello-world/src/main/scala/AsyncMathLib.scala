import scala.concurrent.ExecutionContext
import scala.concurrent.Future

object AsyncMathLib {
  def square(x: Int)(implicit ec: ExecutionContext): Future[Int] = Future(x * x)
}
