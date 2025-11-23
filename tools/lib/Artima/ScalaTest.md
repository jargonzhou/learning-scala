# ScalaTest
* https://www.scalatest.org/
* https://github.com/scalatest/scalatest

> ScalaTest is a free, open-source testing toolkit for Scala and Java programmers.

concepts
- suite, test
- lifecycle methods
- style traits, mixin traits
- runner

# User Guide
* https://www.scalatest.org/user_guide

concepts
- The central concept in ScalaTest is the **suite**, a collection of zero to many tests.
- A **test** can be anything with a name that can start and either succeed, fail, be pending, or canceled.
- The central unit of composition in ScalaTest is `Suite`, which represents a suite of tests.
- Trait `Suite` declares `run` and other “lifecycle” methods that define a default way to write and run tests.
- These lifecycle methods can be overridden to customize how tests are written and run.
- ScalaTest offers **style traits** that extend `Suite` and override lifecycle methods to support different testing styles.
- It provides **mixin traits** that override lifecycle methods of the style traits to address particular testing needs.
- You define test classes by composing `Suite` style and mixin traits.
- You define test suites by composing `Suite` instances.

Using ScalaTest on your project is as easy as 1, 2, 3:
- 1. Select your testing styles
- 2. Define your base classes
- 3. Start writing tests

TODO

## Running your tests
* https://www.scalatest.org/user_guide/running_your_tests

# See Also
* Programming in Scala, 4th Edition. 14.2 Testing in Scala.
```scala
org.scalatest.funsuite.AnyFunSuite
Suite // trait
  // lifecycle methods
  execute()

Runner

Diagrams

assert()
assertResult() {}
assertThrows[Exception] {}
intercept[Exception] {}

// BDD
org.scalatest.flatspec.AnyFlatSpec
  // specifier clauses
  "<subject>" should "<behavior>" in {} // should: must, can 

// matchers
org.scalatest.matchers.should.Matchers
  should be 
  an [Exception] should be thrownBy {}
MustMatchers
```
* JUnit, TestNG, [specs2](./specs2.md), [ScalaCheck](./Typelevel/ScalaCheck.md)