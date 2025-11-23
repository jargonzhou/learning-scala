# Programming in Scala, 4th Edition - 2.13

# 1. A Scalable Language

Scala: **Sca**lable **la**nguage
- a blend of object-oriented and functional programming concepts in a statically typed langauge.

a language that grows on you
- growing new types: example `Map`, `BigInt`
- growing new control structus: example Akka

what makes Scala scalable?
- Scala is object-oriented
- Scala is functional

why Scala?
- Scala is compatible
- Scala is concise
- Scala is high-level
- Scala is statically typed
  - verifiable properties
  - safe refactorings
  - documentation

Scala's roots
- syntax: Java, C#
- uniform object model: Smalltalk, Ruby
- universal nesting: Algol, Simula, Beta, gbeta
- uniform access principle for method invocation and field selection: Eiffel
- approach to functional programming: ML family of languages, SML, OCaml, F#
- implicit parameters: Haskell's type classes
- actor-based concurrency library Akka: Erlang
- extensible langauges: Peter Landin 'The Next 700 Programming Languages', 1996
- treating an infix operator as a function: Iswim, Smalltalk
- permit as function literal/block as a parameter: Iswim, Smalltalk
- innovations
  - abstract types: a more OO alternative to generic types
  - traits: flexible component assembly
  - extractors: a representation-independent way to do pattern matching

# 2. First Steps in Scala

```shell
$ sbt
sbt:programming-in-scala> project ch02

sbt:ch02> console

scala> :load ch02/printargs.sc a b
val args: Array[String] = Array(a, b)
Loading ch02\printargs.sc...
var i: Int = 0
a b
a
b
a
b
```


# 3. Next Steps in Scala

parametrize arrays with types: mutable objects
- array is a mutable sequence of objects that all share the same type.
- cannot change the length if an array after it is instantiated, can change its element values.
- assignment: transform into an invocation of `update` method
- `Array.apply()`

lists: `List[T]` immutable objects
- list is an immutable sequence of objects that all share the same type.
- `:::`: list concatenation
- `::`: cons
- packed with useful methods

tuples: immutable objects
- tuples are immutable, can contai different types of elements.

sets, maps: Scala models mutability in the class hierarchy
- `Set`: `scala.collection.Set`
  - `scala.collection.immutable.Set`
  - `scala.collection.mutable.Set`
- `Map`: `scala.collection.Map`
  - `scala.collection.immutable.Map`
  - `scala.collection.mutable.Map`

Convention rules
- if a method takes only one parameter, you can call it without a dot or parenthses. ex: `0 to 2`

# 4. Classes and Objects

# 5. Basic Types and Operations

basic types

literals
- interget literals
- floating point literals
- character literals
- string literals: `""`, raw string `""""""`
- symbol literals: `'ident`, `scala.Symbol`
- boolean literals: `true`, `false`

string interpolaton
- `s` string interpolator
- `raw` string interpolator
- `f` string interpolator

operators and methods

arithmetic operations

relational and logic operations

bitwise operations

object equality

operator presendence and associativity

rich wrappers

# 6. Functional Objects

identifiers
- alphanumeric identifier: letters, digits, `_`, `$`
- operator identifer: `+`, `++`, `:::`, `<?>`, `:->`, `~`, `#`, `<-`
- mixed identifier: ex `unary_+`, `myvar_=`
- literal identifier: `...`, ```Thread.`yield`()```

# 7. Built-in Control Structures

control structures
- `if` expressions
- `while`, `do-while` loops
- `for`, `for-yield` expressions
  - iteration through collections: generator `<-`
  - filtering: filters `if`
  - nested iteration: multiple `<-` clauses
  - mid-stream variable bindings: definitions `=`
  - producing a new collection: `yield`
- `try` expressions
  - `throw` expressions: type `Nothing`
  - catching expressions: pattern matching, `@throws` annotation
  - `finally` clause: loan pattern
  - yielding a value
- `match` expressions: select using patterns
- function calls

living without `break` and `continue`: they do NOT mesh well with function literals
```scala
import scala.util.control.Breaks

val mybreaks = new Breaks
import mybreaks.{break, breakable}

breakable {
  for (x <- xs) {
    if (done) break()
    f(x)
  }
}
```

# 8. Functions and Closures

- methods
- functions nested within functions: local functions
- function literals: exist in the source code
- function value: exist as objects at runtime

A **function literal** is compiled into a class that when instantiated at runtime is a **function value**.

partially applied functions

closures

special function call forms
- repeated parameters
- named arguments
- default parameter values

tail recursion

# 9. Control Abstraction

higher-order functions

currying: multiple argument lists

In any method invocation in Scala in which you are passing exactly one argument, you can opt to use `{}` to surround the argument instead of `()`.

by-name parameters: `=> Type...`, NOT `() => Type...`
- create a function value


# 10. Composition and Inheritance

- composition: one class holds a reference to another, using the referenced class to helop it fulfill its mission.
- inheritance: the superclass/subclass relationship.

Java's 4 namespaces
- fields
- methods
- types
- packages

Scala's 2 namespaces
- values: fields, methods, packages, singleton objects
- types: class, trait names

parametric field definition

`override` modifiers
- require: members that override a concrete member in a parent class.
- optional: a member implements an abstract member with the sanme name.
- forbidden: a member does not override or implement some other member in a base class.

# 11. Scala's Hierarchy

Scala class hierarchy: [Programming in Scala-11.uxf](../../umls/Programming%20in%20Scala-11.uxf)

```scala
Any
  AnyVal
    Byte
    Short
    Char
    Int // scala.runtime.RichInt
    Long
    Float
    Double
    Boolean
    Unit // ()
  AnyRef // java.lang.Object

Nothing
Null
```

Value class

# 12. Traits
# 13. Packages and Imports

Access modifiers
- `private`
  - Java: Only accessible within the declaring class.
  - Scala: Accessible only within the declaring class.
    - `private[this]`: A stricter form of `private`, making members accessible only from the current object instance. This is known as "object-private" or "instance-private."
- `protected`
  - Java: Accessible within the declaring class, by subclasses (even in different packages), and by other classes within the same package.
  - Scala: Accessible within the declaring class and by subclasses. Unlike Java's `protected`, it does not grant access to other classes in the same package.
- `public`
  - Java: Accessible from anywhere.
  - Scala: Accessible from anywhere.
- default
  - Java: package-private. Accessible only within the same package; no explicit keyword is used.
  - Scala: `public`
- qualtified access: scope quantifier
  - ex: `private[com.example.mypackage]` makes the member private to the `mypackage` package and its sub-packages.

Package objects: `package object XXX {}`

# 14. Assertions and Tests

assertions
- `assert()`
- `ensuring()`

tests
- JUnit
- TestNG
- ScalaTest
- spec2
- ScalaCheck

# 15. Case Classes and Pattern Matching

case classes
- add a factory method with the name of the class
- all arguments in the parameter list of a case class implicit get a `val` prefix: maintained as fields
- compiler adds natural implementations of `toString`, `hashCode`, `equals`
- compiler adds a `copy` methods to case class for making modified copies

kind of patterns
- wildcard patterns
- constant patterns
- variable patterns
- constructor patterns
- sequence patterns
- tuple patterns
- typed patterns
- variable binding

pattern guards

pattern overlaps: case order matters

sealed classes
- `@unchecked` annotation

`Option[T]`: `Some[T]`, `None`

patterns everywhere
- patterns in variable definitions
- case sequences as partial functions
- patterns in `for` expressions

# 16. Working with Lists
# 17. Working with Other Collections
# 18. Mutable Objects
# 19. Type Parameterization

型变
- 不变
- 协变
- 逆变

# 20. Abstract Members

4类抽象成员
- `val`s
- `var`s
- 方法
- 类型

预初始化字段

惰性`val`s

路径依赖类型

枚举

# 21. Implicit Conversions and Parameters
# 22. Implementing Lists
# 23. For Expressions Revisited

compiler translations:
- `for` expression with `yield`: combinations of invocations of `map`, `flatMap`, `withFilter`.
- `for` loop without `yield`: `withFilter`, `foreach`.
- detail
  - translate `for` expressions with one generator
  - translate `for` expressions with a generator and a filter
  - translate `for` expressions with two generators
  - translate patterns in generators
  - translate definitions
  - translate `for` loop

`for` expression
```scala
for ( seq ) yield expr
// seq: generators, definitions, filters
// generator: pat <- expr
// definition: path = expr
// filter: if expr
```

every application of a `map`, `flatMap` or `filter` can be represented as a `for` expression.


# 24. Collections in Depth

Collection hierarchy
```scala
Iterable
  Seq
    IndexedSeq
      ArraySeq
      Vector
      ArrayDeque (mutable)
      Queue (mutable)
      Stack (mutable)
      Range
      NumericRange
    LinearSeq
      List
      LazyList
      Queue (immutable)
    Buffer
      ListBuffer
      ArrayBuffer
  Set
    SortedSet
      TreeSet
    HashSet (mutable)
    LinkedHashSet
    HashSet (immutable)
    BitSet
    EmptySet, Set1, Set2, Set3, Set4
  Map
    SortedMap
      TreeMap
    HashMap (mutable)
    LinkedHashMap (mutable)
    HashMap (immutable)
    VectorMap (immutable)
    EmptyMap, Map1, Map2, Map3, Map4
```

topics
- collections consistency
- trait `Iterable`
  - iteration operations: `foreach`, `grouped`, `sliding`
  - addition: `++`, `concat`
  - map operations: `map`, `flatMap`, `collect`
  - conversions: `toIndexedSeq`, `toIterable`, `toList`, `toMap`, `toSeq`, `toSet`, `toVector`, `toArray`, `toBuffer`
  - copy operations: `copyToArray`
  - size operations: `isEmpty`, `nonEmpty`, `size`, `knownSize`, `sizeCompare`, `sizeIs`
  - element retrieval operations: `head`, `last`, `headOption`, `lastOption`, `find`
  - subcollection retrieval operations: `takeWhile`, `tail`, `init`, `slice`, `take`, `drop`, `filter`, `dropWhile`, `filterNot`, `withFilter`
  - zippers: `zip`, `lazyZip`, `zipAll`, `zipWithIndex`
  - subdivision operations: `groupBy`, `groupMap`, `groupMapReduce`, `splitAt`, `span`, `partition`, `partitionMap`
  - element tests: `exists`, `forall`, `count`
  - folds: `foldLeft`, `foldRight`, `reduceLeft`, `reduceRight`
  - specific folds: `sum`, `product`, `min`, `max`
  - string operations: `mkString`, `addString`
  - view opration: `view`, a view is a collection that's evaluated lazily
- sequence traits: `Seq`, `IndexedSeq`, `LinearSeq`
  - `Seq`
    - indexing and length operations: `apply`, `isDefinedAt`, `length`, `indices`, `lengthCompare`, `lengthIs`
    - index search operations: `indexOf`, `lastIndexOf`, `indexOfSlice`, `lastIndexOfSlice`, `indexWhere`, `lastIndexWhere`, `segmentLength`, `prefixLength`
    - addition operations: `+:`/`prepended`, `++:`/`prependedAll`, `:+`/`appended`, `:++`/`appendedAll`, `padTo`
    - update operations: `updated`, `patch`
    - sorting operations: `sorted`, `sortWith`, `sortBy`
    - reversal operations: `reverse`, `reverseIterator`
    - comparision operations: `startsWith`, `endsWith`, `contains`, `corresponds`, `containsSlice`, `search`
    - multiset operations: `intersect`, `diff`, `distinct`, `distinctBy`
  - `LinearSeq`: efficient `head` and `tail` operations
    - `List`, `LazyList`
  - `IndexedSeq`: efficient `apply`, `length`, and `update`(if mutable) operations
    - `Array`, `ArrayBuffer`
    - `mutable.IndexedSeq`: `mapInPlace`, `sortInPlace`, `sortInPlaceBy`, `sortInPlaceWith`
  - `Vector`: compromise between indexed and linear access
  - `mutable.Buffer`: `ListBuffer`, `ArrayBuffer`
    - additions: `+=`/`append`, `++=`/`appendAll`, `+=:`/`preprend`, `++=:`/`prependAll`, `insert`, `insertAll`, `padToInPlace`
    - removals: `-=`/`subtractOne`, `--=`/`subtractAll`, `remove`, `trimStart`, `trimEnd`, `clear`
    - replacement: `patchInPlace`
    - cloning: `clone`
- sets
  - `Set`
    - tests: `contains`, `apply`, `subsetOf`
    - additions: `+`/`incl`, `++`/`concat`
    - removals: `-`/`excl`, `--`/`removedAll`
    - set operations: `intersect`/`&`, `union`/`|`, `diff`/`&~`
  - `immutable.Set`
    - additions: `+`/`incl`, `++`/`concat`
    - removals: `-`/`excl`, `--`/`removedAll`
  - `mutable.Set`
    - additions: `+=`/`addOne`, `++=`/`addAll`, `add`
    - removals: `-=`/`subtractOne`, `--=`/`subtractAll`, `remove`, `filterInPlace`, `clear`
    - update: `update`
    - cloning: `clone`
- maps/mappings/associations
  - `Map`
    - lookups: `apply`, `get`, `getOrElse`, `contains`, `isDefinedAt`
    - additions and updates: `+`/`updated`, `++`/`concat`, `updateWith`, `updatedWith`
    - removals: `-`/`removed`, `--`/`removedAll`
    - subcollection producers: `keys`, `keySet`, `keysIterator`, `valuesIterator`, `values`
    - transformations: `filterKeys`, `mapValues`
  - `immutable.Map`
    - additions and updates: `+`/`updated`, `++`/`concat`, `updateWith`
    - removals: `-`/`removed`, `--`/`removedAll`
  - `mutable.Map`
    - additions and updates: `update`, `+=`, `++=`, `put`, `getOrElseUpdate`, `updateWith`
    - removals: `-=`, `--=`, `remove`, `filterInPlace`, `clear`
    - transformations: `mapValuesInPlace`
    - cloning: `clone`
- concrete immutable collection classes
  - `List`
  - `LazyList`: `#::`
  - `ArraySeq`
  - `Vector`
  - `Queue`
  - `Range`: `to`, `by`, `until`
  - compresses hash-array mapped prefix-trees: hash tries
  - red-black trees: `TreeSet`, `TreeMap`
  - `BitSet`
  - `VectorMap`
  - `ListMap`
- concrete mutable collection classes
  - `ArrayBuffer`
  - `ListBuffer`
  - `StringBuilder`
  - `ArrayDeque`
  - `Queue`
  - `Stack`
  - `ArraySeq`
  - `HashMap`, `LinkedHashMap`, `HashSet`, `LinkedHashSet`
  - `WeakHashMap`
  - `concurrent.Map`: `putIfAbsent`, `remove`, `replace`
    - `java.util.concurrent.ConcurrentMap`
    - `TrieMap`
  - `BitSet` 
- arrays
  - one-to-one to Java arrays
  - Scala arrays can be generic, compatiable with Scala sequences, support all sequence operations
  - implicit conversions: wrapped in `mutable.ArraySeq`, `ArrayOps`
  - class tag: `scala.reflect.ClassTag`, context bound
- strings
- performance characteristics
- equality
- views: `view`, `to`
- iterators
  - `Iterator`
  - `BufferedIterator`
- create collections from scratch
- conversion between Java and Scala collections
  - `scala.collection.JavaConverters`

# 25. The Architecture of Scala Collections

template traits

factoring out common operations
- abstracting over collection types
```scala
// A: element type
// CC: type constructor
// C: complete type
IterableOps[+A, +CC[_], +C]
  SetOps[A, +CC[_], +C]
    SortedSetOps[A, +CC[_], +C]
  MapOps[K, +V, +CC[_,_], +C]
    SortedMapOps
```
- handling strictness
```scala
View[+A]

IterableOps[+A, +CC[_], +C]
  fromSpecific(): C
  from[E](): CC[E]
IterableFactory[+CC[_]]
MapFactory[+CC[_,_]]
```
- when strict evaluation is preferable or unavoidable
```scala
// A: elememt type
// C: type of collection returned
Builder[-A, +C]
IterableOps[+A, +CC[_], +C]
  newSpecificBuilder(): Builder[A, C]
IterableFactory[+CC[_]]
  newBuilder[A]: Builder[A, CC[A]]

StrictOptimized***
```

integrate new collections, examples
- capped sequences
- sequences of RNA bases
- prefix maps implemented with Patricia tries

# 26. Extractors
# 27. Annotations
# 28. Working with XML
# 29. Modular Programming Using Objects
# 30. Object Equality
# 31. Combining Scala and Java
# 32. Futures and Concurrency
# 33. Combinator Parsing

parse combinators
- `"""..."""`: literal
- `"""...""".r`: regular expression
- `P~Q`: sequential composition
- `P<~Q`, `P~>Q`: sequential composition, keep left/right only
- `P|Q`: alternative
- `opt(Q)`: option
- `rep(P)`: repetition
- `repsep(P,Q)`: interleaved repetition
- `P ^^ f`: result conversion

```scala
package scala
package util.parsing.combinator

trait Parsers {
  type Elem

  type Input = Reader[Elem]
  
  sealed abstract class ParseResult[+T] {}
  case class Success[+T](...) extends ParseResult[T] {}
  sealed abstract class NoSuccess(...) extends ParseResult[Nothing] {}
  case class Failure(...) extends NoSuccess(msg, next) 
  case class Error(...) extends NoSuccess(msg, next)

  abstract class Parser[+T] extends (Input => ParseResult[T]) {
    // elem: single-token parsers
    // ~: sequential composition
    // |: alternative composition
    // ^^: result conversion
    // success
    // failure
    // opt, rep, repsep: option and repetition
    // ~!: non-back-tracking sequential composition
    // ...
  }
  case class ~[+a, +b](_1: a, _2: b) {}
  trait OnceParser[+T] extends Parser[T] {}
}

trait RegexParsers extends Parsers {
  type Elem = Char
  implicit def literal(s: String): Parser[String] = ...
  implicit def regex(r: Regex): Parser[String] = ...

}
```

packages
```scala
scala.util.parsing.combinator. lexical
scala.util.parsing.combinator.syntactical
scala.util.parsing.combinator.token
scala.util.parsing.input
```


# 34. GUI Programming
# 35. The SCells Spreadsheet