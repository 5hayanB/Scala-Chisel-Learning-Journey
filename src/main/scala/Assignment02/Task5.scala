package Assignment02

object Task5 {
  def buildMap [A, B] (data: Seq[A], f: A => B): Map[B, A] = {
    // Your code
    val charMap = data.map(x => f(x) -> x).toMap
    charMap
  }
  def main (args: Array[String]): Unit = {
    val arr: Array[Char] = Array('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L')
    def charConvert (v: Char): Int = v.toInt
    println(buildMap(arr, charConvert))
  }
}
