@main def m(args: String*) =
  println("Hello, Scala!")
  var i = 0
  while i < args.length do
    println(args(i))
    i += 1