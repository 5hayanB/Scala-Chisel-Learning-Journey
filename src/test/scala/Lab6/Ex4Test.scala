package Lab6

import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._

class TestQueue extends FreeSpec with ChiselScalatestTester{
    "Queue Test" in{
        test(new MyQueue()){z =>
        z.io.in.valid.poke(1.B)
        z.io.in.ready.expect(1.B)
        z.io.in.bits.poke(3.U)
        z.clock.step(2)
        z.io.out.valid.expect(1.B)
        z.io.out.ready.poke(1.B)
        z.io.out.bits.expect(3.U)}
    }
}

// SIMPLE QUEUE TEST:-
// class TestQueue extends FreeSpec with ChiselScalatestTester{
//     "Queue Test" in{
//         test(new MyQueue()){z =>
//         z.io.in.valid.poke(1.B)
//         z.io.in.bits.poke(3.U)
//         z.io.out.ready.poke(1.B)
//         z.clock.step(1)
//         z.io.in.ready.expect(1.B)
//         z.io.out.valid.expect(1.B)
//         z.io.out.bits.expect(3.U)
//         }
//     }
// }
