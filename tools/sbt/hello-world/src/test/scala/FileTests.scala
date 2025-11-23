class FileTests extends munit.FunSuite {

  // functional test-local fixtures: FunFixture[T]
  val usingTempFile: FunFixture[os.Path] = FunFixture(
    setup = _ => os.temp(prefix = "file-tests"),
    teardown = tempFile => os.remove(tempFile)
  )

  // compose fixtures
  val using2TempFiles: FunFixture[(os.Path, os.Path)] =
    FunFixture.map2(usingTempFile, usingTempFile)

  usingTempFile.test("overwrite on file") { tempFile =>
    os.write.over(tempFile, "Hello World!")
    val obtained = os.read(tempFile)
    assertEquals(obtained, "Hello World!")
  }

  using2TempFiles.test("merge two files") { case (file1, file2) =>
    assertNotEquals(file1.toString(), file2.toString())
  }

  // more
  //
  // reusable test-local fixtures: Fixture[T], beforeEach(), afterEach(), munitFixtures
  // reusable suite-local fixtures: Fixture[T], beforeAll(), afterAll()
  // ad-hoc test-local fixtures: FunSuite, beforeEach(), afterEach()
  // ad-hoc suite-local fixtures: FunSuite, beforeAll(), afterAll()
  // asynchronous fixtures: FutureFixture[T], EffectFixture[T]
}
