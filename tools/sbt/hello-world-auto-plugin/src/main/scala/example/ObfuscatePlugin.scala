package example

import sbt._
import sbt.Keys._

object ObfuscatePlugin extends AutoPlugin {
  object autoImport {
    val obfuscate = taskKey[Seq[File]]("obfuscate files.")
    val obfuscateLiterals = settingKey[Boolean]("obfuscate literals.")

    lazy val baseObfuscateSettings: Seq[Def.Setting[_]] = Seq(
      obfuscate := {
        Obfuscate(sources.value, (obfuscate / obfuscateLiterals).value)
      },
      obfuscate / obfuscateLiterals := false
    )
  }

  import autoImport._
  override def requires: Plugins = sbt.plugins.JvmPlugin

  override def trigger: PluginTrigger = allRequirements

  override val projectSettings: Seq[Setting[_]] =
    inConfig(Compile)(baseObfuscateSettings) ++
      inConfig(Test)(baseObfuscateSettings)

}

object Obfuscate {
  def apply(sources: Seq[File], obfuscateLiterals: Boolean): Seq[File] = {
    // TODO obfuscate stuff!
    sources
  }
}
