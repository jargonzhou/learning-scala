import sbt._

object Dependencies {
  val SCALA_VERSION = "2.13.16"
  val SCALA_3_VERSION = "3.7.3"

  // https://mvnrepository.com/artifact/org.scala-lang/toolkit-test
  val toolkitTest = "org.scala-lang" %% "toolkit-test" % "0.7.0"

  // https://github.com/openjdk/jol
  val jol = "org.openjdk.jol" % "jol-core" % "0.17"

  // https://github.com/scala/scala-parser-combinators
  val scalaParserCombinators =
    "org.scala-lang.modules" %% "scala-parser-combinators" % "2.4.0"

  // https://github.com/com-lihaoyi/PPrint
  val pprint = "com.lihaoyi" %% "pprint" % "0.9.4"
}
