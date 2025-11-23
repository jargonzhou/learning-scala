import sbt._
import org.scalablytyped.converter.plugin.ScalablyTypedPluginBase.autoImport._

object Workaround {
  /* Insert this in project scopes to work around
   * https://github.com/ScalablyTyped/Converter/issues/706
   */
  val hackScalablyTypedRemoveSourceFuture: Seq[Setting[_]] = {
    import org.scalablytyped.converter.internal.scalajs.Versions
    import org.scalablytyped.converter.internal.ZincCompiler

    /* First, we need to override stConversionOptions.versions with a hacked
     * subclass that gets rid of "-source:future".
     */

    // Yes, I'm extending a case class; I will burn in hell.
    class HackedVersions(orig: Versions)
        extends Versions(orig.scala, orig.scalaJs) {
      override val scalacOptions: List[String] =
        orig.scalacOptions.filterNot(_ == "-source:future")

      override def toString(): String =
        s"${super.toString()} hacked with $scalacOptions"
    }

    val conversionSetting: Setting[_] = stConversionOptions := {
      val prev = stConversionOptions.value
      prev.copy(versions = new HackedVersions(prev.versions))
    }

    /* Unfortunately, the internal stInternalZincCompiler task recreates its
     * own Versions object, so we will also have to patch that one.
     * This is much trickier, because there is no real public access to that
     * thing. We're on the JVM, though, so nothing is ever *really* private,
     * if we try hard enough.
     */

    // Get access to the private `inputs` field of ZincCompiler:
    // https://github.com/ScalablyTyped/Converter/blob/02257bf3588da08deec5a3b07f306fcc6236642d/sbt-converter/src/main/scala/org/scalablytyped/converter/internal/ZincCompiler.scala#L25
    val inputsField = classOf[ZincCompiler].getDeclaredField("inputs")
    inputsField.setAccessible(true)

    // Access to a private setting
    // https://github.com/ScalablyTyped/Converter/blob/02257bf3588da08deec5a3b07f306fcc6236642d/sbt-converter/src/main/scala/org/scalablytyped/converter/plugin/ScalablyTypedConverterExternalNpmPlugin.scala#L15C19-L15C97
    val stInternalZincCompiler =
      taskKey[ZincCompiler]("Hijack compiler settings")

    val zincCompilerSetting: Setting[_] = stInternalZincCompiler := {
      val prev = stInternalZincCompiler.value
      val prevInputs = inputsField.get(prev).asInstanceOf[xsbti.compile.Inputs]
      val prevScalacOptions = prevInputs.options().scalacOptions()
      val newScalacOptions = prevScalacOptions.filterNot(_ == "-source:future")
      val newOptions = prevInputs.options().withScalacOptions(newScalacOptions)
      val newInputs = prevInputs.withOptions(newOptions)

      // And brutally set the immutable field, because we can.
      // (What do you mean, that's less bad than extending a case class?)
      inputsField.set(prev, newInputs)

      prev
    }

    Def.settings(
      conversionSetting,
      zincCompilerSetting
    )
  }
}
