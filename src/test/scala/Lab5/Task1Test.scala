package Lab5

import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest._
import scala.util.Random

// HARDWIRED TEST:-
//
class TestAdder extends FreeSpec with ChiselScalatestTester{
    "Lab5 Test Adder" in{
        test(new Adder(4)){z =>
            z.io.in0.poke(1.S)
            z.io.in1.poke(3.S)
            z.io.sum.expect(4.S)
        }
    }
}