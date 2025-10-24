import core.Weather
import scala.util.parsing.combinator._

object Main {
  def main(args: Array[String]): Unit = {
    // hello world
    println("Hello sbt!")

    // call methods in dependencies: scala-parser-combinators
    import SimpleParser._
    parse(freq, "johnny 121") match {
      case Success(matched, _) => println(matched)
      case Failure(msg, _)     => println(s"FAILURE: $msg")
      case Error(msg, _)       => println(s"ERROR: $msg")
    }

    // call methods in core subproject
    val temp = Weather.temp()
    println(s"The current temperature in New York is $temp C.")
  }
}
