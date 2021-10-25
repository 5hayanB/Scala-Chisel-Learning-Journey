package Lab2
import chisel3._
import chisel3.util._

class MUX1H_4to2 extends Module{
    val io = IO(new Bundle{
    val in0 = Input(UInt(1.W))
    val in1 = Input(UInt(1.W))
    val in2 = Input(UInt(1.W))
    val in3 = Input(UInt(1.W))
    val out0 = Output(UInt(1.W))
    val out1 = Output(UInt(1.W))
    })
    val sel = Cat(io.in3, io.in2, io.in1)
    io.out0 := Mux1H(sel(0), Seq(io.in1 | io.in3))
    io.out1 := Mux1H(sel(2, 1), Seq(io.in2, io.in3))
}
