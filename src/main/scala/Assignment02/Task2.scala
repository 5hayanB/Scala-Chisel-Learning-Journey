package Assignment02

object Task2 {
  def charArray (start: Int): List[Char] = {
    // Your Code
    val charList: List[Char] = List()
    @annotation.tailrec
    def go (n: Int, charLst: List[Char]): List[Char] =
      if (n == 97) n.toChar :: charLst
      else go(n - 1, n.toChar :: charLst)
    go(start, charList)
  }
  def main (args: Array[String]) =
    println(charArray(122))
}
