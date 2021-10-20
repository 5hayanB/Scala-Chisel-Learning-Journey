package Lab2
import org.scalatest._
import chiseltest._
import chisel3._

class TestMUXLookUp extends FreeSpec with ChiselScalatestTester{
    "Exercise 2" in{
        test(new MUXLookup()){a =>
        a.io.in0.poke(true.B)
        a.io.in1.poke(false.B)
        a.io.in2.poke(true.B)
        a.io.in3.poke(false.B)
        a.io.in4.poke(true.B)
        a.io.in5.poke(false.B)
        a.io.in6.poke(true.B)
        a.io.in7.poke(false.B)
        a.io.sel.poke(4.U)
        a.io.out.expect(true.B)
        a.clock.step(0)}
    }
}