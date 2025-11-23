var i = 0
// loop with while
while (i < args.length) {
  if (i != 0)
    print(" ")
  print(args(i))
  i += 1
}
println()

// iterate with foreach
// args.foreach(arg => println(arg)) // function literal
// args.foreach((arg: String) => println(arg)) // explicit argument type
// shorthand: a function literal consists of one statement takes a single argument
// args.foreach(println)
args foreach println

// for expression
for (arg <- args)
  println(arg)
