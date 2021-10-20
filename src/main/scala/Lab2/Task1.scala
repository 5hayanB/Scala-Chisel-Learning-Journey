package Lab2
import chisel3._
import chisel3.util._

class LM_IO_Interface extends Bundle{
    val s0 = Input(Bool())
    val s1 = Input(Bool())
    val s2 = Input(Bool())
    val out = Output(UInt(32.W))
}
class MUX_5to1 extends Module{
    val io = IO(new LM_IO_Interface())

    // Start coding here
    val sel = Cat(io.s2, io.s1, io.s0)
    val in0 = 0.U
    val in1 = 8.U
    val in2 = 16.U
    val in3 = 24.U
    val in4 = 32.U

    io.out := MuxCase(false.B, Array(
        (sel === 0.U) -> in0,
        (sel === 1.U) -> in1,
        (sel === 2.U) -> in2,
        (sel === 3.U) -> in3,
        (sel >= 4.U) -> in4
    ))
    // End your code here
}