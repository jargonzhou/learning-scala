// Listing 13.5 symbols in enclosing packages not automatically available
package bobsrockets4 {
  class Ship
}

package bobsrockets4.fleets { // in the top level
  class Fleet {
    // type Ship not found
    // def addShip() = { new Ship }
    def addShip() = { new bobsrockets4.Ship }
  }
}
