package Lab4
import chisel3._
import chisel3.util._

class Branch_Control_Interface extends Bundle{
    val fnct3 = Input(UInt(3.W))
    val branch = Input(Bool())
    val arg_x = Input(SInt(32.W))
    val arg_y = Input(SInt(32.W))
    val br_taken = Output(Bool())
}
class BranchModule extends Module{
    val io = IO(new Branch_Control_Interface)
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
                io.br_taken := Mux(io.arg_x < io.arg_y, true.B, false.B)
            }
            is(5.U){
                io.br_taken := Mux(io.arg_x >= io.arg_y, true.B, false.B)
            }
            is(6.U){
                io.br_taken := Mux(io.arg_x.asUInt < io.arg_y.asUInt, true.B, false.B)
            }
            is(7.U){
                io.br_taken := Mux(io.arg_x.asUInt >= io.arg_y.asUInt, true.B, false.B)
            }
        }
    }.otherwise{
        io.br_taken := false.B
    }
    // End your code here
    // Actually write classes too. So, technically you have no limit
}