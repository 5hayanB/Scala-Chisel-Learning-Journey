package Assignment02

import util.Random
import math._

object Task1 {
  private def randList (lst: List[Int]) = {
    def loop (n: Int, lst: List[Int]): List[Int] =
      if (n <= 0) lst
      else {
        val num = Random.nextInt(501)
        if (num >= 50) loop(n-1, num :: lst)
        else loop(n, lst)
      }
    loop(15, lst)
  }
  private def isPrime (num: Int): Boolean = {
    def check (n: Int, num: Int): Boolean =
      if (n == num ) true
      else if (num % n != 0) check(n + 1, num)
      else false
    check(2, num)
  }
  def sort (it: Iterator[Int]): Iterator[Int] = {
    val arr: Array[Int] = it.toArray
    @annotation.tailrec
    def loop (n: Int, arr: Array[Int]): Array[Int] =
      if (n == arr.length - 1) arr
      else {
        val sliceArr: Array[Int] = arr.slice(n, arr.length)
        val mini = sliceArr.min
        val temp = arr(n)
        arr(n) = mini
        println(arr.mkString("Array(", ", ", ")"))
        loop(n + 1, arr)
      }
    loop(0, arr).toIterator
  }
  def main (args: Array[String]) = {
    val lst = List()
    val rand = randList(lst)
    println(rand)
    println("Iterator of prime numbers")
//    val primeIter: Iterator[Int] = rand.filter(isPrime).toIterator
    val primeIter = Iterator(5, 4, 8, 3, 1, 9)
    val sortedPrIt: Iterator[Int] = sort(primeIter)
    println(sortedPrIt.mkString("Array(", ", ", ")"))
  }
}
