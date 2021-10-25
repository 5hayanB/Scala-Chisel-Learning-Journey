// package CPU_Core
// import chisel3._
// import chisel3.util._

// trait Config{
//     val WLEN = 32
// }
// class ALU_IO extends Bundle with Config{
//     val rs1 = Input(SInt(WLEN.W))
//     val rs2 = Input(SInt(WLEN.W))
//     val imm = Input(SInt(WLEN.W))
//     val immSel = Input(Bool())
//     val func3 = Input(UInt(3.W))
//     val func7 = Input(UInt(7.W))
//     val id = Input(UInt(5.W))
//     val out = Output(SInt(WLEN.W))
// }
// class OpSel_IO extends Bundle{
//     val func3 = Input(UInt(3.W))
//     val func7 = Input(UInt(7.W))
//     val id = Input(UInt(5.W))
//     val out = Output(UInt(5.W))
// }
// class OpSel extends Module{
//     val io = IO(new OpSel_IO)
//     // val opSel = Cat(io.id(2), io.func7(5), io.func3)
//     io.out := Cat(io.id(2), io.func7(5), io.func3)
// }
// class ALU extends Module with Config{
//     val io = IO(new ALU_IO)
//     val opSel = new Module(OpSel)
//     val op2 = Mux(immSel, io.imm, io.rs2)
//     opSel.io.func3 := io.func3
//     opSel.io.func7 := io.func7
//     opSel.io.id := io.id
//     io.out := 0.S
    
//     when(io.rs1 === op2){
//         val beq = 1.U(WLEN.W)
//     }.otherwise{
//         val beq = 0.U(WLEN.W)
//     }
//     when(io.rs1 =/= op2){
//         val bne = 1.U(WLEN.W)
//     }.otherwise{
//         val bne = 0.U(WLEN.W)
//     }
//     val sum = (io.rs1 + op2)(WLEN.W)
    
//     when(io.rs1 < op2){
//         val blt = 1.U(WLEN.W)
//     }.otherwise{
//         val blt = 0.U(WLEN.W)
//     }
//     when(io.rs1 >= op2){
//         val bge = 1.U(WLEN.W)
//     }.otherwise{
//         val bge = 0.U(WLEN.W)
//     }
//     when((io.rs1).asUInt < (op2).asUInt){
//         val bltu = 1.U(WLEN.W)
//     }.otherwise{
//         val bltu = 0.U(WLEN.W)
//     }
//     when((io.rs1).asUInt >= (op2).asUInt){
//         val bgeu = 1.U(WLEN.W)
//     }.otherwise{
//         val bgeu = 0.U(WLEN.W)
//     }
    






//     // switch(opSel.io.out){
//     //     is(0.U){
//     //         when(io.rs1 === op2){
//     //             io.out := 1.U(WLEN.W)
//     //         }.otherwise{
//     //             io.out := 0.U(WLEN.W)
//     //         }
//     //     }is(1.U){
//     //         when(io.rs1 =/= op2){
//     //             io.out := 1.U(WLEN.W)
//     //         }.otherwise{
//     //             io.out := 0.U(WLEN.W)
//     //         }
//     //     }is(2.U | 16){
//     //         io.out := io.rs1 + op2
//     //     }is(4.U | 18.U){
//     //         when((io.rs1).asSInt < (io.imm).asSInt){
//     //             io.out := 1.U(WLEN.W)
//     //         }.otherwise{
//     //             io.out := 0.U(WLEN.W)
//     //         }
//     //     }is(5.U){
//     //         when((io.rs1).asSInt >= (io.imm).asSInt){
//     //             io.out := 1.U(WLEN.W)
//     //         }.otherwise{
//     //             io.out := 0.U(WLEN.W)
//     //         }
//     //     }is(6.U | 19.U){
//     //         when(io.rs1 < io.imm){
//     //             io.out := 1.U(WLEN.W)
//     //         }.otherwise{
//     //             io.out := 0.U(WLEN.W)
//     //         }
//     //     }is(7.U){
//     //         when(io.rs1 >= io.imm){
//     //             io.out := 1.U(WLEN.W)
//     //         }.otherwise{
//     //             io.out := 0.U(WLEN.W)
//     //         }
//     //     }is(17.U){
//     //         io.out := io.rs1 << op2
//     //     }is(20.U){
//     //         io.out := io.rs1 ^ io.op2
//     //     }is(21.U){
//     //         io.out := io.rs1 
//     //     }
//     // }
// }