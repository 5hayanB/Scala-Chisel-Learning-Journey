package Assignment02

import util.Random

object Task4 {
  // 1) Recursive Function
  def evenRec (arr: Array[Int]): Int = {
    def count (n: Int, acc: Int, arr: Array[Int]): Int = {
      if (n == 0) acc
      else if (arr(n) % 2 == 0) count(n - 1, acc + 1, arr)
      else count(n - 1, acc, arr)
    }
    count(arr.length - 1, 0, arr)
  }
  // 2) Count Method
  def cont (ar: Array[Int]): Int =
    ar.count(_ % 2 == 0)

  def main (args: Array[String]): Unit = {
    val a: Array[Int] = Array.fill(100)(Random.nextInt(100))
    println(a.mkString("Array(", ", ", ")"))
    println("Using Recursive Function")
    println(evenRec(a))
    println("Using Count Higher Order Method")
    println(cont(a))
  }
}
