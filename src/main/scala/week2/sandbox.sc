object Sandbox {

}

val opt: Option[Int] = None
val some: Option[Int] = Some(1)

opt.flatMap(Some.apply)

opt.flatMap((i) => Some(i * 2))

opt.map((i) => Some(i * 2))

some.flatMap(Some.apply)

some.flatMap((i) => Some(i * 2))

def WHILE(cond: => Boolean)(command: => Unit): Unit = {
  if (cond) {
    command
    WHILE(cond)(command)
  } else ()
}

def REPEAT(command: => Unit)(cond: => Boolean): Unit = {
  command
  if (cond) REPEAT(command)(cond)
  else ()
}

var x = 0

println("hello world")
WHILE(x <= 5)({x = x + 1; ()})
println(x)
var y = 0

REPEAT{ println("hello") }(cond = false)
println(y)

def UNTIL(f: () => Boolean): Boolean = {
   f()
}

REPEAT {
  println("hello")
} UNTIL(false)



