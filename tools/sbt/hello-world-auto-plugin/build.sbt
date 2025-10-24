import Dependencies._

// sbt plugins must be compiled with Scala 2.12.x that sbt itself is compiled in.
// By NOT specifying scalaVersion, sbt will default to the Scala version suited for a plugin.

ThisBuild / scalaVersion := "2.12.20"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.spike.sbt"
ThisBuild / organizationName := "spike"

lazy val root = (project in file("."))
  .enablePlugins(SbtPlugin) // enable SbtPlugin to make auto plugin
  .settings(
    name := "hello-world-auto-plugin",
    libraryDependencies += munit % Test
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
