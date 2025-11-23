// Listing 13.10 how private access differs in Scala and Java
package access_modifiers

class Outer {
  class Inner {
    private def f() = { println("f") }
    class InnerMost {
      f() // OK
    }
  }

  // method f in class Inner cannot be accessed as a member of Outer.this.Inner from class Outer in package access_modifiers
  // (new Inner).f()
}
