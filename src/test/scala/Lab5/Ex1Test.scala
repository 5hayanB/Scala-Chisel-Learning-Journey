// package Lab5
// import chisel3._
// import chiseltest._
// import org.scalatest._
// import chisel3.util._
// import scala.util.Random

// class ALUTest extends FreeSpec with ChiselScalatestTester{
//     "Lab5 ALU Test" in{
//         val width = 32
//         test(new ALU(width)){a =>
//             val and = 0
//             val or = 0
//             val add = 0
//             val sub = 0
//             val xor = 0
//             val sll = 0
//             val srl = 0
//             val sra = 0
//             val slt = 0
//             val sltu = 0
//             val opArray = Array(and, or, add, sub, xor, sll, srl, sra, slt, sltu)
//             for(i <- 0 until 100){
//                 val in1 = Random.nextLong()
//                 val in2 = Random.nextLong()
//                 val op = Random.nextInt(9)
//                 val opIn = opArray(op)
//                 val result = opIn match{
//                     case and => in1 & in2
//                     case or => in1 | in2
//                     case add => in1 + in2
//                     case sub => in1 - in2
//                     case xor => in1 ^ in2
//                     case sll => in1 << in2(a.index - 1, 0)
//                     case srl => in1 >> in2(a.index - 1, 0)
//                     case sra => in1.toInt >> in2(a.index - 1, 0).asSInt
//                     case slt => in1.toSInt < in2.asSInt
//                     case sltu => in1 < in2
//                     case _ => 0
//                 }
//                 val resultT = if(result < 0){}
//                 a.io.arg_x.poke(in1)
//                 a.io.arg_y.poke(in2)
//                 a.io.alu_oper.poke(opIn)
//                 a.io.alu_out.expect(result)
//             }
//             a.clock.step(150)
//         }
//     }
// }