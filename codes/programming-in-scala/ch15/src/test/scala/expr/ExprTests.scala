package expr

class ExprTests extends munit.FunSuite {
  test("case classes") {
    // factory method
    // arguments as fields
    val v = Var("x")
    assertEquals(v.name, "x")

    // toString, hashCode, equals
    val op = BinOp("+", Number(1), v)
    assertEquals(op.toString(), "BinOp(+,Number(1.0),Var(x))")
    assert(Number(1) == op.left)

    // copy
    assertEquals(op.copy(operator = "-").operator, "-")
  }

  test("pattern matching") {
    val expr: Any = BinOp("+", Number(1), Var("x"))

    // wildcard patterns
    expr match {
      case BinOp(op, left, right) => println(s"$expr is HHa binary operation")
      case _                      => // handle the default case
    }
    expr match {
      case BinOp(_, _, _) => println(s"$expr is a binary operation")
      case _              => println("It's something else")
    }

    // constant patterns
    def describe(x: Any) = x match {
      case 5       => "five"
      case true    => "truth"
      case "hello" => "hi!"
      case Nil     => "the empty list"
      case _       => "something else"
    }
    assertEquals(describe(5), "five")
    assertEquals(describe(true), "truth")
    assertEquals(describe("hello"), "hi!")
    assertEquals(describe(Nil), "the empty list")
    assertEquals(describe(List(1, 2, 3)), "something else")

    // variable patterns
    expr match {
      case 0             => "zero"
      case somethingElse => "not zero: " + somethingElse
    }
    import math.{E, Pi}
    E match {
      case Pi => "strange math? Pi = " + Pi
      case _  => "OK"
    }
    val pi = Pi
    E match {
      case pi => "strange math? Pi = " + pi // lowercase name as variable
      // case _  => "OK" // unreachable code due to variable pattern 'pi'
    }
    E match {
      case `pi` => "strange math? Pi = " + pi // lowercase name as constant
      case _    => "OK"
    }

    // constructor patterns
    expr match {
      case BinOp("+", e, Number(0)) => println("a deep match")
      case _                        =>
    }

    // sequence patterns
    expr match {
      case List(0, _, _) => println("found it")
      case _             =>
    }
    expr match {
      case List(0, _*) =>
        println("found it") // without specifying length of sequences
      case _ =>
    }

    // tuple patterns
    def tupleDemo(expr: Any) {
      expr match {
        case (a, b, c) => println("matched " + a + b + c)
        case _         =>
      }
    }
    tupleDemo(("a ", 3, "-tuple"))

    // typed patterns
    def generalSize(x: Any) = x match {
      case s: String    => s.length
      case m: Map[_, _] => m.size
      case _            => -1
    }
    assertEquals(generalSize("abc"), 3)
    assertEquals(generalSize(Map(1 -> 'a', 2 -> 'b')), 2)
    assertEquals(generalSize(math.Pi), -1)

    // type erasure
    // def isIntIntMap(x: Any) = x match {
    //   // non-variable type argument Int in type pattern scala.collection.immutable.Map[Int,Int] (the underlying of Map[Int,Int]) is unchecked since it is eliminated by erasure
    //   case m: Map[Int, Int] => true
    //   case _                => false
    // }
    // assert(isIntIntMap(Map(1 -> 1)))
    // assert(isIntIntMap(Map("abc" -> "abc")))
    def isStringArray(x: Any) = x match {
      case a: Array[String] => true
      case _                => false
    }
    assert(isStringArray(Array("abc")))
    assert(!isStringArray(Array(1, 2, 3)))

    // variable binding
    expr match {
      case UnOp("abs", e @ UnOp("abs", _)) => e
      case _                               =>
    }
  }

  test("pattern guard") {
    def simplifyAdd(e: Expr) = e match {
      case BinOp("+", x, y) if x == y => BinOp("*", x, Number(2))
      case _                          => e
    }
    assertEquals(
      simplifyAdd(BinOp("+", Number(1), Number(1))),
      BinOp("*", Number(1), Number(2))
    )
  }

  test("sealed classes") {
    // @unchecked: suppress exhausitivity checking
    def describe(e: Expr): String = (e: @unchecked) match {
      case Number(_) => "a number"
      case Var(_)    => "a variable"
    }
  }

  test("Option") {
    val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")
    assertEquals(capitals get "France", Some("Paris"))
    assertEquals(capitals get "North Pole", None)

    def show(x: Option[String]) = x match {
      case Some(s) => s
      case None    => "?"
    }
    assertEquals(show(capitals get "Japan"), "Tokyo")
    assertEquals(show(capitals get "North Pole"), "?")
  }

  //
  // patterns every where
  //

  test("patterns in variable definitions") {
    val myTuple = (123, "abc")
    val (number, string) = myTuple
    assertEquals(number, 123)
    assertEquals(string, "abc")

    val exp = BinOp("*", Number(5), Number(1))
    val BinOp(op, left, right) = exp
    assertEquals(op, "*")
    assertEquals(left, Number(5))
    assertEquals(right, Number(1))
  }

  test("case sequences as partial functions") {
    val withDefault: Option[Int] => Int = {
      case Some(x) => x
      case None    => 0
    }
    assertEquals(withDefault(Some(10)), 10)
    assertEquals(withDefault(None), 0)

    // // match may not be exhaustive.
    // // It would fail on the following inputs: List(_), Nil
    // val second: List[Int] => Int = {
    //   //
    //   case x :: y :: _ => y
    // }
    // assertEquals(second(List(5, 6, 7)), 6)
    // intercept[MatchError] {
    //   second(List())
    // }
    // partial function
    val second2: PartialFunction[List[Int], Int] = {
      //
      case x :: y :: _ => y
    }
    assert(second2.isDefinedAt(List(5, 6, 7)))
    assert(!second2.isDefinedAt(List()))
  }

  test("patterns in for expressions") {
    val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")
    for ((country, city) <- capitals)
      println(s"The capital of $country is $city")

    val results = List(Some("apple"), None, Some("orange"))
    // generated values that do not match the pattern are discarded
    for (Some(fruit) <- results) println(fruit)
  }
}
