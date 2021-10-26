// package Lab5
// import chisel3._
// import chiseltest._
// import org.scalatest._
// import chisel3.util._

// class ALUTest extends FreeSpec with ChiselScalatestTester{
//     "Test ALU Lab5" in{
//         test(new ALU(32)){a =>
//             a.io.arg_x.poke(4.U)
//             a.io.arg_y.poke(5.U)
//             a.io.alu_oper.poke(0.U)
//             a.io.alu_out.expect(4.U)
//         }
//     }
// }