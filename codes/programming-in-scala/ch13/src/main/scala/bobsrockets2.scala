// Listing 13.3 multiple packages in the same file
package bobsrockets2 {
  package navigation {
    // in package bobsrockets2.navigation
    class Navigator

    package tests {
      // in package bobsrockets2.navigation.tests
      class NavigatorSuite
    }
  }
}
