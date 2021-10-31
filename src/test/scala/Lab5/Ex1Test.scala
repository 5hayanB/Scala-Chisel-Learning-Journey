package Lab5

import chisel3._
import chiseltest._
import org.scalatest._
import chisel3.util._
import scala.util.Random

// HARDWIRED TEST:-
// 
// class ALUTest extends FreeSpec with ChiselScalatestTester{
//     "Lab5 ALU Test" in{
//         val width = 32
//         test(new ALU(width)){a =>
//         a.io.argx.poke(5.S)
//         a.io.argy.poke(7.S)
//         a.io.aluOper.poke(8.U)
//         a.io.aluOut.expect(1.S)}
//     }
// }

// AUTOMATED TEST:-
// 
class ALUTest extends FreeSpec with ChiselScalatestTester{
    "Lab5 ALU Test" in{
        val width = 32
        test(new ALU(width)){a =>
        for(i <- 0 until 100){
            val in1 = Random.nextLong() & 0xFFFFFFFFL
            val in2 = Random.nextLong() & 0xFFFFFFFFL
            val opIn = Random.nextInt(10)
            val result = opIn match{
                case 0 => in1 & in2
                case 1 => in1 | in2
                case 2 => in1 + in2
                case 3 => in1 ^ in2
                case 4 => in1 << (in2 & 0x1F)
                case 5 => in1 >> (in2 & 0x1F)
                case 6 => in1 - in2
                case 7 => in1.toInt >> (in2 & 0x1F)
                case 8 => if(in1.toInt < in2.toInt){1}
                            else{0}
                case 9 => if(in1 < in2){1}
                            else{0}
            }
            val out: BigInt = if(result < 0){(BigInt(0xFFFFFFFFL) + result + 1) & 0xFFFFFFFFL}
                                else{result & 0xFFFFFFFFL}
            a.io.argx.poke(in1.U)
            a.io.argy.poke(in2.U)
            a.io.aluOper.poke(opIn.U)
            a.io.aluOut.expect(out.U)
        }
        }
    }
}