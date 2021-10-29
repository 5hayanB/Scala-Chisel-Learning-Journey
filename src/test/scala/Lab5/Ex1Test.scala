package Lab5
import chisel3._
import chiseltest._
import org.scalatest._
import chisel3.util._
import scala.util.Random

class ALUTest extends FreeSpec with ChiselScalatestTester{
    "Lab5 ALU Test" in{
        val width = 32
        test(new ALU(width)){a =>
        a.io.argx.poke(5.S)
        a.io.argy.poke(7.S)
        a.io.aluOper.poke(8.U)
        a.io.aluOut.expect(1.S)}
    }
}
// class ALUTest extends FreeSpec with ChiselScalatestTester{
//     "Lab5 ALU Test" in{
//         val width = 32
//         test(new ALU(width)){a =>
//         for(i <- 0 until 5){
//             val in1 = Random.nextLong().toInt
//             val in2 = Random.nextLong().toInt
//             val in1U = if(in1 < 0){((BigInt(0xFFFFFFFFL) + in1 + 1) & 0xFFFFFFFFL).toInt}
//                         else{(in1 & 0xFFFFFFFFL).toInt}
//             val in2U = if(in2 < 0){((BigInt(0xFFFFFFFFL) + in2 + 1) & 0xFFFFFFFFL).toInt}
//                         else{(in2 & 0xFFFFFFFFL).toInt}
//             val in2UIndex = Random.nextInt(6)
//             val opIn = Random.nextInt(10)
//             val result = opIn match{
//                 case 0 => in1 & in2
//                 case 1 => in1 | in2
//                 case 2 => in1 + in2
//                 case 3 => in1 ^ in2
//                 case 4 => in1U << in2UIndex
//                 case 5 => in1U >> in2UIndex
//                 case 6 => in1 - in2
//                 case 7 => in1 >> in2UIndex
//                 case 8 => if(in1 < in2){1}
//                             else{0}
//                 case 9 => if(in1U < in2U){1}
//                             else{0}
//             }
//             println(in1, in2, in1U, in2U, opIn, result)
//             a.io.argx.poke(in1.S)
//             a.io.argy.poke(in2.S)
//             a.io.aluOper.poke(opIn.U)
//             a.io.aluOut.expect(result.S)
//         }
//         }
//     }
// }