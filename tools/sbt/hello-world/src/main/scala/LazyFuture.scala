import scala.concurrent.ExecutionContext
import scala.concurrent.Future

final case class LazyFuture[+T](run: () => Future[T])
object LazyFuture {
  def apply[T](thunk: => T)(implicit ec: ExecutionContext): LazyFuture[T] =
    LazyFuture(() => Future(thunk))
}
