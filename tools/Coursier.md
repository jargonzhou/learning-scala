# Coursier
* https://get-coursier.io/
* https://github.com/coursier/coursier

> Pure Scala Artifact Fetching
>
> Coursier is the Scala application and artifact manager. It can install Scala applications and setup your Scala development environment. It can also download and cache artifacts from the web.

# Application
* https://github.com/coursier/apps

- `cs` itself, to further manage your Scala environment/管理Scala环境
- `scala-cli`, a convenient tool to compile / run / package Scala code/编译/运行/打包Scala代码
- `scala`, the Scala REPL
- `scalac`, the Scala compiler/Scala编译器
- `sbt` and `sbtn`, the sbt build toold/sbt构建工具
- `ammonite`, an enhanced REPL for Scala/增强的Scala REPL
- `scalafmt`, the Scala code formatter/Scala代码格式化器

# CLI
* https://get-coursier.io/docs/cli-overview
- manage the installed Scala applications: `install`, `list`, `update`, `uninstall`, `search`
- configure channels to install Scala applications from: `channel`
- launchers for Scala applications: `launch`, `bootstrap`
- manage the installed JVMs: `java`, `java-home`
- directly manipulate Maven dependencies: `fetch`, `resolve`
- perform `setup` again

Commands
- setup: 安装Scala开发环境
- install, list, update, uninstall, search: 管理安装的Scala应用
    - install: 在安装目录中安装应用
    - list: 查看已安装的应用
    - update: 更新已安装的应用
    - uninstall: 卸载应用
    - search: 搜索应用
- channel: 配置安装Scala应用的来源渠道
- launch, bootstrap: Scala应用启动器
    - launch: 按名称启动应用, 或者直接从一个或多个Maven依赖启动
    - bootstrap: 从一个或多个Maven依赖创建二进制启动器
- java, java-home: 管理安装的JVM
    - java: 管理JVM
    - java-home: 输出JVM的主目录
- fetch, resolve: 直接操作Maven依赖
    - fetch: 拉取一个或多个Maven依赖
    - resolve: 输出一个或多个Maven依赖的传递依赖
- complete-dep: 补全Maven坐标

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

# See Also
* [coursier/jvm-index](https://github.com/coursier/jvm-index): JVM index generator