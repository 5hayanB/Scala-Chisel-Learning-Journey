package Lab6

import chisel3._
import chisel3.util._
import scala.util.Random
import org.scalatest._
import chiseltest._

class TestCounter extends FreeSpec with ChiselScalatestTester{
    "Minimized Counter" in{
        test(new Counter(7)){z =>
        z.clock.step(30)}
    }
}