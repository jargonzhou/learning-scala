// Listing 13.12 flexible scope of protection with access quanlifiers
package bobsdelights_scope

package navigation {
  // in package bobsdelights_scope.navigation
  // Navigator is visible in all classes and objects contained in bobsdelights_scope(including subpackages)
  private[bobsdelights_scope] class Navigator {
    // useStarChart is visible in all subclasses of Navigator and in all code contained in navigation
    protected[navigation] def useStarChart() = {}
    // inner class
    class LegOfJourney {
      // no access modifier:          public access
      // private[bobsdelights_scope]: access within outer package
      // private[navigation]:         same as package visibility in Java
      // private[Navigator]:          same as private in Java
      // private[LegOfJourney]:       same as private in Scala
      // private[this]:               access only from same object
      private[Navigator] val distance = 100
    }
    // object-private
    private[this] var speed = 200
  }
}

package launch {
  import navigation._
  // in package bobsdelights_scope.launch
  object Vehicle {
    // equivalent to Java's package-private access
    private[launch] val guide = new Navigator
  }
}
