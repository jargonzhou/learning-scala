package example

// object Hello extends Greeting with App {
//   println(greeting)
// }

// trait Greeting {
//   lazy val greeting: String = "hello"
// }

import sbt._
import Keys._
import sbt.Plugins

object HelloPlugin extends AutoPlugin {
  // Determines whether this AutoPlugin will be activated for this project when the `requires` clause is satisfied.
  override def trigger = allRequirements

  // When an auto plugin provides a stable field such as `val` or `object` named `autoImport`,
  // the contents of the field are wildcard imported in `set`, `eval`, and `.sbt` files.
  object autoImport {
    val helloGreeting = settingKey[String]("greeting")
    val hello = taskKey[Unit]("say hello")
  }

  import autoImport._

  // The `Setting`s to add to the *global scope* exactly once if any project activates this AutoPlugin.
  override lazy val globalSettings: Seq[Setting[_]] = Seq(
    helloGreeting := "hi"
  )

  // The `Setting`s to add in the *scope* of each project that activates this AutoPlugin.
  override lazy val projectSettings: Seq[Setting[_]] = Seq(
    hello := {
      val s = streams.value
      val g = helloGreeting.value
      s.log.info(g)
    }
  )

  // The `Setting` to add to the *build scope* for each project that activates this AutoPlugin.
  // The settings returned here are guaranteed to be added to a given build scope only once (ThisBuild)
  // regardless of how many projects for that build activate this AutoPlugin.
  //
  // append commands auto to the build
  override lazy val buildSettings = Seq(commands += helloCommand)
  lazy val helloCommand =
    Command.command("hello") { (state: State) =>
      println("Hi!")
      state
    }

  // This AutoPlugin requires the plugins the Plugins matcher returned by this method. See [[trigger]].
  // plugin dependencies
  //
  // def requires: Plugins = plugins.JvmPlugin
  override def requires: Plugins = Plugins.empty
}
