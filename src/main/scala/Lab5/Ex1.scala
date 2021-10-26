// package Lab5
// import chisel3._
// import chisel3.util._
// //import chisel3.iotesters.{Driver, PeekPokeTester}

// class IO_Interface(width: Int) extends Bundle{
//     val alu_oper = Input(UInt(width.W))
//     val arg_x = Input(UInt(width.W))
//     val arg_y = Input(UInt(width.W))
//     val alu_out = Output(SInt(width.W))
// }
// class ALU(width_parameter: Int) extends Module{
//     val io = IO(new IO_Interface(width_parameter))
//     val index = log2Ceil(width_parameter)
//     val and = io.arg_x & io.arg_y
//     val or = io.arg_x | io.arg_y
//     val add = io.arg_x + io.arg_y
//     val sub = io.arg_x - io.arg_y
//     val xor = io.arg_x ^ io.arg_y
//     val sll = io.arg_x << io.arg_y(index - 1, 0)
//     val srl = io.arg_x >> io.arg_y(index - 1, 0)
//     val sra = io.arg_x.asSInt >> io.arg_y(index - 1, 0)
//     val slt = io.arg_x.asSInt < io.arg_y.asSInt
//     val sltu = io.arg_x < io.arg_y
    
//     when(io.alu_oper === "b0000".U){  // AND
//         io.alu_out := and
//     }.elsewhen(io.alu_oper === "b0001".U){  // OR
//         io.alu_out := or
//     }.elsewhen(io.alu_oper === "b0010".U){  // ADD
//         io.alu_out := add
//     }.elsewhen(io.alu_oper === "b0110".U){  // SUB
//         io.alu_out := sub
//     }.elsewhen(io.alu_oper === "b0011".U){  // XOR
//         io.alu_out := xor
//     }.elsewhen(io.alu_oper === "b0100".U){  // SLL
//         io.alu_out := sll
//     }.elsewhen(io.alu_oper === "b0101".U){  // SRL
//         io.alu_out := srl
//     }.elsewhen(io.alu_oper === "b0111".U){  // SRA
//         io.alu_out := sra
//     }.elsewhen(io.alu_oper === "b1000".U){  // SLT
//         io.alu_out := slt
//     }.elsewhen(io.alu_oper === "b1001".U){  // SLTU
//         io.alu_out := sltu
//     }.otherwise{
//         io.alu_out := 0.S
//     }
// }