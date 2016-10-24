import scala.io.StdIn

object Fibonacci extends App {
  
  def fibonacci(x : Int) : Long = {
    if (x == 0 || x == 1) x
    else fibonacci(x-1) + fibonacci(x-2)
  }

  def fibonacciIterative(x : Int) : Long = {
    if (x == 0 || x == 1) x
    else {
      var x0 = 0
      var x1 = 1
      for (i <- 2 to x) {
        x1 = x0 + x1
        x0 = x1 - x0
      }
      x1
    }
  }

  val x: Int = StdIn.readInt()
  println("====Recursive Fibonacci====")
  println(fibonacci(x))
  println("====Iterative Fibonacci====")
  println(fibonacciIterative(x))

}
