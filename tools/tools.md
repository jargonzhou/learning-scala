# Scala Tools

# Project
* [almond](./almond.md): A Scala kernel for Jupyter.
* [Coursier](./Coursier.md): Pure Scala Artifact Fetching.
* [Scala CLI](./ScalaCLI/ScalaCLI.md): a command-line tool to interact with the Scala language. It lets you compile, run, test, and package your Scala code (and more!)
* [Scala REPL](https://docs.scala-lang.org/overviews/repl/overview.html): The Scala REPL is a tool (`scala`) for evaluating expressions in Scala.
* [Scala Steward](https://github.com/scala-steward-org/scala-steward): Scala Steward is a bot that helps you keep your library dependencies and build plugins up-to-date. It works with Maven, Mill, sbt, and Scala CLI.
* [Scala Toolkit](./ScalaToolkit.md): a set of libraries designed to effectively perform common programming tasks.
* [Scaladex](https://index.scala-lang.org/): The Scala Library Index.
* [Scaladoc](./Scaladoc.md): 
* [ScalaFiddle](https://github.com/scalafiddle/scalafiddle-editor): an online playground for creating, sharing and embedding Scala fiddles (little Scala programs that run directly in your browser).
* [Scastie](./Scastie.md): an interactive playground for Scala with support for sbt configuration.
* [sbt](./sbt/sbt.md): A simple build tool.

# Libraries
* [http4s](./lib/http4s.md)
* [reftree](./lib/reftree.ipynb): Automatically generated diagrams and animations for Scala data structures.
* [ScalaSTM](./lib/ScalaSTM.md): ScalaSTM is a lightweight software transactional memory for Scala, inspired by the STMs in Haskell and Clojure.
* [scalaz](./lib/scalaz.md): Principled Functional Programming in Scala.
* [smithy4s](https://github.com/disneystreaming/smithy4s): Smithy tooling for Scala.
  * [example](https://blog.indoorvivants.com/2022-06-10-smithy4s-fullstack-part-1)
* [Vegas](./lib/Vegas.ipynb): The missing MatPlotLib for Scala + Spark
  * [Vega-Lite](https://vega.github.io/vega-lite/): A Grammar of Interactive Graphics

## Artima
* https://www.artima.com/products

Products
* [ScalaTest](./lib/Artima/ScalaTest.md): a free, open-source testing toolkit for Scala and Java programmers.
* [Scalactic](https://www.scalactic.org/): Utilities related to quality and functional programming, to help you keep your code clear and correct.
* [SuperSafe™](https://www.artima.com/supersafe_user_guide.html): A Scala Compiler plugin to detect certain types of bugs early, before they can slip into production.

## The lihaoyi Scala Platform
[The `lihaoyi` platform](https://github.com/com-lihaoyi) lets you write Scala in an easy and productive way while delivering real business value. It provides all the core building blocks a typical software engineer needs day to day: HTTP clients and servers, JSON/binary data serialization, filesystem operations, CLI argument parsing, build tooling, etc. These can be combined in a variety of ways to perform many useful real-world tasks:
- Build a website with `Cask`, `ScalaSql`, and `Scalatags` or API server with `Cask`, `ScalaSql`, and `uPickle`
- Write a command-line utility with `MainArgs` and `OS-Lib`
- Automate some third-party JSON APIs via `Requests-Scala` and `uPickle`
- Write an incremental static site generator using the `Mill Build Tool`, together with `OS-Lib` and `Scalatags`

Projects
* [Ammonite](./lib/com-lihaoyi/Ammonite.md): Scala Scripting.
* [Cask](./lib/com-lihaoyi/Cask.md): a HTTP micro-framework for websites, backend servers, or REST APIs
* [Fansi]: a library for manipulating Fancy Ansi colored strings
* [FastParse]: a library for easily writing high-performance parsers
* [Geny]: interfaces for manipulating streaming collections and bytestreams
* [MainArgs]: a small, convenient, dependency-free library for command-line argument parsing
* [Mill](./lib/com-lihaoyi/Mill.md): A Better Build Tool for Java, Scala, & Kotlin.
* [OS-Lib](./lib/com-lihaoyi/os-lib.ipynb): a library for interfacing with common OS filesystem and subprocess APIs
* [PPrint]: a library for pretty-printing values, types and type-signatures
* [Requests-Scala]: a Scala port of the popular Python Requests HTTP client
* [ScalaSql]: an ORM to query SQL databases via concise and familiar collection operations
* [ScalaTags]: a small XML/HTML construction library for Scala.
* [sourcecode]: a library providing "source" metadata to your program
* [uPickle](./lib/com-lihaoyi/upickle.ipynb): a simple, fast, dependency-free JSON & Binary serialization library
* [µTest]: a simple testing framework

## Scalameta
[Scalameta](https://scalameta.org/): Library to read, analyze, transform and generate Scala programs.

* **Tree**: A core functionality of Scalameta is syntax trees, which enable you to read, analyze, transform and generate Scala programs at a level of abstraction.
* **SemanticDB**: SemanticDB is a data model for semantic information such as symbols and types about programs in Scala and other languages. SemanticDB decouples production and consumption of semantic information, establishing documented means for communication between tools.
* [Metals](./Scalameta/Metals.md): language server
* [Scalafmt](./Scalameta/Scalafmt.md): code formatter
* **Scalafix**: linting and refactoring tool
* **MUnit**: testing library
* **MDoc**: documentation tool
* **Metabrowse**: online code browser

# Typelevel
[Typelevel](./lib/Typelevel/Typelevel.md): an ecosystem of projects and a community of people united to foster an inclusive, welcoming, and safe environment around functional programming in Scala.

* [Cats](./lib/Typelevel/Cats.md): a library which provides abstractions for functional programming in the Scala programming language.
* [ScalaCheck](./lib/Typelevel/ScalaCheck.md): Property-based testing for Scala.
* ...

# See Also
* [Awesome Scala](https://index.scala-lang.org/awesome): A curated list of awesome Scala frameworks, libraries and tools.
* [EvilPlot](https://cibotech.github.io/evilplot/): Combinators for graphics
* [Scala IDEs](https://docs.scala-lang.org/getting-started/scala-ides.html): IntelliJ IDEA + Scala plugin, Visual Studio Code + Metals, Your favorite editor + Metals.
* [ScalaPB](https://github.com/scalapb/ScalaPB): ScalaPB is a protocol buffer compiler (`protoc`) plugin for Scala. It will generate Scala case classes, parsers and serializers for your protocol buffers.
* [ScalaPy](https://github.com/scalapy/scalapy): ScalaPy allows you to use any Python library from your Scala code with an intuitive API.

# FAQ
* [Executing shell commands from Scala REPL](https://stackoverflow.com/questions/9886123/executing-shell-commands-from-scala-repl): `:sh`, `resN.lines`
* [Using `scalap`, `javap` and the scala compiler to understand the journey from code to bytecode](https://www.jannikarndt.de/blog/2021/03/using_scalap_javap_and_the_scala_compiler/) - 2021-03-25