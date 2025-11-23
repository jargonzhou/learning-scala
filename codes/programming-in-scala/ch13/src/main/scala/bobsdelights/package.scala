// Listing 13.14 package object
package object bobsdelights {
  def showFruit(fruit: Fruit) {
    import fruit._
    println(name + "s are " + color)
  }

  // any kind of definitions that you can put inside a class can also be at the top level of a package.
  // more usage:
  // hold packagewide type aliases and implicit conversions: ex scala package
}
