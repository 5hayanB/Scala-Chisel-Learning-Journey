package Lab3
import chisel3._
import chisel3.util._

class LM_IO_Interface_Branch_Control extends Bundle{
    val fnct3 = Input(UInt(3.W))
    val branch = Input(Bool())
    val arg_x = Input(UInt(32.W))
    val arg_y = Input(UInt(32.W))
    val br_taken = Output(Bool())
}
class BranchControl extends Module{
    val io = IO(new LM_IO_Interface_Branch_Control)
    // Start coding here
    io.br_taken := false.B
    when(io.branch === true.B){
        switch(io.fnct3){
            is(0.U){
                io.br_taken := Mux(io.arg_x === io.arg_y, true.B, false.B)
            }
            is(1.U){
                io.br_taken := Mux(io.arg_x =/= io.arg_y, true.B, false.B)
            }
            is(4.U){
                io.br_taken := Mux((io.arg_x).asSInt < (io.arg_y).asSInt, true.B, false.B)
            }
            is(5.U){
                io.br_taken := Mux((io.arg_x).asSInt >= (io.arg_y).asSInt, true.B, false.B)
            }
            is(6.U){
                io.br_taken := Mux(io.arg_x < io.arg_y, true.B, false.B)
            }
            is(7.U){
                io.br_taken := Mux(io.arg_x >= io.arg_y, true.B, false.B)
            }
        }
    }
    // End your code here
    // Actually write classes too. So, technically you have no limit
}