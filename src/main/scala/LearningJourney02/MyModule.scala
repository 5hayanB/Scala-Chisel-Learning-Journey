package LearningJourney02

object MyModule {
  def abs (n: Int): Int = { // can be accessed globally
    if (n < 0) -n
    else n
  }
  private def factorial (n: Int): Int = {  // Stack Recursion
    if (n == 1) n
    else factorial(n - 1) * n
  }
  private def fact (n: Int): Int = {  // Tail Recursion
    @annotation.tailrec
    def go (n: Int, acc: Int): Int = {
      if (n <= 0) acc
      else go(n-1, n*acc)
    }
    go(n, 1)
  }
  private def formatAbs (n: Int): String = {  // Cannot be accessed globally
    val msg = "The absolute value of %d is %d"
    msg.format(n, abs(n))
  }
  private def formatFactorial (n: Int): String = {
    val msg = "The factorial of %d is %d"
    msg.format(n, fact(n))
  }
  private def formatResult (n: Int, func: Int => Int, name: String): String = {
    val msg = "The %s of %d is %d"
    msg.format(name, n, func(n))
  }
  def main (args: Array[String]) = {
    println(formatAbs(-42))
    println(factorial(5))
    println(fact(5))
    println(formatFactorial(3))
    println(formatResult(3, fact, "factorial"))
  }
}
