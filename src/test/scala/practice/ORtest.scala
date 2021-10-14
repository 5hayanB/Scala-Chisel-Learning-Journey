package practice
import org.scalatest._
import chiseltest._
import chisel3._

class ORtest extends FreeSpec with ChiselScalatestTester{
    "OR Gate Test" in {
        test(new OR()){c =>
        c.io.in1.poke(1.U)
        c.io.in2.poke(0.U)
        c.io.out.expect(1.U)
        c.clock.step(0)
        }
    }
}