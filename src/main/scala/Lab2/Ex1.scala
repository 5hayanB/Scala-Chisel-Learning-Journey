package Lab2
import chisel3._
import chisel3.util._

// Mux IO interface class
class MUX_2to1_IO extends Bundle{
    val in_A = Input(UInt(32. W))
    val in_B = Input(UInt(32. W))
    val select = Input(Bool())
    val out = Output(UInt())
}
// 2 to 1 Mux implementation
class MUX_2to1 extends Module{
    val io = IO(new MUX_2to1_IO())

    // update the output
    when(io.select === 0.U){
        io.out := io.in_A
    }.otherwise{io.out := io.in_B}
}