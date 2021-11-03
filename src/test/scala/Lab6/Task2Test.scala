package Lab6

import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest._

class TestCounterWithXOR extends FreeSpec with ChiselScalatestTester{
    "Counter with XOR" in{
        test(new CounterWithXOR()){z =>
        z.clock.step(50)}
    }
}