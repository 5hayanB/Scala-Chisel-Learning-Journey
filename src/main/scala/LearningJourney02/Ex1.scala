package LearningJourney02

object Ex1 {
  def fib (n: Int): Int = {
    @annotation.tailrec
    def go (n: Int, acc1: Int, acc2: Int): Int = {
      if (n == 1) acc1
      else if (n == 2) acc2
      else go(n-1, acc2, acc1+acc2)
    }
    go(n, 0, 1)
  }
  def main (args: Array[String]) = {
    println(fib(6))
  }
}
