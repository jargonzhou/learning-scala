import abstract_members._

class AbstractMembersTests extends munit.FunSuite {
  test("initialize abstract vals") {
    val x = 2
    interceptMessage[IllegalArgumentException]("requirement failed") {
      new RationalTrait {
        val numerArg = 1 * x
        val denomArg = 2 * x
      }
    }
  }

  test("pre-initialized fields") {
    val x = 2
    // Listing 20.5 pre-initialized fields in an anonymous class expression
    new {
      val numerArg = 1 * x
      val denomArg = 2 * x
    } with RationalTrait

    // Listing 20.6 pre-initialized fields in an object definition
    object towThirds
        extends {
          val numerArg = 2
          val denomArg = 3
        }
        with RationalTrait

    // Listing 20.7 pre-initialized fields in a class definition
    class RationalClass(n: Int, d: Int)
        extends {
          val numerArg = n
          val denomArg = d
        }
        with RationalTrait {
      def +(that: RationalClass) = new RationalClass(
        numer * that.denom + that.numer * denom,
        denom * that.denom
      )
    }

    val o = new {
      val numerArg = 1
      // value numerArg is not a member of AbstractMembersTests
      // val denomArg = this.numerArg * 2
      val denomArg = numerArg * 2
    } with RationalTrait
  }

  test("lazy vals") {
    val x = 2
    new LazyRationalTrait {
      val numerArg = 1 * x
      val denomArg = 2 * x
    }
  }
}
