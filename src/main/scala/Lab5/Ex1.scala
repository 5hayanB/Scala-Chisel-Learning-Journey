package Lab5
import chisel3._
import chisel3.util._
//import chisel3.iotesters.{Driver, PeekPokeTester}

class IOInterface(width: Int) extends Bundle{
    val aluOper = Input(UInt(width.W))
    val argx = Input(SInt(width.W))
    val argy = Input(SInt(width.W))
    val aluOut = Output(SInt(width.W))
}
class ALU(width: Int) extends Module{
    val io = IO(new IOInterface(width))
    val index = log2Ceil(width)
    val and = io.argx & io.argy
    val or = io.argx | io.argy
    val add = io.argx + io.argy
    val sub = io.argx - io.argy
    val xor = io.argx ^ io.argy
    val sll = io.argx.asUInt << io.argy(index - 1, 0).asUInt
    val srl = io.argx.asUInt >> io.argy(index - 1, 0).asUInt
    val sra = io.argx >> io.argy(index - 1, 0)
    val slt = Mux(io.argx < io.argy, 1.S, 0.S)
    val sltu = Mux(io.argx.asUInt < io.argy.asUInt, 1.S, 0.S)
    
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
        io.aluOut := sll.asSInt
    }.elsewhen(io.aluOper === "b0101".U){  // SRL
        io.aluOut := srl.asSInt
    }.elsewhen(io.aluOper === "b0111".U){  // SRA
        io.aluOut := sra
    }.elsewhen(io.aluOper === "b1000".U){  // SLT
        io.aluOut := slt
    }.elsewhen(io.aluOper === "b1001".U){  // SLTU
        io.aluOut := sltu
    }.otherwise{
        io.aluOut := 0.S
    }
}