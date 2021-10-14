package practice
import chisel3._
import org.scalatest._
import chiseltest._

class XNORtest extends FreeSpec with ChiselScalatestTester{
    "XNOR Gate Test" in {
        test(new XNOR()){x =>
        x.io.in1.poke(0.U)
        x.io.in2.poke(0.U)
        x.io.out.expect(1.U)
        x.clock.step(0)
        }
    }
}