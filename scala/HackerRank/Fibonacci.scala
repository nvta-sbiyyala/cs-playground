import scala.io.StdIn

object Fibonacci {
    
     def fibonacci(x:Int):Int = {
        if (x == 0 || x == 1) x
        else fibonacci(x-1) + fibonacci(x-2)
    }

    def main(args: Array[String]) {
         println(fibonacci(StdIn.readInt()))
    }
}
