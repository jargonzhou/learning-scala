// object Sets {
//   def main(args: Array[String]): Unit = {
//     import org.openjdk.jol.vm.VM
//     println(VM.current().details())

//     // Listing 3.5 creating, initializing and using an immutable set
//     var jetSet = Set("Boeing", "Airbus")
//     println(VM.current().addressOf(jetSet))
//     jetSet += "Lear"
//     println(VM.current().addressOf(jetSet))
//     println(jetSet.contains("Cessna"))

//     // Listing 3.6 creating, initializing and using a mutable set
//     import scala.collection.mutable
//     val movieSet = mutable.Set("Hitch", "Poltergeist")
//     println(VM.current().addressOf(jetSet))
//     movieSet += "Shrek"
//     println(VM.current().addressOf(jetSet))
//     println(movieSet)
//   }
// }

// Output
// # WARNING: Unable to attach Serviceability Agent. Unable to attach even with module exceptions: [org.openjdk.jol.vm.sa.SASupportException: Sense failed., org.openjdk.jol.vm.sa.SASupportException: Sense failed., org.openjdk.jol.vm.sa.SASupportException: Sense failed.]
// # VM mode: 64 bits
// # Compressed references (oops): 3-bit shift
// # Compressed class pointers: 3-bit shift
// # WARNING | Compressed references base/shifts are guessed by the experiment!
// # WARNING | Therefore, computed addresses are just guesses, and ARE NOT RELIABLE.
// # WARNING | Make sure to attach Serviceability Agent to get the reliable addresses.
// # Object alignment: 8 bytes
// #                       ref, bool, byte, char, shrt,  int,  flt,  lng,  dbl
// # Field sizes:            4,    1,    1,    2,    2,    4,    4,    8,    8
// # Array element sizes:    4,    1,    1,    2,    2,    4,    4,    8,    8
// # Array base offsets:    16,   16,   16,   16,   16,   16,   16,   16,   16

// 31718054464
// 31718280448
// false
// 31718280448
// 31718280448
// HashSet(Hitch, Shrek, Poltergeist)
