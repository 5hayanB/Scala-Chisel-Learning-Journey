package Lab5

import chisel3._
import chisel3.util._

class IOInterface(width: Int) extends Bundle{
    val aluOper = Input(UInt(width.W))
    val argx = Input(UInt(width.W))
    val argy = Input(UInt(width.W))
    val aluOut = Output(UInt(width.W))
}
class ALU(width: Int) extends Module{
    val io = IO(new IOInterface(width))
    val index = log2Ceil(width)
    val and = io.argx & io.argy
    val or = io.argx | io.argy
    val add = io.argx + io.argy
    val sub = io.argx - io.argy
    val xor = io.argx ^ io.argy
    val sll = io.argx << io.argy(index - 1, 0)
    val srl = io.argx >> io.argy(index - 1, 0)
    val sra = io.argx.asSInt >> io.argy(index - 1, 0)
    val slt = Mux(io.argx.asSInt < io.argy.asSInt, 1.U, 0.U)
    val sltu = Mux(io.argx < io.argy, 1.U, 0.U)
    
    when(io.aluOper === "b0000".U){  // AND
        io.aluOut := and
    }.elsewhen(io.aluOper === "b0001".U){  // OR
        io.aluOut := or
    }.elsewhen(io.aluOper === "b0010".U){  // ADD
        io.aluOut := add
    }.elsewhen(io.aluOper === "b0110".U){  // SUB
        io.aluOut := sub
    }.elsewhen(io.aluOper === "b0011".U){  // XOR
        io.aluOut := xor
    }.elsewhen(io.aluOper === "b0100".U){  // SLL
        io.aluOut := sll
    }.elsewhen(io.aluOper === "b0101".U){  // SRL
        io.aluOut := srl
    }.elsewhen(io.aluOper === "b0111".U){  // SRA
        io.aluOut := sra.asUInt
    }.elsewhen(io.aluOper === "b1000".U){  // SLT
        io.aluOut := slt
    }.elsewhen(io.aluOper === "b1001".U){  // SLTU
        io.aluOut := sltu
    }.otherwise{
        io.aluOut := 0.U
    }
}