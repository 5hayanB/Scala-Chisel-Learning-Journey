package Lab3
import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest._

class TestEncoder4to2 extends FreeSpec with ChiselScalatestTester{
    "4 to 2 Encoder with Switch" in {
        test(new Encoder4to2()){a =>
        a.io.in.poke(4.U)
        a.io.out.expect(3.U)}
    }
}