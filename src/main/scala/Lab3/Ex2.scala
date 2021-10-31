package Lab3
import chisel3._
import chisel3.util._

trait Config{
    // Word length configuration parameter
    val WLEN = 32
    // ALU OPeration control SIGnal width
    val ALU_OP_SIG_LEN = 5
}
class ALU_IO extends Bundle with Config{
    val rs1 = Input(SInt(WLEN.W))
    val rs2 = Input(SInt(WLEN.W))
    val aluOp = Input(UInt(ALU_OP_SIG_LEN.W))
    val out = Output(SInt(WLEN.W))
}
class ALU extends Module with Config{
    val io = IO(new ALU_IO)
    val op2 = io.rs2(4,0)
    io.out := 0.S
    switch(io.aluOp){
        is(0.U){  // ADD
            io.out := io.rs1 + io.rs2
        }
        is(1.U){  // SLL
            io.out := (io.rs1.asUInt << op2.asUInt).asSInt
        }
        is(2.U){  // SLT
            io.out := Mux(io.rs1 < io.rs2, 1.S, 0.S)
        }
        is(3.U){  // SLTU
            io.out := Mux(io.rs1.asUInt < io.rs2.asUInt, 1.S, 0.S)
        }
        is(4.U){  // XOR
            io.out := io.rs1 ^ io.rs2
        }
        is(5.U){  // SRL
            io.out := (io.rs1.asUInt >> op2.asUInt).asSInt
        }
        is(6.U){  // OR
            io.out := io.rs1 | io.rs2
        }
        is(7.U){  // AND
            io.out := io.rs1 & io.rs2
        }
        is(8.U){  // SUB
            io.out := io.rs1 - io.rs2
        }
        is(13.U){  // SRA
            io.out := io.rs1 >> op2
        }
    }
}