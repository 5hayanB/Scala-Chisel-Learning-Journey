package Lab6

import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest._

class TestTwoShotTimer extends FreeSpec with ChiselScalatestTester{
    "Two Shot Timer" in{
        test(new TwoShotTimer(7)){z =>
        z.clock.step(50)
        }
    }
}