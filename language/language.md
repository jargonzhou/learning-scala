# Scala Programming Language
* https://www.scala-lang.org/
* [All Available Versions](https://www.scala-lang.org/download/all.html): Note that different major releases of Scala 2 (e.g. Scala 2.11.x and Scala 2.12.x) are not [binary compatible](https://docs.scala-lang.org/overviews/core/binary-compatibility-of-scala-releases.html) with each other. Scala 3 minor releases (e.g. 3.0.x and 3.1.x) follow a [different compatibility model](https://docs.scala-lang.org/scala3/reference/language-versions/binary-compatibility.html).
  * [Scala 2](https://github.com/scala/scala)
  * [Scala 3](https://github.com/scala/scala3): Dotty

# Guides and Overviews
* https://docs.scala-lang.org/overviews/

**Standard Library**/标准库: Guides and overviews covering the Scala standard library.
- **Scala Collections**: Scala's Collection Library.
- Migrating a Project to Scala 2.13's Collections: This page describes the main changes for collection users that migrate to Scala 2.13 and shows how to cross-build projects with Scala 2.11 / 2.12 and 2.13.
- **The Architecture of Scala Collections**: These pages describe the architecture of the collections framework introduced in Scala 2.13. Compared to the Collections API you will find out more about the internal workings of the framework.
- **Implementing Custom Collections**: In this document you will learn how the collections framework helps you define your own collections in a few lines of code, while reusing the overwhelming part of collection functionality from the framework.
- **Adding Custom Collection Operations**: This guide shows how to write operations that can be applied to any collection type and return the same collection type, and how to write operations that can be parameterized by the type of collection to build.

**Language**/语言: Guides and overviews covering features in the Scala language.
- **Migration from Scala 2 to Scala 3**: Everything you need to know about compatibility and migration to Scala 3.
- **Scala 3 Macros**: A detailed tutorial to cover all the features involved in writing macros in Scala 3.
- **Value Classes and Universal Traits**: Value classes are a new mechanism in Scala to avoid allocating runtime objects. This is accomplished through the definition of new AnyVal subclasses.
- **An Overview of TASTy**: An overview over the TASTy format aimed at end-users of the Scala language.
- **String Interpolation**: String Interpolation allows users to embed variable references directly in processed string literals
- **Implicit Classes**: Scala 2.10 introduced a new feature called implicit classes. An implicit class is a class marked with the implicit keyword. This keyword makes the class’ primary constructor available for implicit conversions when the class is in scope.
- **The Scala Book**: A light introduction to the Scala language, focused on Scala 2. Now updated for Scala 3, we are in the process of merging the two.

**Authoring Libraries**/创作库: Guides for contributing open source libraries to the Scala ecosystem.
- **Library Author Guide**: Lists all the tools that library authors should setup to publish and document their libraries.

**Parallel and Concurrent Programming**/并行和并发编程: Complete guides covering some of Scala's libraries for parallel and concurrent programming.
- **Futures and Promises**: Futures provide a way to reason about performing many operations in parallel– in an efficient and non-blocking way. A Future is a placeholder object for a value that may not yet exist. Generally, the value of the Future is supplied concurrently and can subsequently be used. Composing concurrent tasks in this way tends to result in faster, asynchronous, non-blocking parallel code.
- **Parallel Collections**: Scala's Parallel Collections Library.

**Compatibility**/兼容性: What works with what (or doesn't).
- **JDK Version Compatibility**: Which Scala versions work on what JDK versions.
- **Binary Compatibility of Scala Releases**: When two versions of Scala are binary compatible, it is safe to compile your project on one Scala version and link against another Scala version at run time. Safe run-time linkage (only!) means that the JVM does not throw a (subclass of) LinkageError when executing your program in the mixed scenario, assuming that none arise when compiling and running on the same version of Scala. Concretely, this means you may have external dependencies on your run-time classpath that use a different version of Scala than the one you’re compiling with, as long as they’re binary compatible. In other words, separate compilation on different binary compatible versions does not introduce problems compared to compiling and running everything on the same version of Scala. 
* **Binary Compatibility for Library Authors**: A diverse and comprehensive set of libraries is important to any productive software ecosystem. While it is easy to develop and distribute Scala libraries, good library authorship goes beyond just writing code and publishing it. In this guide, we cover the important topic of Binary Compatibility.
- **Nightly Versions of Scala**: We regularly publish 'nightlies' of both Scala 3 and Scala 2 so that users can preview and test the contents of upcoming releases. Here's how to find and use these versions.

**Tools**/工具: Reference material on core Scala tools like the Scala REPL and Scaladoc generation.
- **Scala 2 REPL**: The Scala REPL is a tool (`scala`) for evaluating expressions in Scala. The `scala` command will execute a source script by wrapping it in a template and then compiling and executing the resulting program
- **Scaladoc For Scala 3**: Updates in Scala 3 to Scala’s API documentation generation tool.
- **Scaladoc**: Scala's API documentation generation tool.

**Compiler**/编译器: Guides and overviews covering the Scala compiler: compiler plugins, reflection, and metaprogramming tools such as macros.
- **Scala 2 Reflection**: Scala's runtime/compile-time reflection framework.
- **Scala 2 Macros**: Scala's metaprogramming framework.
- **Quasiquotes in Scala 2**: Quasiquotes are a convenient way to manipulate Scala syntax trees.
- **Scala 2 Compiler Plugins**: Compiler plugins permit customizing and extending the Scala compiler. This tutorial describes the plugin facility and walks you through how to create a simple plugin.
- **Scala 2 Compiler Options**/Scala 2编译器选项: Various options to control how scalac compiles your code.
  - [typelevel/scalac-options](https://github.com/typelevel/scalac-options): A library for configuring scalac options.
- **Error Formatting**: A new engine for more user-friendly error messages, printing chains of dependent implicits and colored found/required type diffs.
- **Optimizer**: The compiler can perform various optimizations.

**Legacy**/遗产: Guides covering features no longer relevant to recent Scala versions (2.12+).
- **Scala 2.8 to 2.12’s Collections**: Scala's Collection Library.
- **The Architecture of Scala 2.8 to 2.12’s Collections**: These pages describe the architecture of the Scala collections framework in detail. Compared to the Collections API you will find out more about the internal workings of the framework. You will also learn how this architecture helps you define your own collections in a few lines of code, while reusing the overwhelming part of collection functionality from the framework.

# Specification
- [2.11](https://scala-lang.org/files/archive/spec/2.11/)
- [2.12](https://scala-lang.org/files/archive/spec/2.12/)
- [2.13](./spec/spec-2.13.md)
- [Scala 3 Reference](https://docs.scala-lang.org/scala3/reference/)

# SIP: Scala Improvement Process
* https://docs.scala-lang.org/sips/index.html

# API
* https://docs.scala-lang.org/api/all.html
  * 2.12: Library API, Compiler API, Reflection API, Scala Modules(XML API, Parser Combinators API, Swing API)
  * 2.13: Library API, Compiler API, Reflection API
    * [Scala Compiler Plugins](https://docs.scala-lang.org/overviews/plugins/index.html)
  * 3: Library API
* [Current](https://www.scala-lang.org/api/current/)

# Platform
* JVM
* [Scala Native](./Scala%20Native.md)
* [Scala.js](./Scala.js.md)

# See Also
* [scala-parser-combinators](./scala-parser-combinators.md): This was originally part of the Scala standard library, but is now community-maintained, under the guidance of the Scala team at Akka (formerly Lightbend).
* [Scala Style Guide](./scala-style-guide.md)
* [Scala Cheatsheet](https://docs.scala-lang.org/cheatsheets/index.html): Thanks to Brendan O’Connor, this cheatsheet aims to be a quick reference of Scala syntactic constructions. Licensed by Brendan O’Connor under a CC-BY-SA 3.0 license.
* [Scala levels: beginner to expert, application programmer to library designer](https://www.scala-lang.org/old/node/8610) - 2011-01-16
  - Level A1: Beginning application programmer
  - Level A2: Intermediate application programmer
  - Level A3: Expert application programmer
  - Level L1: Junior library designer
  - Level L2: Senior library designer
  - Level L3: Expert library designer
* [The essence of Scala](https://alvinalexander.com/misc/the-essence-of-scala-martin-odersky/): Fusion of functional and object-oriented programming in a typed setting: - [The Scala 3 Book - Functional Programming](https://docs.scala-lang.org/scala3/book/fp-intro.html)
  - Functions for the logic
  - Objects for the modularity
* [The Essence of Scala](https://www.scala-lang.org/blog/2016/02/03/essence-of-scala.html): DOT, the calculus of dependent object types, that underlies Scala. - 2016-02-03 