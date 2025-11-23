class ImportTests extends munit.FunSuite {
  test("imports") {
    // import a class
    // import bobsdelights.Fruit
    // import all members of bobsdelights
    import bobsdelights._
    // import all members of a singleton object
    import bobsdelights.Fruits._

    def showFruit(fruit: Fruit) {
      // import fields of a class instance
      import fruit._
      println(name + "s are " + color)
    }

    showFruit(Apple)
  }

  test("import package") {
    // import packages themselves
    import java.util.regex

    class AStarB {
      val pat = regex.Pattern.compile("a*b")
    }
  }

  test("import selector clauses") {
    // rename
    import bobsdelights0.Fruits.{Apple => McIntosh, Orange}

    import java.sql.{Date => SDate}
    import java.{sql => S} // rename packages
    import bobsdelights0.Fruits.{_} // import all

    // hidden: => _
    import bobsdelights0.Fruits.{Apple => McIntosh, Pear => _, _}
  }

  // implicit imports: later imports overshadow earlier ones
  //
  // import java.lang._
  // import scala._
  // import Predef._
}
