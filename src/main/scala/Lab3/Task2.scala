package Lab3
import chisel3._
import chisel3.util._

class LM_IO_Interface_ImmdValGen extends Bundle{
    val instr = Input(UInt(32.W))
    val immd_se = Output(SInt(32.W))
}
class ImmdValGen extends Module{
    val io = IO(new LM_IO_Interface_ImmdValGen)
    // Start coding here
    val opcode = io.instr(6,0)
    val immI = (io.instr(31, 20)).asSInt
    val immS = (Cat(io.instr(31, 25), io.instr(11, 7))).asSInt
    val immSB = (Cat(io.instr(31), io.instr(7), io.instr(30, 25), io.instr(11, 8), "b0".U)).asSInt
    val immU = (Cat(io.instr(31, 20), Fill(20, "b0".U))).asSInt
    val immUJ = (Cat(io.instr(31), io.instr(19, 12), io.instr(20), io.instr(30, 21), "b0".U)).asSInt
    
    when(opcode === 3.U || opcode === 15.U || opcode === 19.U || opcode === 27.U || opcode === 103.U || opcode === 115.U){
        io.immd_se := immI
    }.elsewhen(opcode === 35.U){
        io.immd_se := immS
    }.elsewhen(opcode === 99.U){
        io.immd_se := immSB
    }.elsewhen(opcode === 55.U || opcode === 23.U){
        io.immd_se := immU
    }.elsewhen(opcode === 111.U){
        io.immd_se := immUJ
    }.otherwise{
        io.immd_se := 0.S
    }
    //End your code here
    //Well, you can actually write class too, so technically you have no limit
}