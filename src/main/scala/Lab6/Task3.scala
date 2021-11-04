package Lab6

import chisel3._
import chisel3.util._
class ShiftRegWithParallelLoad(val len: Int = 3) extends Module{
    val io = IO(new Bundle{
        val out =  Vec(len, Output(Bool()))
        val loadIn = Vec(len, Input(Bool()))
        val in = Input(Bool())
        val load = Input(Bool())
    })
    // Start coding here
    val mux0 = Mux(io.load, io.loadIn(0), io.in)
    val mux1 = Mux(io.load, io.loadIn(1), mux0)
    val mux2 = Mux(io.load, io.loadIn(2), mux1)

    io.out(0) := RegNext(mux0)
    io.out(1) := RegNext(mux1)
    io.out(2) := RegNext(mux2)
    // End your code here. Well you can actually create classes too. So technically you have no limit.
}