import Dependencies._

// ThisBuild / scalaVersion := SCALA_VERSION
ThisBuild / scalaVersion := SCALA_3_VERSION

ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.spile"
ThisBuild / organizationName := "spike"

lazy val root = (project in file("."))
  .aggregate(
    ch02,
    ch02_3,
    ch03,
    ch04,
    ch04_3,
    ch05,
    ch06,
    ch07,
    ch08,
    ch09,
    ch10,
    ch11,
    ch12,
    ch13,
    ch14,
    ch15,
    ch16,
    ch17,
    ch18,
    ch19,
    ch20,
    ch21,
    ch22,
    ch22_3, // extension methods
    ch23,
    ch24,
    ch25,
    ch26,
    ch27,
    ch28,
    ch29,
    ch30,
    ch31,
    ch32,
    ch33,
    ch34,
    ch35
  )
  .settings(
    name := "programming-in-scala",
    scalaVersion := SCALA_3_VERSION,
    libraryDependencies += toolkitTest % Test
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.

lazy val ch02 = (project in file("ch02"))
  .settings(
    name := "ch02",
    scalaVersion := SCALA_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch02_3 = (project in file("ch02_3"))
  .settings(
    name := "ch02_3",
    scalaVersion := SCALA_3_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch03 = (project in file("ch03"))
  .settings(
    name := "ch03",
    scalaVersion := SCALA_VERSION,
    libraryDependencies ++= Seq(
      toolkitTest % Test,
      jol
    )
  )

lazy val ch04 = (project in file("ch04"))
  .settings(
    name := "ch04",
    scalaVersion := SCALA_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch04_3 = (project in file("ch04_3"))
  .settings(
    name := "ch04_3",
    scalaVersion := SCALA_3_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch05 = (project in file("ch05"))
  .settings(
    name := "ch05",
    scalaVersion := SCALA_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch06 = (project in file("ch06"))
  .settings(
    name := "ch06",
    scalaVersion := SCALA_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch07 = (project in file("ch07"))
  .settings(
    name := "ch07",
    scalaVersion := SCALA_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch08 = (project in file("ch08"))
  .settings(
    name := "ch08",
    scalaVersion := SCALA_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch09 = (project in file("ch09"))
  .settings(
    name := "ch09",
    scalaVersion := SCALA_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch10 = (project in file("ch10"))
  .settings(
    name := "ch10",
    scalaVersion := SCALA_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch11 = (project in file("ch11"))
  .settings(
    name := "ch11",
    scalaVersion := SCALA_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch12 = (project in file("ch12"))
  .dependsOn(ch06)
  .settings(
    name := "ch12",
    scalaVersion := SCALA_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch13 = (project in file("ch13"))
  .settings(
    name := "ch13",
    scalaVersion := SCALA_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch14 = (project in file("ch14"))
  .settings(
    name := "ch14",
    scalaVersion := SCALA_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch15 = (project in file("ch15"))
  .dependsOn(ch10)
  .settings(
    name := "ch15",
    scalaVersion := SCALA_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch16 = (project in file("ch16"))
  .settings(
    name := "ch16",
    scalaVersion := SCALA_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch17 = (project in file("ch17"))
  .settings(
    name := "ch17",
    scalaVersion := SCALA_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch18 = (project in file("ch18"))
  .settings(
    name := "ch18",
    scalaVersion := SCALA_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch19 = (project in file("ch19"))
  .settings(
    name := "ch19",
    scalaVersion := SCALA_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch20 = (project in file("ch20"))
  .settings(
    name := "ch20",
    scalaVersion := SCALA_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch21 = (project in file("ch21"))
  .settings(
    name := "ch21",
    scalaVersion := SCALA_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch22 = (project in file("ch22"))
  .settings(
    name := "ch22",
    scalaVersion := SCALA_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch22_3 = (project in file("ch22_3"))
  .settings(
    name := "ch22_3",
    scalaVersion := SCALA_3_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch23 = (project in file("ch23"))
  .settings(
    name := "ch23",
    scalaVersion := SCALA_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch24 = (project in file("ch24"))
  .settings(
    name := "ch24",
    scalaVersion := SCALA_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch25 = (project in file("ch25"))
  .settings(
    name := "ch25",
    scalaVersion := SCALA_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch26 = (project in file("ch26"))
  .settings(
    name := "ch26",
    scalaVersion := SCALA_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch27 = (project in file("ch27"))
  .settings(
    name := "ch27",
    scalaVersion := SCALA_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch28 = (project in file("ch28"))
  .settings(
    name := "ch28",
    scalaVersion := SCALA_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch29 = (project in file("ch29"))
  .settings(
    name := "ch29",
    scalaVersion := SCALA_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch30 = (project in file("ch30"))
  .settings(
    name := "ch30",
    scalaVersion := SCALA_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch31 = (project in file("ch31"))
  .settings(
    name := "ch31",
    scalaVersion := SCALA_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch32 = (project in file("ch32"))
  .settings(
    name := "ch32",
    scalaVersion := SCALA_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch33 = (project in file("ch33"))
  .settings(
    name := "ch33",
    scalaVersion := SCALA_VERSION,
    libraryDependencies ++= Seq(
      toolkitTest % Test,
      scalaParserCombinators,
      pprint
    )
  )

lazy val ch34 = (project in file("ch34"))
  .settings(
    name := "ch34",
    scalaVersion := SCALA_VERSION,
    libraryDependencies += toolkitTest % Test
  )

lazy val ch35 = (project in file("ch35"))
  .settings(
    name := "ch35",
    scalaVersion := SCALA_VERSION,
    libraryDependencies += toolkitTest % Test
  )
