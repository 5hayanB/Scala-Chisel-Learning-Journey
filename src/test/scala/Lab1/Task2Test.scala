package Lab1
import org.scalatest._
import chiseltest._
import chisel3._

class Test_Counter_Up_Down extends FreeSpec with ChiselScalatestTester{
    "Up Down Counter" in {
        test(new Counter_Up_Down(4)){a =>
        a.clock.step(50)
        }
    }
}