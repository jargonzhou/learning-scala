# sbt
* https://www.scala-sbt.org/
* https://github.com/sbt/sbt

> sbt: A simple build tool

Features of sbt 
* Little or no configuration required for simple projects
* Scala-based **build definition** that can use the full flexibility of Scala code
* Accurate incremental recompilation using information extracted from the compiler
* **Library management support** using Coursier
* Continuous compilation and testing with **triggered execution**
* Supports mixed Scala/**Java** projects
* Supports **testing** with ScalaCheck, specs, and ScalaTest. JUnit is supported by a plugin.
* Starts the Scala REPL with project classes and dependencies on the classpath
* Modularization supported with **sub-projects**
* External project support (list a git repository as a dependency!)
* **Parallel task execution**, including parallel test execution

# Skaffold
* [Getting Started with Scala and sbt on the Command Line](https://docs.scala-lang.org/getting-started/sbt-track/getting-started-with-scala-and-sbt-on-the-command-line.html)

```shell
$ sbt new

Welcome to sbt new!
Here are some templates to get started:
 a) scala/toolkit.local               - Scala Toolkit (beta) by Scala Center and VirtusLab
 b) typelevel/toolkit.local           - Toolkit to start building Typelevel apps
 c) sbt/cross-platform.local          - A cross-JVM/JS/Native project
 d) scala/scala3.g8                   - Scala 3 seed template
 e) scala/scala-seed.g8               - Scala 2 seed template
 f) playframework/play-scala-seed.g8  - A Play project in Scala
 g) playframework/play-java-seed.g8   - A Play project in Java
 i) softwaremill/tapir.g8             - A tapir project using Netty
 m) scala-js/vite.g8                  - A Scala.JS + Vite project
 n) holdenk/sparkProjectTemplate.g8   - A Scala Spark project
 o) spotify/scio.g8                   - A Scio project
 p) disneystreaming/smithy4s.g8       - A Smithy4s project
 q) quit
Select a template:

# Scala 2
$ sbt new scala/hello-world.g8 # scala/scala-seed.g8 
# Scala 3
$ sbt new scala/scala3.g8
```

## Giter8
* https://www.foundweekends.org/giter8/index.html
* https://github.com/foundweekends/giter8

> Giter8 is a command line tool to generate files and directories from templates published on GitHub or any other git repository. It’s implemented in Scala and runs through the [sbt launcher](https://www.scala-sbt.org/1.x/docs/Setup.html), but it can produce output for any purpose.

**StringTemplate** is the engine that applies Giter8 templates.
- [StringTemplate](https://www.stringtemplate.org/)
- https://github.com/playframework/play-scala-seed.g8

[community-maintained Giter8 templates](https://github.com/search?o=desc&p=1&q=g8&s=stars&type=Repositories)
```shell
$ sbt new scala/scala-seed.g8
$ sbt new playframework/play-scala-seed.g8
$ sbt new akka/akka-http-quickstart-scala.g8
$ sbt new http4s/http4s.g8
$ sbt new holdenk/sparkProjectTemplate.g8
```

## Build definition
* https://www.scala-sbt.org/1.x/docs/Basic-Def.html

A build definition is defined in `build.sbt`, and it consists of a set of projects (of type `Project`).

```scala
// default imports
import sbt._
import Keys._

val derby = "org.apache.derby" % "derby" % "10.4.1.3"

// bare style: instead of put inside .setttings(...) call.
ThisBuild / organization := "com.example"
ThisBuild / scalaVersion := "2.12.18"
ThisBuild / version      := "0.1.0-SNAPSHOT"

// setting expression
// [key] [operator] [(setting/task) body]
// example:
// organization := { "com.example" }

lazy val root = (project in file("."))
  // settings: use key-value pairs
  .settings(
    name := "Hello", // type: SettingKey[String]
    scalaVersion := "2.12.7",
    libraryDependencies += derby // library dependencies
  )

// can use: val, lazy val, def
// not allowed: top-level object and class. instead as Scala source files in project/ directory.
```

### Keys

A key is an instance of `SettingKey[T]`, `TaskKey[T]`, or `InputKey[T]` where `T` is the expected value type.
- `SettingKey[T]`: a key for a value evaluated only once (the value is computed when loading the subproject, and kept around).
- `TaskKey[T]`: a key for a value, called a **task**, that is evaluated each time it’s referred to (similarly to a scala function), potentially with side effects.
  - Tasks are operations such as `compile` or `package`. 
  - They may return `Unit` (`Unit` is `void` for Scala), or they may return a value related to the task, for example `package` is a `TaskKey[File]` and its value is the jar file it creates.
  - Each time you start a task execution, for example by typing `compile` at the interactive sbt prompt, sbt will re-run any tasks involved exactly once.
- `InputKey[T]`: a key for a task that has command line arguments as input.

build-in keys: A `build.sbt` implicitly has an import `sbt.Keys._`.

Custom keys: `settingKey`, `taskKey`, and `inputKey`.
```scala
// All such definitions are evaluated before settings regardless of where they are defined in the file.
// Typically, lazy vals are used instead of vals to avoid initialization order problems.
lazy val hello = taskKey[Unit]("An example task")

lazy val root = (project in file("."))
  .settings(
    hello := { println("Hello!") }
  )

// a setting can’t depend on a task, because a setting is evaluated only once on project load and is not re-run.
// taskKey := 42 results in a Setting[Task[T]]
// settingKey := 42 results in a Setting[T]
```

Listing all available setting keys and task keys:
```shell
> settings
> settings -v
> <setting key>

> tasks
> tasks -v
> <task key>
# compile is a task key.
> compile

> help <key>
> inspect <key>
> show <task key>
```

### Appending values
Assignment with `:=` is the simplest transformation.

Appending to previous values: `+=` and `++=`.
- `+=` will append a single element to the sequence.
- `++=` will concatenate another sequence.
```scala
Compile / sourceDirectories += new File("source")
Compile / sourceDirectories += file("source")
Compile / sourceDirectories ++= Seq(file("sources1"), file("sources2"))
Compile / sourceDirectories := Seq(file("sources1"), file("sources2"))

cleanFiles += file("coverage-report-" + name.value + ".txt")
```

Tasks based on other keys’ values: You can compute values of some tasks or settings to define or append a value for another task. It’s done by using `Def.task` as an argument to `:=`, `+=`, or `++=`.
```scala
Compile / sourceGenerators += Def.task {
  myGenerator(baseDirectory.value, (Compile / managedClasspath).value)
}
```

### Custom settings and tasks

`Keys` is packed with examples illustrating how to define keys. Most of the keys are implemented in `Defaults`.
Keys may be defined in an `.sbt` file, a `.scala` file, or in an *auto plugin*. Any `val`s found under `autoImport` object of an enabled auto plugin will be imported automatically into your `.sbt` files.

Implementing a task
- If the task has dependencies, you’d reference their value using value, as discussed in [task graph](#task-graph).
- sbt has some utility libraries and convenience functions, in particular you can often use the convenient APIs in `IO` to manipulate files and directories.
```scala
val sampleStringTask = taskKey[String]("A sample string task.")
val sampleIntTask = taskKey[Int]("A sample int task.")

ThisBuild / organization := "com.example"
ThisBuild / version      := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.12.18"

lazy val library = (project in file("library"))
  .settings(
    sampleStringTask := System.getProperty("user.home"),
    sampleIntTask := {
      val sum = 1 + 2
      println("sum: " + sum)
      sum
    }
  )
```

Execution semantics of tasks
- Unlike plain Scala method calls, invoking `value` method on tasks will **not be evaluated strictly**. Instead, they simply act as placeholders to denote that `sampleIntTask` **depends on** `startServer` and `stopServer` tasks. 
sbt’s tasks engine will:
- evaluate the task dependencies before evaluating sampleIntTask (**partial ordering**)
- try to evaluate task dependencies in parallel if they are independent (**parallelization**)
- each task dependency will be evaluated once and only once per command execution (**deduplication**)
```scala
val startServer = taskKey[Unit]("start server")
val stopServer = taskKey[Unit]("stop server")
val sampleIntTask = taskKey[Int]("A sample int task.")
val sampleStringTask = taskKey[String]("A sample string task.")

ThisBuild / organization := "com.example"
ThisBuild / version      := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.12.18"

lazy val library = (project in file("library"))
  .settings(
    startServer := {
      println("starting...")
      Thread.sleep(500)
    },
    stopServer := {
      println("stopping...")
      Thread.sleep(500)
    },
    sampleIntTask := {
      startServer.value
      val sum = 1 + 2
      println("sum: " + sum)
      stopServer.value // THIS WON'T WORK
      sum
    },
    sampleStringTask := {
      startServer.value
      val s = sampleIntTask.value.toString
      println("s: " + s)
      s
    }
  )
```
Use plain Scala: make sure that something happens after some other thing
```scala
// project/ServerUtil.scala

sampleIntTask := {
  ServerUtil.startServer
  try {
    val sum = 1 + 2
    println("sum: " + sum)
  } finally {
    ServerUtil.stopServer
  }
  sum
}
```
If you find you have a lot of custom code, consider moving it to a **plugin** for re-use across multiple builds.

## Directory structure
* https://www.scala-sbt.org/1.x/docs/Directories.html

```shell
# root project's base directory
build.sbt                      # sbt build definition files: 
                               #   part of the source code for meta-build's root project inside project/
project/                       # Build support files: base directory of meta-build's root project
  build.properties             # Specifying the sbt versions
  Dependencies.scala           # a source file in the meta-build's root project
  assembly.sbt                 # part of the source code for meta-meta-build's root project in project/project
  project/                     # base directory of meta-meta-build's root project
    MetaDeps.scala             # source file in the root project of meta-meta-build in project/project/
target                         # Build products
hello/app.scala                # Source code for small projects
src/                           # Maven
  main/
    resources/
       <files to include in main jar here>
    scala/
       <main Scala sources>
    scala-2.12/
       <main Scala 2.12 specific sources>
    java/
       <main Java sources>
  test/
    resources
       <files to include in test jar here>
    scala/
       <test Scala sources>
    scala-2.12/
       <test Scala 2.12 specific sources>
    java/
       <test Java sources>s
```

example:
- `project/Dependencies.scala`
```scala
import sbt._

object Dependencies {
  // Versions
  lazy val akkaVersion = "2.6.21"

  // Libraries
  val akkaActor = "com.typesafe.akka" %% "akka-actor" % akkaVersion
  val akkaCluster = "com.typesafe.akka" %% "akka-cluster" % akkaVersion
  val specs2core = "org.specs2" %% "specs2-core" % "4.20.0"

  // Projects
  val backendDeps =
    Seq(akkaActor, specs2core % Test)
}
```
- `build.sbt`
```scala
import Dependencies._

ThisBuild / organization := "com.example"
ThisBuild / version      := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.12.18"

lazy val backend = (project in file("backend"))
  .settings(
    name := "backend",
    libraryDependencies ++= backendDeps
  )
```
- `project/*.scala`
```scala
// By defining triggered plugins, auto plugins can be used as a convenient way to inject custom tasks and commands across all subprojects.
```

## Multi-project builds
* https://www.scala-sbt.org/1.x/docs/Multi-Project.html

```scala
// build-wide settings
ThisBuild / organization := "com.example"
ThisBuild / version      := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.12.18"

lazy val util = (project in file("util"))
lazy val core = (project in file("core"))
// the base directory may be omitted if it’s the same as the name of the val
lazy val util = project
lazy val core = project

// common settings
lazy val commonSettings = Seq(
  target := { baseDirectory.value / "target2" }
)

// aggregation: run a task on the aggregate project will also run it on the aggregated projects
//
// default root project
// If a project is not defined for the root directory in the build, sbt creates a default one that aggregates all other projects in the build.
lazy val root = (project in file("."))
  .aggregate(util, core)
  .settings(
    // avoid aggregating the update task
    // update / aggregate is the aggregate key scoped to the update task
    update / aggregate := false
  )

lazy val core = (project in file("core"))
  // A project may depend on code in another project: dependsOn(bar, baz)
  // explicitly: dependsOn(util % "compile->compile")
  // compile configuration in core depend on cimpile configuration in util
  // Omitting the ->config part implies ->compile
  // example:
  // dependsOn(util % "test")
  // dependsOn(util % "test->test;compile->compile")
  .dependsOn(util) 
  .settings(
    commonSettings,
    // other settings
  )

lazy val util = (project in file("util"))
  .settings(
    commonSettings,
    // other settings
  )
```

build-wide settings
- `ThisBuild` acts as a special subproject name that you can use to define default value for the build. 
- When you define one or more subprojects, and when the subproject does not define `scalaVersion` key, it will look for `ThisBuild / scalaVersion`.
- The limitation is that the right-hand side needs to be a pure value or settings scoped to `Global` or `ThisBuild`, and there are no default settings scoped to subprojects.

Inter-project dependencies
```scala
ThisBuild / trackInternalDependencies := TrackLevel.TrackIfMissing
ThisBuild / exportJars := true

lazy val root = (project in file("."))
  .aggregate(....)

// exportToInternal: allows the dependee subprojects to opt out of the internal tracking
lazy val dontTrackMe = (project in file("dontTrackMe"))
  .settings(
    exportToInternal := TrackLevel.NoTracking
  )
```
`trackInternalDependencies`, `exportToInternal`: control whether a dependent subproject should trigger compilation of its dependencies when you call `compile`
- `TrackLevel.TrackIfMissing`: sbt will no longer try to compile internal (inter-project) dependencies automatically, unless there are no `*.class` files (or JAR file when `exportJars` is `true`) in the output directory.
- `TrackLevel.NoTracking`:  the compilation of internal dependencies will be skipped.
- `TrackLevel.TrackAlways`


```shell
# list projects
> projects
# select a current project
> project <projectname>
# compile current project
> compile
# compile another project
> subProjectID/compile
```

Style choices:
- Each subproject’s settings can go into `*.sbt` files in the base directory of that project, while the root `build.sbt` declares only minimum project declarations in the form of `lazy val foo = (project in file("foo"))` without the settings.
- Recommend: putting all project declarations and settings in the root `build.sbt` file in order to keep all build definition under a single file.

## Task graph
* https://www.scala-sbt.org/1.x/docs/Task-Graph.html

Terminology
- **Setting/Task expression**: entry inside `.settings(...)`.
- **Key**: Left hand side of a setting expression. It could be a `SettingKey[A]`, a `TaskKey[A]`, or an `InputKey[A]`.
- **Setting**: Defined by a setting expression with `SettingKey[A]`. The value is calculated once during load.
- **Task**: Defined by a task expression with `TaskKey[A]`. The value is calculated each time it is invoked.

### `value` method
- in `build.sbt` DSL, express the dependency to another task or setting.
- may only be called in the argument to `:=`, `+=`, `++=`.
```scala
scalacOptions := {
  val ur = update.value  // update task happens-before scalacOptions
  val x = clean.value    // clean task happens-before scalacOptions
  // ---- scalacOptions begins here ----
  ur.allConfigurations.take(3)
}
```
> `.value` is not a normal Scala method call. `build.sbt` DSL uses a **macro** to lift these outside of the task body. Both `update` and `clean` tasks are **completed** by the time task engine evaluates the opening `{` of `scalacOptions` regardless of which line it appears in the body.

more examples:
```scala
// scalacOptions depends on update, clean
val scalacOptions = taskKey[Seq[String]]("Options for the Scala compiler.")
val update = taskKey[UpdateReport]("Resolves and optionally retrieves dependencies, producing a report.")
val clean = taskKey[Unit]("Deletes files produced by the build, such as generated sources, compiled classes, and task caches.")

ThisBuild / organization := "com.example"
ThisBuild / scalaVersion := "2.12.18"
ThisBuild / version      := "0.1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .settings(
    name := "Hello",
    scalacOptions := {
      val out = streams.value // streams task happens-before scalacOptions
      val log = out.log
      log.info("123")
      val ur = update.value   // update task happens-before scalacOptions
      log.info("456")
      ur.allConfigurations.take(3)
    }
  )
```
```shell
> scalacOptions
[info] Updating {file:/xxx/}root...
[info] Resolving jline#jline;2.14.1 ...
[info] Done updating.       # update task happens
[info] 123
[info] 456
```
```scala
// no order guarantee about update and clean tasks
// clean task runs even inside if (false)
scalacOptions := {
  val ur = update.value  // update task happens-before scalacOptions
  if (false) {
    val x = clean.value  // clean task happens-before scalacOptions
  }
  ur.allConfigurations.take(3)
}

// inline .value calls
scalacOptions := {
  val x = clean.value
  update.value.allConfigurations.take(3)
}
```

inspect tasks
```shell
> inspect <task key>
> inspect tree <task key>
# example
> inspect scalacOptions
> inspect tree compile
```

### key dependencies

1. Defining a task that depends on other settings
- a setting key can’t depend on a task key
```scala
lazy val root = (project in file("."))
  .settings(
    name := "Hello",
    organization := "com.example",
    scalaVersion := "2.12.18",
    version := "0.1.0-SNAPSHOT",
    scalacOptions := List("-encoding", "utf8", "-Xfatal-warnings", "-deprecation", "-unchecked"),
    scalacOptions := {
      val old = scalacOptions.value
      // filter out "-Xfatal-warnings" and "-deprecation" for non-2.12
      scalaBinaryVersion.value match {
        case "2.12" => old
        case _      => old filterNot (Set("-Xfatal-warnings", "-deprecation").apply)
      }
    }
  )

// The scalacOptions task may be defined in terms of the checksums setting
scalacOptions := checksums.value
// Bad example: The checksums setting cannot be defined in terms of the scalacOptions task!
checksums := scalacOptions.value
```

2. Defining a setting that depends on other settings
```scala
// name our organization after our project (both are SettingKey[String])
organization := name.value

// rewires Compile / scalaSource key to a different directory only when scalaBinaryVersion is "2.11"
Compile / scalaSource := {
  val old = (Compile / scalaSource).value
  scalaBinaryVersion.value match {
    case "2.11" => baseDirectory.value / "src-2.11" / "main" / "scala"
    case _      => old
  }
}
```

### build.sbt DSL

We use the `build.sbt` domain-specific language (DSL) to construct **a DAG of settings and tasks**.
This structure is common to Make (1976), Ant (2000), and Rake (2003).

flow-based programming
- **de-duplication**: with flow-based programming, a task is executed only once even when it is depended by multiple tasks.
- **parallel processing**: using the task graph, the task engine can schedule mutually non-dependent tasks in parallel.
- **the separation of concern and the flexibility**: the task graph lets *the build user* wire the tasks together in different ways, while *sbt and plugins* can provide various features such as compilation and library dependency management as functions that can be reused.

## Scopes

Each key can have an associated value in more than one context, called a **scope**.
- There is no single value for a given key name, because the value may differ according to scope.
- However, there is a single value for a given scoped key.

Scope axes: a type constructor similar to `Option[A]`, that is used to form a component in a scope
- The **subproject** axis
  - `ThisBuild`: the entire build
- The **dependency configuration** axis
  - a graph of library dependencies: with itw own classpath, sources, generated packaes, etc.
  - example: `Compile`, `Test`, `Runtime`
  - configuration extension ![](https://www.scala-sbt.org/1.x/docs/files/sbt-configurations.png)
- The **task** axis
  - example: `packageSrc` task affected by `packageOptions` setting.
```scala
// a full scope: subproject / configuration / task / key
// example
projA / Compile / console / scalacOptions
```

`Zero` scope component: a universal fallback for all scope axes
```scala
Global somekey // Zero / Zero / Zero / someKey
```

Referring to scopes in a build definition
```scala
// current subproject / Zero / Zero
organization := name.value

lazy val root = (project in file("."))
  .settings(
    // current subproject / Zero / Zero
    name := "hello"
  )

// configuration
Compile / name := "hello"
// task
packageBin / name := "hello"
// configuration / task
Compile / packageBin / name := "hello"
// same as Zero / Zero / Zero / concurrentRestrictions
Global / concurrentRestrictions := Seq(
  Tags.limitAll(1)
)
```

Referring to scoped keys from the sbt shell
```scala
ref / Config / intask / key
```
- `ref` identifies the subproject axis. It could be `<project-id>`, `ProjectRef(uri("file:..."), "id")`, or `ThisBuild` that denotes the “entire build” scope.
- `Config` identifies the configuration axis using the capitalized Scala identifier.
- `intask` identifies the task axis.
- `key` identifies the key being scoped.
- `Zero` can appear for each axis.
```scala
// specifies just a key, so the default scopes are used: current project, a key-dependent configuration, and Zero task scope.
fullClasspath
// specifies the configuration, so this is fullClasspath in the Test configuration, with defaults for the other two scope axes.
Test / fullClasspath
// specifies the project root, where the project is identified with the project id.
root / fullClasspath
// specified the project root, and specifies Zero for the configuration, rather than the default configuration.
root / Zero / fullClasspath 
// specifies the fullClasspath key scoped to the doc task, with the defaults for the project and configuration axes.
doc / fullClasspath
// specifies a project ProjectRef(uri("file:/tmp/hello/"), "root"). Also specifies configuration Test, leaves the default task axis.
ProjectRef(uri("file:/tmp/hello/"), "root") / Test / fullClasspath 
// sets the subproject axis to “entire build” where the build is ThisBuild, with the default configuration.
ThisBuild / version 
// sets the subproject axis to Zero, with the default configuration.
Zero / fullClasspath 
// sets all three scope axes.
root / Compile / doc / fullClasspath
```

Inspecting scopes
```shell
# example
> inspect Test / fullClasspath
> inspect fullClasspath
> inspect ThisBuild / Zero / fullClasspath
```

If a key that is scoped to a particular subproject is not found, sbt will look for it in `ThisBuild` as a fallback.
For each scope axis, sbt has a fallback search path made up of other scope values. Typically, if a key has no associated value in a more-specific scope, sbt will **try to get a value from a more general scope**, such as the `ThisBuild` scope.

### Scope delegation (.value lookup)
* https://www.scala-sbt.org/1.x/docs/Scope-Delegation.html

> TODO

## Library dependencies
* https://www.scala-sbt.org/1.x/docs/Library-Dependencies.html

depdendency category:
- **unmanaged dependencies** are jars dropped into the `lib` directory
  - Dependencies in lib go on all the classpaths (for `compile`, `test`, `run`, and `console`). 
  - `unmanagedJars` task lists the jars from the `unmanagedBase` directory
- **managed dependencies** are configured in the build definition and downloaded automatically from repositories
  - sbt uses [Coursier](../Coursier.md) to implement managed dependencies
  - list your dependencies in the setting `libraryDependencies`, or
  - [use external Maven POM file or Ivy configuration file](https://www.scala-sbt.org/1.x/docs/Library-Management.html#External+Maven+or+Ivy)

```scala
// custom unmanaged dependency directory
unmanagedBase := baseDirectory.value / "custom_lib"

// empty the jars list for Compile configuration
Compile / unmanagedJars := Seq.empty[sbt.Attributed[java.io.File]]
```

`libraryDependencies`:
- `+=`: append. see 'Task Graph'
- `%`: construct an Ivy module ID from strings.

```scala
// declaration in Keys
val libraryDependencies = settingKey[Seq[ModuleID]]("Declares managed dependencies.")

// % methods create ModuleID from strings
// groupID, artifactID, revision: strings
libraryDependencies += groupID % artifactID % revision
// configuration: string or Configuration value(ex Test)
// examples: "test", Test
libraryDependencies += groupID % artifactID % revision % configuration
// add a list of dependencies
libraryDependencies ++= Seq(
  groupID % artifactID % revision,
  groupID % otherID % otherRevision
)

// sbt will add your project’s binary Scala version(scalaVersion) to the artifact name
organization %% moduleName % version
// example:
"org.scala-stm" % "scala-stm_2.13" % "0.9.1"
"org.scala-stm" %% "scala-stm" % "0.9.1" // scalaVersion="2.13.12"
```

Ivy revisions
```scala
organization % moduleName % version
// version:
"1.6.1" // fixed revision
"latest.integration"
"2.9.+"
"[1.0,)"
```

[Resolvers](https://www.scala-sbt.org/1.x/docs/Resolvers.html): sbt uses the standard Maven2 repository by default
- `resolvers` does not contain the default resolvers; only additional ones added by your build definition.
- sbt combines `resolvers` with some default repositories to form `externalResolvers`.
```scala
// declaration in Keys
val resolvers = settingKey[Seq[Resolver]]("The user-defined additional resolvers for automatically managed dependencies.")

// resolvers += name at location
// at method create a Resolver from two strings
resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
resolvers += "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"
resolvers += Resolver.mavenLocal
```

## Using plugins
* https://www.scala-sbt.org/1.x/docs/Using-Plugins.html
* https://www.scala-sbt.org/1.x/docs/Plugins.html
* https://www.scala-sbt.org/1.x/docs/Plugins-Best-Practices.html
* https://www.scala-sbt.org/1.x/docs/Cross-Build-Plugins.html

A **plugin** extends the build definition, most commonly by adding new settings. The new settings could be new tasks.
- A plugin can be a library used to implement a **task**
- A plugin can define a sequence of sbt **settings** that are automatically added to all projects or that are explicitly declared for selected projects
- A plugin can define new **commands** (via the `commands` setting)

Declaring a plugin
```scala
// project/site.sbt
// plugin’s Ivy module ID
addSbtPlugin("com.typesafe.sbt" % "sbt-site" % "0.7.0")

// project/assembly.sbt
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.11.2")

// plugin repository
resolvers ++= Resolver.sonatypeOssRepos("public")
```

A plugin can declare that its settings be automatically added to the build definition, in which case you don’t have to do anything to add them.
- **Auto plugins** should document whether they need to be explicitly enabled.
- Older non-auto plugins often require settings to be added explicitly.
```scala
lazy val util = (project in file("util"))
  // explicitly define the auto plugins they wish to consume
  .enablePlugins(FooPlugin, BarPlugin)
  // exclude plugins
  .disablePlugins(plugins.IvyPlugin)
  .settings(
    name := "hello-util"
  )

// older non-auto plugins example: sbt-site 
// don't use the site plugin for the `util` project
lazy val util = (project in file("util"))
// enable the site plugin for the `core` project
lazy val core = (project in file("core"))
  .settings(site.settings)
```
inspect which auto plugins are enabled
```shell
> plugins
```

Global plugins: `$HOME/.sbt/1.0/plugins/`
- any `.sbt` or `.scala` files in `$HOME/.sbt/1.0/plugins/` behave as if they were in the `project/` directory for all projects.

### Available plugins
* https://www.scala-sbt.org/1.x/docs/Community-Plugins.html

### Auto plugin
sbt 0.13.5 introduces auto plugins, with improved dependency management among the plugins and explicitly scoped auto importing.

A **plugin definition** is a *project* under `project/` folder. This project’s classpath is the classpath used for build definitions in `project/` and any `.sbt` files in the project’s base directory. It is also used for the `eval` and `set` commands.

```shell
project/
  lib/                 # unmanaged dependencies
  *.scala              # sources
  plugins.sbt          # declare project denpendencies: managed, unmanaged 
  *.sbt

# build definition classpath searches for the descriptor files 
# containing the name of sbt.AutoPlugin implementations
sbt/sbt.autoplugins
```

```shell
# changes the current build to the (root) project’s project/ build definition
> reload plugins
# changes back to the original build
> reload return
```

An **auto plugin** is a module that defines settings to automatically inject into projects.
- Automatically import selective names to `.sbt` files and the `eval` and `set` commands.
- Specify plugin dependencies to other auto plugins.
- Automatically activate itself when all dependencies are present.
- Specify `projectSettings`, `buildSettings`, and `globalSettings` as appropriate.

An auto plugin can depend on other auto plugins and ensure these dependency settings are loaded first.
```scala
// SbtLessPlugin and SbtCoffeeScriptPlugin depends on SbtJsTaskPlugin, SbtWebPlugin, JvmPlugin
lazy val root = (project in file("."))
  .enablePlugins(SbtLessPlugin, SbtCoffeeScriptPlugin)
```

auto plugin example: [hello-world-auto-plugin](./hello-world-auto-plugin/README.md)


root plugins, triggered plugins
- Some plugins should always be explicitly enabled on projects. we call these **root plugins**, i.e. plugins that are “root” nodes in the plugin dependency graph. An auto plugin is by default a root plugin.
- Auto plugins also provide a way for plugins to automatically attach themselves to projects if their dependencies are met. We call these **triggered plugins**, and they are created by overriding the `trigger` method.

# API
* https://www.scala-sbt.org/1.x/api/sbt/index.html

# Command Line
* https://www.scala-sbt.org/1.x/docs/Running.html
* https://www.scala-sbt.org/1.x/docs/Command-Line-Reference.html

```shell
# sbt shell
$ sbt
> compile
# Continuous build and test
> ~testQuick

# batch model
$ sbt clean compile "testOnly TestA TestB"
```

## Triggered Execution
* https://www.scala-sbt.org/1.x/docs/Triggered-Execution.html

sbt provides the ability to monitor the input files for a particular task and repeat the task when changes to those files occur.

```shell
# Compile
> ~ Test / compile
> ~ compile

# Testing
# re-run only the tests that reference classes that have been re-compiled since the last test run
> ~ testQuick
# re-run only a particular test if its dependencies have changed
> ~ testQuick foo.BarTest
# re-run a test when source changes are detected regardless of whether the test depends on any of the updated source files
> ~ testOnly foo.BarTest
# run all of the tests in the project when any sources change
> ~test

# Running Multiple Commands
> ~ clean; test
```

```scala
// Build sources
Global / onChangedBuildSource := ReloadOnSourceChanges

// Clearing the screen
// clear the screen after an event is triggered
ThisBuild / watchTriggeredMessage := Watch.clearScreenOnTrigger
// clear the screen before running the task
ThisBuild  / watchBeforeCommand := Watch.

// Configuration
watchTriggers
watchTriggeredMessage
watchInputOptions
watchBeforeCommand
watchLogLevel
watchInputParser
watchStartMessage
watchOnIteration
watchForceTriggerOnAnyChange
watchPersistFileStamps
watchAntiEntropy
```

# SBT Native Packager
* https://www.scala-sbt.org/sbt-native-packager/
* https://github.com/sbt/sbt-native-packager

> sbt Native Packager

```scala
// project/plugins.sbt
addSbtPlugin("com.github.sbt" % "sbt-native-packager" % "1.11.4")

// build.sbt
enablePlugins(JavaAppPackaging)
```

```shell
# in hello-world
$ sbt stage
$ ./target/universal/stage/bin/hello-world 
Hello sbt!
The current temperature in New York is 15.9 C.
```

## packages
We can generate other packages via the following tasks. Note that each packaging format may needs some additional configuration and native tools available. Here’s a complete list of current formats.

- Universal/packageBin - Generates a universal zip file
- Universal/packageZipTarball - Generates a universal tgz file
- Debian/packageBin - Generates a deb
- Docker/publishLocal - Builds a Docker image using the local Docker server
- Rpm/packageBin - Generates an rpm
- Universal/packageOsxDmg - Generates a DMG file with the same contents as the universal zip/tgz.
- Windows/packageBin - Generates an MSI

# See Also
* [The essential Scala build tool tutorial](https://www.scalawilliam.com/essential-sbt/)

