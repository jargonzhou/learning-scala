// Listing 13.11 how protected access differs in Scala and Java
package access_modifiers

package p {
  class Super {
    protected def f() = { println("f") }
  }
  class Sub extends Super {
    f() // OK
  }
  class Other {
    // method f in class Super cannot be accessed as a member of access_modifiers.p.Super from class Other in package p
    //  Access to protected method f not permitted because
    //  enclosing class Other in package p is not a subclass of
    //  class Super in package p where target is defined
    // (new Super).f()
  }
}
