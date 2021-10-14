package practice
import org.scalatest._
import chiseltest._
import chisel3._

class NORtest extends FreeSpec with ChiselScalatestTester{
    "NOR Gate Test" in {
        test(new NOR()){a =>
        a.io.in1.poke(1.U)
        a.io.in2.poke(0.U)
        a.clock.step(0)
        a.io.out.expect(0.U)
        }
    }
}