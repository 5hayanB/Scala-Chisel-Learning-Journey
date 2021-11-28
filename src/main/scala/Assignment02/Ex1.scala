package Assignment02

object Ex1 {
  private def arr (size: Int) = {
    val arr = new Array[Any](size)
    arr
  }
  def main (args: Array[String]): Unit = {
    val size = 10
    val arr1 = arr(size)
    for (i <- 0 until size) {
      arr1(i) = i
    }
    println("Array has been initiated")
    println(arr1.mkString("Array: (", ", ", ")"))
    println("Adding one more item")
    println((arr1 :+ 10).mkString("Array: (", ", ", ")"))
    println(arr1.mkString("Array: (", ", ", ")"))
  }
}
