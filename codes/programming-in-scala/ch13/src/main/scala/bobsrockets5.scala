// Listing 13.6 accessing hidden package names
package bobsrockets5 {
  package navigation {
    package launch {
      // in package bobsrockets5.navigation.launch
      class Booster1
    }

    // in package bobsrockets5.navigation
    class MissionControl {
      val booster1 = new launch.Booster1
      val booster2 = new bobsrockets5.launch.Booster2
      val booster3 = new _root_.launch.Booster3 // launch.scala
    }
  }

  package launch {
    // in package bobsrockets5.launch
    class Booster2
  }
}
