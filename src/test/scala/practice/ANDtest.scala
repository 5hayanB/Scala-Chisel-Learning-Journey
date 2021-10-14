package practice
import org.scalatest._
import chiseltest._
import chisel3._

class ANDtest extends FreeSpec with ChiselScalatestTester{
    "AND Gate Test" in {
        test(new AND()){c =>
        c.io.in1.poke(1.U)
        c.io.in2.poke(0.U)
        c.clock.step(0)
        c.io.out.expect(0.U)
        }
    }
}