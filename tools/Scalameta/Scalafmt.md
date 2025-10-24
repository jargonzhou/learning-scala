# Scalafmt
* https://scalameta.org/scalafmt/

> Code formatter for Scala.

# `.scalafmt.conf`
* https://scalameta.org/scalafmt/docs/configuration.html


# Usage

Disable formatting for specific regions of code by wrapping them in `// format: off` blocks
```scala
// format: off
val identity = Array(1, 0, 0,
                     0, 1, 0,
                     0, 0, 1)
// format: on
```

# See Also
* [HOCON](https://github.com/lightbend/config/blob/main/HOCON.md) (Human-Optimized Config Object Notation)