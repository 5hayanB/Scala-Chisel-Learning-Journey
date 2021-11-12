package Lab8

import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest._

class TestMemAssignment extends FreeSpec with ChiselScalatestTester{
    "Memory Assignment" in{
        test(new MemAssignment()){z =>
        
        // requester 1
        z.io.requester(0).bits.poke(4.U)
        z.io.requester(0).valid.poke(1.B)
        // requester 2
        z.io.requester(1).bits.poke(6.U)
        z.io.requester(1).valid.poke(1.B)
        // requester 3
        z.io.requester(2).bits.poke(1.U)
        z.io.requester(2).valid.poke(1.B)
        // requester 4
        z.io.requester(3).bits.poke(5.U)
        z.io.requester(3).valid.poke(1.B)
        
        z.clock.step(100)
        }
    }
}