import scala.concurrent.ExecutionContext.Implicits.global
class TaskSuite extends munit.FunSuite {
  // custom handling for asynchronous types beside Future[T]
  override def munitValueTransforms: List[ValueTransform] =
    super.munitValueTransforms ++ List(
      new ValueTransform(
        "LazyFuture",
        { case LazyFuture(run) =>
          run() // make sure thunk gets called
        }
      )
    )

  test("ok-task") {
    LazyFuture {
      Thread.sleep(500)

      // throw new RuntimeException("BOOM!")
      42
    }
  }
}
