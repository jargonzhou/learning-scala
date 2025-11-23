// Listing 13.4 concise access to classes and packages
package bobsrockets3 {
  package navigation {
    // in package bobsrockets3.navigation
    class Navigator {
      // a class can be accessed from within its own package without needing a prefix: StarMap
      val map = new StarMap
    }

    // in package bobsrockets3.navigation
    class StarMap
  }

  // in package bobsrockets3
  class Ship {
    // a package can be accessed from its containing package without needing a prefix: bobsrockets3
    val nav = new navigation.Navigator
  }

  // see bobsrockets3_2.scala
  //
  // package fleets {
  //   // in package bobsrockets3.fleets
  //   class Fleet {
  //     // when using {}, all names accessible in scopes outside the packageing are also available inside it: Ship
  //     def addShip() = { new Ship }
  //   }
  // }

}
