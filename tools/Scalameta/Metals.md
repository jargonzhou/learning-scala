# Metals
* https://scalameta.org/metals/

> Scala language server with rich IDE features

# Visual Studio Code
* http://scalameta.org/metals/docs/editors/vscode/

Metals supports these Scala versions:
- Scala 2.11: 2.11.12
- Scala 2.12: 2.12.17, 2.12.18, 2.12.19, 2.12.20
- Scala 2.13: 2.13.14, 2.13.15, 2.13.16, 2.13.17
- Scala 3 versions from 3.3.4 are automatically supported by Metals.

# Build Tools

- **sbt**: sbt is the most commonly used build tool in the Scala community and works with Metals out-of-the-box.
- **Maven**: Maven is one of the most common build tools in the JVM ecosystem and it also works with Scala through the `scala-maven-plugin`. The `scalor-maven-plugin` is not currently supported and requires a new plugin for bloop to be implemented.
- **Gradle**: Gradle is a build tool that can be used easily with a large number of programming languages including Scala. With it you can easily define your builds for Groovy or Kotlin, which enables for a high degree of customization.
- **Mill**: Mill is a build tool initially developed by Li Haoyi in order to create something simpler and more intuitive than most of the other build tools today.
- **Bloop**: Bloop is a compile server for Scala that works with sbt and has support for other build tools like Maven, Gradle, Mill, Fury and Seed. If your workspace contains a `.bloop/` directory with Bloop JSON files then Metals will automatically connect to it.
- **Bazel**: Bazel is a build tool that is used by Google and other companies to build large monorepos. It is a bit more complex to set up than other build tools, but it is praised for its speed and scalability. It is also being used more and more in a lot of Scala codebases.

## Bloop
* https://scalameta.org/metals/docs/build-tools/bloop
* https://scalacenter.github.io/bloop/setup

```shell
# 2.0.13 => 2.0.16
$ cs install bloop:2.0.16
https://repo1.maven.org/maven2/io/get-coursier/apps/maven-metadata.xml
  No new update since 2025-06-21 00:14:15
Wrote bloop
# in ~/bin
$ cs bootstrap bloop:2.0.16 -o bloop
$ bloop.bat about
bloop v2.0.16

Using Scala v2.12.20 and Zinc v1.11.0
Running on Java JDK v17.0.9 (~\.sdkman\candidates\java\17.0.9-tem)
  -> Supports debugging user code, Java Debug Interface (JDI) is available.
Maintained by the Scala Center and the community.
```

# See Also
* [Write Scala in VS Code, Vim, Emacs, Atom and Sublime Text with Metals](https://www.scala-lang.org/2019/04/16/metals.html): 2019-04-16
