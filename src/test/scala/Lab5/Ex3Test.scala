package Lab5

import chisel3._
import chiseltest._
import chisel3.util._
import org.scalatest._
import scala.util.Random

// HARDWIRED TEST:-
// 
// class TestOperator extends FreeSpec with ChiselScalatestTester{
//     "Operator Test" in{
//         test(new Operator(4, UInt(4.W))(_ + _)){z =>
//         z.io.in(0).poke(2.U)
//         z.io.in(1).poke(6.U)
//         z.io.in(2).poke(1.U)
//         z.io.in(3).poke(3.U)
//         z.io.out(0).expect(0.U)
//         z.io.out(1).expect(0.U)
//         z.io.out(2).expect(1.U)
//         z.io.out(3).expect(1.U)
//         }
//     }
// }

// AUTOMATED TEST:-
// 
class TestOperator extends FreeSpec with ChiselScalatestTester{
    "Operator Test" in{
        test(new Operator(4, UInt(4.W))(_ + _)){z =>
        for(i <- 0 until 100){
            val in0 = (Random.nextLong() & 0xFFFFFFFFL) & 0x3
            val in1 = (Random.nextLong() & 0xFFFFFFFFL) & 0x3
            val in2 = (Random.nextLong() & 0xFFFFFFFFL) & 0x3
            val in3 = (Random.nextLong() & 0xFFFFFFFFL) & 0x3
            val inArray = Array(in3, in2, in1, in0)
            val sum = inArray.reduce(_ + _).U

            z.io.in(0).poke(in0.U)
            z.io.in(1).poke(in1.U)
            z.io.in(2).poke(in2.U)
            z.io.in(3).poke(in3.U)
            z.io.out(0).expect(sum(0))
            z.io.out(1).expect(sum(1))
            z.io.out(2).expect(sum(2))
            z.io.out(3).expect(sum(3))
        }}
    }
}