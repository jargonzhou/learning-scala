// Listing 3.1 parameterizing an array with a type
val greetStrings = new Array[String](3)

greetStrings(0) = "Hello"
greetStrings(1) = ", "
greetStrings(2) = "world!\n"

for (i <- 0 to 2)
  print(greetStrings(i))

// Listing 3.2 creating and initializing an array
val numNames = Array("zero", "one", "two")
for (numName <- numNames)
  print(numName + " ")
