# Scala Toolkit
* https://docs.scala-lang.org/toolkit/introduction.html

> The Scala Toolkit is a set of libraries designed to effectively perform common programming tasks. It includes tools for working with files and processes, parsing JSON, sending HTTP requests, and unit testing.

The Toolkit supports:
* Scala 3 and Scala 2
* JVM, Scala.js, and Scala Native

Use cases for the Toolkit include:
* short-lived programs running on the JVM, to scrape a website, to collect and transform data, or to fetch and process some files,
* frontend scripts that run on the browser and power your websites,
* command-line tools packaged as native binaries for instant startup


# Tests: MUnit
* https://scalameta.org/munit/
* https://docs.scala-lang.org/toolkit/testing-intro.html
* API: https://index.scala-lang.org/scalameta/munit

actions: 
- [sbt hello-world MUnit examples](./sbt/hello-world/README.md#munit)

MUnit has useful features such as:
- **assertions** to verify the behavior of the program
- **fixtures** to ensure that the tests have access to all the necessary resources
- **asynchronous support**, for testing concurrent and distributed applications.

MUnit produces **actionable error reports**, with diff and source location, to help you quickly understand failures.

concepts
- write tests
  - `FunSuite`
  - `assertEquals`, `assert`, `assertNotEquals`, `assertNoDiff`, `fail`, `compileErrors`, .
- run tests
  - Scala CLI: `scala-cli test example` all tests in folder `example`
  - sbt: `sbt:example> test` all tests of project `example`
  - Mill: `./mill example.test.test` all tests of module `example`
- run a single test
  - Scala CLI: `scala-cli test example --test-only example.MyTests`
  - sbt: `sbt:example> testOnly example.MyTests`
  - Mill: `./mill example.test.testOnly example.MyTests`
  - cases
    - `.only`: run a single test in a test suite
    - `.ignore`: exclude specific tests
    - `assume(condition, explanation)`: ignore single test case based on a dynamic conditions
    - `@munit.IgnoreSuite`: ignore entire test suite
    - `override def munitIgnore: Boolean = !scala.util.Properties.isWin`: ignore entire test suite based on a dynamic condition
    - `val tag = new munit.Tag("tag-name")`, `.tag(tag)`, `--include-tags`, `--exclude-tags`: include and exclude tests based on tags
    - include and exclude tags by default when running sbt `test`
    - `class Slow extends munit.Tag("Slow")`, `@Category(Array(classOf[Slow]))`: group test suites with categories
    - `override def munitTests(): Seq[Test] = ...`: filter tests cases based on a dynamic conditions
- test exceptions
  - `intercept[NoSuchFileException] {...}`: check that your code throws an exception. 
  - the body of the `intercept` assertion contains the code that should throw the exception.
  - the test passes if the code throws the expected exception and it fails otherwise.
  - `intercept` method returns the exception that is thrown. `assert(clue(exception.getMessage).contains("missing.txt"))`
  - `interceptMessage` method.
- write asynchronous tests
  - test body return a `Future[T]`
  - Override `munitValueTransforms` to add custom handling for other asynchronous types.
- manage resources of a test
  - `FunFixture`: `setup`, `teardown`
- more
  - add clues to get better error report: use `clue` inside `assert`
  - environment-specific tests: `assume()`
  - `.flasky`: tests can be skipped by setting the `MUNIT_FLAKY_OK` environment variable to `true`

# Files and Processes: OS-Lib
* [os-lib.ipynb](./lib/os-lib.ipynb)

# JSON: uPickle
* [upickle.ipynb](./lib/upickle.ipynb)

# HTTP Requests: sttp

# Web servers: Cask