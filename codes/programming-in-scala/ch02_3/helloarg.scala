@main def m2(args: String*) =
  // println("Hello, " + args(0) + "!")
  // args.foreach(arg => println(arg))
  // args.foreach(println)
  for arg <- args do println(arg)
