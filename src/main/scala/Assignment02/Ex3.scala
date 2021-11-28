package Assignment02

object Ex3 {
  private def find (f: Option[String]) =
    f match {
      case Some(v) => v
      case None => "Key not found"
    }

  def main (args: Array[String]):Unit = {
    val mapCol = Map(2 -> "1st", 4 -> "2nd", 8 -> "3rd", 16 -> "4th")
    println(find(mapCol.get(4)))
  }
}
