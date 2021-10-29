package Lab5

import chisel3._
import chisel3.util._

class ITCeMUXIO[T <: Data](data: T) extends Bundle{
    val in1 = Input(data)
    val in2 = Input(data)
    val sel = Input(Bool())
    val out = Output(data)
}
class ITCeMUX[T <: Data](data: T) extends Module{
    val io = IO(new ITCeMUXIO(data))

    io.out := Mux(io.sel, io.in2, io.in1)
}