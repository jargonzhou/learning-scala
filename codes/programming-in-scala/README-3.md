# Programming in Scala, 5th Edition - 3

# 1. A Scalable Language
# 2. First Steps in Scala

```shell
$ sbt
sbt:programming-in-scala> project ch02_3

sbt:ch02_3> runMain m
Hello, world, from a script!

sbt:ch02_3> runMain m2 for arg in args
for
arg
in
args
```

quiet syntax: the indentation-based style `:`
- is recommened over the curly brace style `{}`

**end markers**: `end <specifier token>`
- ex: Listing 10.9

# 3. Next Steps in Scala
# 4. Classes and Objects

```shell
sbt:ch04_3> runMain Summer of love
of: -213
love: -182
```

# 5. Basic Types and Operations
# 6. Functional Objects
# 7. Built-in Control Structures
# 8. Functions and Closures
# 9. Control Abstraction
# 10. Composition and Inheritance
# 11. Traits
# 12. Packages, Imports, and Exports
# 13. Pattern Matching
# 14. Working with Lists
# 15. Working with Other Collections
# 16. Mutable Objects
# 17. Scala's Hierarchy
# 18. Type Parameterization
# 19. Enums
# 20. Abstract Members
# 21. Givens
# 22. Extension Methods

Scala provide a mechanism for making it appear as if a function is defined as a method on a class, when it is really defined outside the class.
Scala 3 introduced a new mechanism for this, **extenion methods**/

# 23. Typeclasses
# 24. Assertions and Tests