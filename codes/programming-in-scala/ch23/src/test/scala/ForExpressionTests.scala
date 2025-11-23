import for_expressions._
import scala.{Int => n}

class ForExpressionTests extends munit.FunSuite {
  test("find mother child pair") {
    val lara = Person("Lara", false)
    val bob = Person("Bob", true)
    val julie = Person("Julie", false, lara, bob)
    val persons = List(lara, bob, julie)

    // filter: scala.collection.immutable.List#filter
    // flatMap: scala.collection.immutable.List#flatMap
    // map: scala.collection.IterableOps#map
    val result = persons filter (p => !p.isMale) flatMap (p =>
      (p.children map (c => (p.name, c.name)))
    )
    println(result) // List((Julie,Lara), (Julie,Bob))

    // withFilter: scala.collection.IterableOps#withFilter - avoid intermediate collection
    val result2 = persons withFilter (p => !p.isMale) flatMap (p =>
      (p.children map (c => (p.name, c.name)))
    )
    println(result2) // List((Julie,Lara), (Julie,Bob))

    // for-yield
    val result3 = for {
      p <- persons if !p.isMale
      c <- p.children
    } yield (p.name, c.name)
    println(result3) // List((Julie,Lara), (Julie,Bob))
  }

  test("multiple generators") {
    val result = for {
      x <- List(1, 2)
      y <- List("one", "two") // later generator vary more rapidly
    } yield (x, y)
    println(result)
    assertEquals(List((1, "one"), (1, "two"), (2, "one"), (2, "two")), result)
  }

  test("N-queens probleam") {
    def queens(n: Int): List[List[(Int, Int)]] = {
      // place queen at row k
      def placeQueens(k: Int): List[List[(Int, Int)]] =
        if (k == 0)
          List(List())
        else
          for {
            queens <- placeQueens(k - 1)
            column <- 1 to n
            queen = (k, column)
            if isSafe(queen, queens)
          } yield queen :: queens

      placeQueens(n)
    }

    // safe to place queen according to queens
    def isSafe(queen: (Int, Int), queens: List[(Int, Int)]) =
      queens forall (q => !inCheck(queen, q))

    // q1 and q2 in check/将军
    def inCheck(q1: (Int, Int), q2: (Int, Int)) =
      q1._1 == q2._1 || // same row
        q1._2 == q2._2 || // same column
        (q1._1 - q2._1).abs == (q1._2 - q2._2).abs // on diagonal

    def output_solution(solution: List[(Int, Int)]): Unit = {
      val n = solution.size
      val map = solution.toMap
      for {
        r <- 1 to n
        c <- 1 to n
      } {
        if (map.contains(r) && c == map(r))
          print("🔴")
        else
          print("◯")
        if (c == n) println()
      }
      println()
    }

    val solutions = queens(8)
    for {
      solution <- solutions
    } output_solution(solution)
  }

}
