// Listing 3.3 creating an iniitializing a list
val oneTwoThree = List(1, 2, 3)
for (e <- oneTwoThree)
  print(e.toString + " ")

val oneTwo = List(1, 2)
val threeFour = List(3, 4)
val oneTwoThreeFour = oneTwo ::: threeFour // list concatenation
println(oneTwo.toString + " and " + threeFour + " were not mutated.")
println("Thus, " + oneTwoThreeFour + " is a new list")

val twoThree = List(2, 3)
val oneTwoThree2 = 1 :: twoThree /// cons
println(oneTwoThree2)
val oneTwoThree3 = 1 :: 2 :: 3 :: Nil
println(oneTwoThree3)

List()
Nil
List("Cool", "tools", "rule")
val thrill = "Will" :: "fill" ::
  "until" :: Nil
List("a", "b") ::: List("c", "d")
thrill(2)
thrill.count(s => s.length == 4)
thrill.drop(2)
thrill.dropRight(2)
thrill.exists(s => s == "until")
thrill.filter(s => s.length == 4)
thrill.forall(s => s.endsWith("l"))
thrill.foreach(s => print(s))
thrill.foreach(print)
thrill.head
thrill.init
thrill.isEmpty
thrill.last
thrill.length
thrill.map(s => s + "y")
thrill.mkString(", ")
thrill.filterNot(s => s.length == 4)
thrill.reverse
thrill.sortWith((s, t) =>
  s.charAt(0).toLower <
    t.charAt(0).toLower
)
thrill.tail
