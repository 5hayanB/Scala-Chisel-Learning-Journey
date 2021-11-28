package Assignment02
import collection.mutable

object Ex2 {
  def main (args: Array[String]): Unit = {
    val mSet: mutable.Set[Int] = mutable.Set(4, 5, 6, 7)
    val mMap: mutable.Map[Int, String] = mutable.Map(0 -> "A", 1 -> "B", 3 -> "C")

    println(mSet)
    println("Adding an element to set")
    mSet.add(1)
    println(mSet)

    println(mMap)
    println("Adding a key-value pair to map")
    mMap(4) = "D"
    println(mMap)
  }
}
