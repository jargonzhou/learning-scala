# Ammonite
* http://ammonite.io/
* https://github.com/lihaoyi/ammonite

> Scala Scripting
>
> Ammonite lets you use the Scala language for scripting purposes: in the REPL or as scripts.
> - Ammonite-REPL
> A Modernized Scala REPL. With syntax highlighting, multi-line editing, the ability to load maven artifacts directly in the REPL, and many other quality-of-life improvements missing in the default Scala REPL.
> - Scala Scripts
> Lightweight Programming in Scala. Create scripts that you can run easily from the command line, without the overhead of setting up a "project" or waiting for SBT's slow startup times.

action
* [Ammonite-2.12.ipynb](./Ammonite-2.12.ipynb)
* [Ammonite-2.13.ipynb](./Ammonite-2.13.ipynb)
* [Ammonite-3.ipynb](./Ammonite-3.ipynb)

```shell
$ cs install ammonite:3.0.3

$ cs bootstrap ammonite:3.0.3 -o amm303
Wrote ~\bin\amm303
Wrote ~\amm303.bat
$  amm303.bat
Loading...
Welcome to the Ammonite Repl 3.0.3 (Scala 3.7.3 Java 17.0.9)
@
```

# Terminology

* Ammonite-REPL: 现代化的Scala REPL.
* Scala Scripts: 轻量级的Scala编程.

# Usage

```shell
$ amm.bat
Loading...
Welcome to the Ammonite Repl 3.0.0-M1 (Scala 2.13.13 Java 17.0.9)
@

@ 1 + 1
1 + 1
res0: Int = 2

@

@ exit
exit
Bye!
```

magic imports

```scala
import $file
import $exec
import $cp // class path
import $ivy // Ivy dependency from Maven central
import $repo
```