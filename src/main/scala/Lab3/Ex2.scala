package Lab3
import chisel3._
import chisel3.util._

trait Config{
    // Word length configuration parameter
    val WLEN = 32
    // ALU OPeration control SIGnal width
    val ALU_OP_SIG_LEN = 4
}
class ALU_IO extends Bundle with Config{
    val rs1 = Input(UInt(WLEN.W))
    val rs2 = Input(UInt(WLEN.W))
    val aluOp = Input(UInt(ALU_OP_SIG_LEN.W))
    val out = Output(UInt(WLEN.W))
}
class ALU extends Module with Config{
    val io = IO(new ALU_IO)
    val op2 = io.rs2(4,0)
    io.out := 0.U
    switch(io.aluOp){
        is(0.U){
            io.out := io.rs1 + io.rs2
        }
        is(1.U){
            io.out := io.rs1 << op2
        }
        is(2.U){
            io.out := Mux((io.rs1).asSInt < (io.rs2).asSInt, 0.U, 1.U)
        }
        is(3.U){
            io.out := Mux(io.rs1 < io.rs2, 0.U, 1.U)
        }
        is(4.U){
            io.out := io.rs1 ^ io.rs2
        }
        is(5.U){
            io.out := io.rs1 >> op2
        }
        is(6.U){
            io.out := io.rs1 | io.rs2
        }
        is(7.U){
            io.out := io.rs1 & io.rs2
        }
        is(8.U){
            io.out := io.rs1 - io.rs2
        }
        is(13.U){
            io.out := io.rs1 >> op2
        }
    }
}