# Scala 3 Book
* https://docs.scala-lang.org/scala3/book/introduction.html

- Introduction
- Scala Features
- Why Scala 3?
- A Taste of Scala
  - Hello, World!
  - REPL: The Scala REPL (“Read-Evaluate-Print-Loop”) is a command-line interpreter that you use as a “playground” area to test your Scala code. You start a REPL session by running the `scala` or `scala3` command.
  - Variable and Data Types
  - Control Structures
  - Domain Modeling
  - Methods
  - First-Class Functions
  - Singleton Objects
  - Collections
  - Contextual Abstractions
  - Toplevel Definitions
- A First Look at Types
- String Interpolation
- Control Structures
- Domain Modeling
  - Tools
  - OOP Modeling
  - FP Modeling
- Methods
  - Method Features
  - Main Methods in Scala 3
- Functions
  - Anonymous Functions
  - Function Variables
  - Partial Functions
  - Eta-Expansion
  - Higher-Order Functions
  - Write Your Own `map` Method
  - Creating a Method that Returns a Function
- Packaging and Imports
- Scala Collections
  - Collections Types
  - Collections Methods
- Functional Programming
  - What is Functional Programming?
  - Immutable Values
  - Pure Functions
  - Functions Are Values
  - Functional Error Handling
- Types and the Type System
  - Inferred Types
  - Generics
  - Intersection Types
  - Union Types
  - Algebraic Data Types
  - Variance
  - Opaque Types
  - Structural Types
  - Dependent Functions Types
  - Other Types
- Contextual Abstractions
  - Extension Methods
  - Context Parameters
  - Context Bounds
  - Given Imports
  - Type Classes
  - Multiversal Equality
  - Implicit Conversions
- Concurrency
- Scala Tools
  - Building and Testing Scala Projects with sbt
  - Worksheets: A worksheet is a Scala file that is evaluated on save, and the result of each expression is shown in a column to the right of your program. Worksheets are like a REPL session on steroids, and enjoy 1st class editor support: completion, hyperlinking, interactive errors-as-you-type, etc. Worksheets use the extension `.worksheet.sc`.
- Interacting with Java
- Scala for Java Developers
- Scala for JavaScript Developers
- Scala for Python Developers

# Introduction
# Scala Features
# Why Scala 3?
# A Taste of Scala
# A First Look at Types
# String Interpolation
# Control Structures
# Domain Modeling
# Methods
# Functions

# Packaging and Imports

## Creating a package

- Using multiple packages in the same file

## Import statements, Part 1

- Importing one or more members
- Renaming members on import
- Hiding members on import
- Use imports anywhere
- “Static” imports
- Packages imported by default
- Handling naming conflicts

## Importing `given` instances

- By-type imports

# Scala Collections
# Functional Programming
# Types and the Type System


# Contextual Abstractions/上下文抽象

abstract over context, use cases
- implementing type classes
- establishing context
- dependency injection
- expressing capabilities
- computing new types, and proving relationships among them

Scala contextual abstraction features
- context parameters/上下文参数: specify parameters at the call-site, can be omitted by the programmer and should be automatically provided by the context.
- given instance(Scala 3)/给定实例, implicit definition(Scala 2)/隐式定义: terms used by Scala compiler to fill in the missing arguments.

## Extension Methods/扩展方法

```scala
case class Circle(x: Double, y: Double, radius: Double)

// in package lib
extension (c: Circle)
  def circumference: Double = c.radius * math.Pi * 2
  def diameter: Double = c.radius * 2
  def area: Double = math.Pi * c.radius * c.radius

val aCircle = Circle(2, 3, 5)
import lib.circumference
aCircle.circumference
```

## Context Parameters

```scala
implicit // Scala 2

using    // Scala 3
given    // Scala 3
```

## Context Bounds

a context bould is a shorthand syntax for expression the pattern of 'a context parameter applied to a type parameter'

ex `A: Ord`:
```scala
def maxElement[A: Ord](as: List[A]): A =
  as.reduceLeft(max(_, _))

// Scala 2
def maxElement[A](as: List[A])(implicit ord: Ord[A]): A =
  as.reduceLeft(max(_, _)(ord))
def maxElement2[A](as: List[A])(implicit ord: Ord[A]): A =
  as.reduceLeft(max(_, _)) // Omitting context arguments
/** Defines how to compare values of type `A` */
trait Ord[A] {
  def greaterThan(a1: A, a2: A): Boolean
}
/** Returns the maximum of two values */
def max[A](a1: A, a2: A)(implicit ord: Ord[A]): A =
  if (ord.greaterThan(a1, a2)) a1 else a2

// Scala 3: using
def maxElement[A](as: List[A])(using ord: Ord[A]): A =
  as.reduceLeft(max(_, _)(using ord))
def maxElement2[A](as: List[A])(using Ord[A]): A =
  as.reduceLeft(max(_, _)) // Omitting context arguments
/** Defines how to compare values of type `A` */
trait Ord[A]:
  def greaterThan(a1: A, a2: A): Boolean
/** Returns the maximum of two values */
def max[A](a1: A, a2: A)(using ord: Ord[A]): A =
  if ord.greaterThan(a1, a2) then a1 else a2
```

## Given Imports

To make it more clear where givens in the current scope are coming from, a special form of the `import` statement is used to import `given` instances. 

ex
```scala
object A:
  class TC
  given tc: TC = ??? // 
  def f(using TC) = ???

object B:
  import A.*       // import all non-given members
  import A.given   // import the given instance
// or
object B:
  import A.{given, *}
```

## Type Classes/类型类

A type class is **an abstract, parameterized type**/抽象的参数化的类型 that lets you **add new behavior to any closed data type without using sub-typing**. If you are coming from Java, you can think of type classes as something like `java.util.Comparator[T]`.

use cases
- express how a type you don't own(from the standard library or a third-party library) conforms to such behavior./类型符合行为
- express sub a behavior for multiple types without involving sub-type relationships between those types./符合行为的多个类型之间无父子类关系

See Also
* “Type Classes as Objects and Implicits” (2010) by Oliveira et al.

ex:
```scala
// Scala 2
trait Showable[A] {  // a type class
  def show(a: A): String // method parameter type as `A`
}
trait Show {         // a trait
  def show: String
}
// Implement concrete instances
case class Person(firstName: String, lastName: String)
implicit val showablePerson: Showable[Person] = new Showable[Person] { // implicit value
  def show(p: Person): String =
    s"${p.firstName} ${p.lastName}"
}
// Using the type class
val person = Person("John", "Doe")
println(showablePerson.show(person))
// Writing methods that use the type class
def showAll[A](as: List[A])(implicit showable: Showable[A]): Unit =    // implicit parameter list
  as.foreach(a => println(showable.show(a)))
showAll(List(Person("Jane"), Person("Mary")))
// A type class with multiple methods
trait HasLegs[A] {
  def walk(a: A): Unit
  def run(a: A): Unit
}

// Scala 3
trait Showable[A]:   // a type class
  extension (a: A) def show: String              // extension receiver as `A`
trait Show:          // a trait
  def show: String
// Implement concrete instances
case class Person(firstName: String, lastName: String)
given Showable[Person] with                      // given value
  extension (p: Person) def show: String =
    s"${p.firstName} ${p.lastName}"
// Using the type class
val person = Person("John", "Doe")
println(person.show)
// Writing methods that use the type class
def showAll[A: Showable](as: List[A]): Unit =
  as.foreach(a => println(a.show))
showAll(List(Person("Jane"), Person("Mary")))
// A type class with multiple methods
trait HasLegs[A]:
  extension (a: A)
    def walk(): Unit
    def run(): Unit
```

## Multiversal Equality/多元宇宙相等性

Scala has **universal equality**: Two values of any types could be compared with each other using `==` and `!=`. This came from the fact that `==` and `!=` are implemented in terms of Java’s `equals` method, which can also compare values of any two reference types.

**Multiversal equality** is an opt-in way to make universal equality safer. It uses the binary type class `CanEqual` to **indicate that values of two given types can be compared with each other**.

Scala 3 enable strict equality feature:
```scala
import scala.language.strictEquality
// compiler option: -language:strictEquality
```

Scala 3 enable comparasion using `CanEqual` type class:
```scala
// option 1: derives
case class Dog(name: String) derives CanEqual

// option 2: given
case class Dog(name: String)
given CanEqual[Dog, Dog] = CanEqual.derived
```

## Implicit Conversions/隐式转换

Implicit conversions are a powerful Scala feature that allows users to **supply an argument of one type as if it were another type, to avoid boilerplate**.

In Scala 2, implicit conversions were also used to provide additional members to closed classes (**Implicit Classes**). 
In Scala 3, we recommend to address this use-case by defining **extension methods** instead of implicit conversions (although the standard library still relies on implicit conversions for historical reasons).

In Scala 2, an implicit conversion from type `S` to type `T` is defined  
- by an **implicit class** `T` that takes a single constructor parameter of type `S`, an **implicit value** of function type `S => T`, or 
- by an **implicit method** convertible to a value of that type.
```scala
import scala.language.implicitConversions
// an implicit conversion from `Int` to `Long`
implicit def int2long(x: Int): Long = x.toLong
```

In Scala 3, an implicit conversion from type `S` to type `T` is defined by a `given` instance of type `scala.Conversion[S, T]`.
```scala
// an implicit conversion from `Int` to `Long`
given int2long: Conversion[Int, Long] with
  def apply(x: Int): Long = x.toLong
// implicit conversions can be anonymous
given Conversion[Int, Long] with
  def apply(x: Int): Long = x.toLong
// using an alias
given Conversion[Int, Long] = (x: Int) => x.toLong
```

Implicit conversions are applied in two situations:
- If an expression `e` is of type `S`, and `S` does not conform to the expression’s expected type `T`.
  - a conversion `c` is searched for, which is applicable to `e` and whose result type conforms to `T`.
- In a selection `e.m` with `e` of type `S`, if the selector `m` does not denote a member of `S` (to support Scala-2-style extension methods).
  - a conversion `c` is searched for, which is applicable to `e` and whose result contains a member named `m`.

How Are Implicit Conversions Brought Into Scope?

When the compiler searches for applicable conversions:
- first, it looks into the **current lexical scope**/当前词法作用域
  - implicit conversions defined in the current scope or the outer scopes/定义在当前作用域或外围作用域的隐式转换
  - imported implicit conversions/导入的隐式转换
  - implicit conversions imported by a wildcard import (Scala 2 only)/通过通配符导入的隐式转换
- then, it looks into the **companion objects associated with the argument type `S` or the expected type `T`**. The companion objects associated with a type `X` are:/类型`X`的伴生对象
  - the companion object `X` itself/伴生对象`X`本身
  - the companion objects associated with any of `X`’s inherited types/类型`X`继承的类型的伴生对象
  - the companion objects associated with any type argument in `X`/类型`X`中类型参数的伴生对象
  - if `X` is an inner class, the outer objects in which it is embedded/包裹内部类`X`的对象

To turn off the warnings take either of these actions:
- Import `scala.language.implicitConversions` into the scope of:
  - a Scala 2 style implicit conversion definition
  - call sites where a given instance of `scala.Conversion` is inserted as a conversion. (Scala 3)
- Invoke the compiler with `-language:implicitConversions`.

# Concurrency
# Scala Tools
# Interacting with Java
# Scala for Java Developers
# Scala for JavaScript Developers
* https://docs.scala-lang.org/scala3/book/scala-for-javascript-devs.html

This page provides a comparison between the JavaScript and Scala programming languages. It’s intended for programmers who know JavaScript and want to learn about Scala, specifically by seeing examples of how JavaScript language features compare to Scala.

# Scala for Python Developers
