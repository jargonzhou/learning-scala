// Listing 13.14 package object
package printmenu
import bobsdelights.Fruits
import bobsdelights.showFruit // import function in package object

object PrintMenu {
  def main(args: Array[String]) = {
    for (fruit <- Fruits.menu) {
      showFruit(fruit)
    }
  }
}
