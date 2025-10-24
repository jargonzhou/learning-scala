// print banner
println("Hello World!!")

// common imports
import sys.process._
import collection.mutable

// common initialization code
val x = 123
println("x is " + 123)

def hello(): Unit = {
  println("Hello Scala!")
}


//
// run in current folder
//
def exec(commands: String*): Unit = {
  val res = os.proc(commands).call()
  if (res.exitCode == 0) {
    print(res.out.trim())
  } else {
    print(res.err.trim())
  }
}

def execForce(commands: String*): Unit = {
  try {
    exec(commands: _*)
  } catch {
    case ex: Exception => println(ex)
  }
}


//
// run in specific folder
//
def exec2(commands: String*): Unit = exec2(os.pwd, commands: _*)
def exec2(cwd: os.Path, commands: String*): Unit = {
  val res = os.proc(commands).call(cwd=cwd)
  if (res.exitCode == 0) {
    print(res.out.trim())
  } else {
    print(res.err.trim())
  }
}

def execForce2(commands: String*): Unit = execForce2(os.pwd, commands: _*)
def execForce2(cwd: os.Path, commands: String*): Unit = {
  try {
    exec2(cwd=cwd, commands: _*)
  } catch {
    case ex: Exception => println(ex)
  }
}

// Examples:
// exec2(cwd=os.pwd / "hello-world", "sbt.bat", "run")
// exec2(commands=Seq[String]("sbt.bat", "--version") : _*)