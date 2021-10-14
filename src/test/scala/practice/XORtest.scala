package practice
import org.scalatest._
import chisel3._
import chiseltest._

class XORtest extends FreeSpec with ChiselScalatestTester{
    "XOR Gate Test" in {
        test(new XOR()){c =>
        c.io.in1.poke(1.U)
        c.io.in2.poke(1.U)
        c.clock.step(0)
        c.io.out.expect(0.U)}
    }
}