package practice

import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest._


class TestRoundRobinArb extends FreeSpec with ChiselScalatestTester{
    "Round Robin Arbiter" in{
        test(new RoundRobinArb()){z =>
        // POKES
        // in1
        z.io.in1.valid.poke(1.B)
        z.io.in1.bits.poke(5.U)
        // in2
        z.io.in2.valid.poke(1.B)
        z.io.in2.bits.poke(3.U)
        // in3
        z.io.in3.valid.poke(1.B)
        z.io.in3.bits.poke(7.U)
        // out
        z.io.out.ready.poke(1.B)

        z.clock.step(5)
        }
    }
}