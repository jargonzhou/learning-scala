# Coursier
* https://get-coursier.io/

> Pure Scala Artifact Fetching
>
> Coursier is the Scala application and artifact manager. It can install Scala applications and setup your Scala development environment. It can also download and cache artifacts from the web.

# Application
* https://github.com/coursier/apps

- `cs` itself, to further manage your Scala environment
- `scala-cli`, a convenient tool to compile / run / package Scala code
- `scala`, the Scala REPL
- `scalac`, the Scala compiler
- `sbt` and `sbtn`, the sbt build toold
- `ammonite`, an enhanced REPL for Scala
- `scalafmt`, the Scala code formatter

# CLI
* https://get-coursier.io/docs/cli-overview
- manage the installed Scala applications: `install`, `list`, `update`, `uninstall`, `search`
- configure channels to install Scala applications from: `channel`
- launchers for Scala applications: `launch`, `bootstrap`
- manage the installed JVMs: `java`, `java-home`
- directly manipulate Maven dependencies: `fetch`, `resolve`
- perform `setup` again

## setup

> The setup command aims at making it easier to setup a machine for Scala development, be it your own development machine, or CI environments.

It currently ensures that:
- a JVM is installed on your system,
- standard Scala CLI tools are installed.

```shell
$ cs setup
$ cs version
2.1.25-M17

# list
$ cs list
amm
coursier
cs
sbt
sbtn
scala
scala-cli
scalac
scalafmt

$ scala -version
Scala code runner version: 1.9.0
Scala version (default): 3.7.3

$ amm --version
Ammonite REPL & Script-Runner, 3.0.0-M1
$ amm.bat
Loading...
Welcome to the Ammonite Repl 3.0.0-M1 (Scala 2.13.13 Java 17.0.9)

$ cs about
Launcher type: native
Cache location: ~\AppData\Local\Coursier\cache\v1
Archive cache location: ~\AppData\Local\Coursier\cache\arc
OS: windows
CPU architecture: amd64
```

## install
* https://get-coursier.io/docs/cli-install

```shell
# Scala 2.12
$ cs install scala:2.12.20 scalac:2.12.20
$ scala -version
Scala code runner version 2.12.20 -- Copyright 2002-2024, LAMP/EPFL and Lightbend, Inc.

# Scala 2.13
$ cs install scala:2.13.16 scalac:2.13.16
$ scala -version
Scala code runner version 2.13.16 -- Copyright 2002-2025, LAMP/EPFL and Lightbend, Inc. dba Akka

# Scala 3
$ cs install scala:3.7.3 scalac:3.7.3
$ scala -version
Scala code runner version: 1.9.0
Scala version (default): 3.7.3

# ammonite
$ cs install ammonite:3.0.3

# scalap
$ cs install scalap
Wrote scalap
$ scalap -version
Scala classfile decoder version 2.0.1 -- (c) 2002-2025 LAMP/EPFL

# uninstall
cs uninstall scala scalac
```

## launch

## bootstrap

```shell
$ cs bootstrap ammonite:3.0.3 -o amm303
Wrote ~\bin\amm303
Wrote ~\amm303.bat
$  amm303.bat
Loading...
Welcome to the Ammonite Repl 3.0.3 (Scala 3.7.3 Java 17.0.9)
@
```

## java

## resolve

## fetch

## complete-dep
