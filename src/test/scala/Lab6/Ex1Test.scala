package Lab6

import chisel3._
import chiseltest._
import org.scalatest._
import scala.util.Random

class TestShiftReg extends FreeSpec with ChiselScalatestTester{
    "Parallel Load Shift Register" in{
        test(new ShiftReg()){z =>
        z.clock.step(50)
        }
    }
}