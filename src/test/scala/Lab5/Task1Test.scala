package Lab5

import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest._
import scala.util.Random

// HARDWIRED TEST:-
//
// class TestAdder extends FreeSpec with ChiselScalatestTester{
//     "Lab5 Test Adder" in{
//         test(new Adder(4)){z =>
//             z.io.in0.poke(1.S)
//             z.io.in1.poke(3.S)
//             z.io.sum.expect(4.S)
//         }
//     }
// }

// AUTOMATED TEST:-
// 
class TestAdder extends FreeSpec with ChiselScalatestTester{
    "Lab5 Test Adder" in{
        test(new Adder(32)){z =>
            for(i <- 0 until 100){
                val in0 = Random.nextInt()
                val in1 = Random.nextInt()
                val sum = in0 + in1
                z.io.in0.poke(in0.S)
                z.io.in1.poke(in1.S)
                z.io.sum.expect(sum.S)
            }
        }
    }
}