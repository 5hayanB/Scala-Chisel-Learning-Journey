package Assignment02

object Task3 {
  def elemSum (arr1: Array[Int], arr2: Array[Int]): Array[Int] = {
    val ar = new Array[Int](arr1.length)
    @annotation.tailrec
    def go (n: Int, a1: Array[Int], a2: Array[Int], ar: Array[Int]): Array[Int] = {
      ar(n) = a1(n) + a2(n)
      if (n == ar.length - 1) ar
      else go(n + 1, a1, a2, ar)
    }
    go(0, arr1, arr2, ar)
  }
  def main (args: Array[String]): Unit = {
    val a1: Array[Int] = Array(1, 2, 3)
    val a2: Array[Int] = Array(4, 5, 6)
    println(elemSum(a1, a2).mkString("Array(", ", ", ")"))
  }
}
