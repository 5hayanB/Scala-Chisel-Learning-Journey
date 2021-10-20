package Lab2
import org.scalatest._
import chisel3._
import chiseltest._

class Test_MUX1H_4to2 extends FreeSpec with ChiselScalatestTester{
    "4 to 2 Priority Encoder" in{
        test(new MUX1H_4to2()){a =>
            a.io.in0.poke(0.U)
            a.io.in1.poke(1.U)
            a.io.in2.poke(0.U)
            a.io.in3.poke(0.U)
            a.io.out0.expect(1.U)
            a.io.out1.expect(0.U)
            a.clock.step(0)
        }
    }
}