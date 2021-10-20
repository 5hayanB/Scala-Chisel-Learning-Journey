package Lab2
import chisel3._
import org.scalatest._
import chiseltest._
import chisel3.util._

class Test_MUX_5to1 extends FreeSpec with ChiselScalatestTester{
    "5 to 1 MUX" in{
        test(new MUX_5to1()){a =>
        a.io.s0.poke(false.B)
        a.io.s1.poke(true.B)
        a.io.s2.poke(false.B)
        a.io.out.expect(16.U)}
        //a.clock.step(0)
    }
}