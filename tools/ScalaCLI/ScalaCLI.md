# Scala CLI
* https://scala-cli.virtuslab.org/
* https://github.com/Virtuslab/scala-cli

> Scala CLI is a command-line tool to interact with the Scala language.
> It lets you compile, run, test, and package your Scala code (and more!)
>
> Scala CLI is the default Scala runner and is being shipped as scala along with scalac as part of the official language installation since Scala 3.5.0.


Scala CLI supports most recent Scala versions (3.x, 2.13.x and 2.12.x), and changing the Scala version as easy as providing the `--scala` parameter.

# Getting started
* https://scala-cli.virtuslab.org/docs/getting_started

Choose Scala version:
```shell
$ scala-cli
Welcome to Scala 3.7.3 (17.0.9, Java OpenJDK 64-Bit Server VM).
Type in expressions for evaluation. Or try :help.                                 
scala>

$ scala-cli --scala 2.13.16
Welcome to Scala 2.13.16 (OpenJDK 64-Bit Server VM, Java 17.0.9).
Type in expressions for evaluation. Or try :help.
scala>
```

Hello World:
```shell
$ echo 'println("Hello")' | scala-cli -
Hello
```

Scripting
```shell
$ scala-cli hello.sc
Hello!

# passing arguments
$ scala-cli hello.sc -- Jenny Jake
Hello: Jenny, Jake!
```

TODO: more
- dependencies
- project
- IDE support
- tests
- packaging