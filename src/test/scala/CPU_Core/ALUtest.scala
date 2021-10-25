// package CPU_Core
// import chisel3._
// import chisel3.util._
// import scalatest._
// import chiseltest._

// class ALUTest extends with FreeSpec with ChiselScalatestTester{
//     "ALU Testing" in{
//         test(new ALU()){x =>
//         x.io.rs1.poke()
//         x.io.rs2.poke()
//         x.io.imm.poke()
//         x.io.func3.poke()
//         x.io.func7.poke()
//         x.io.id.poke()
//         x.io.immSel.poke()
//         x.io.out.expect()}
//     }
// }