package Lab5

import chisel3._
import chisel3.util._

class eMUXIO[T<: Data](generic: T) extends Bundle{
    val in1 = Input(generic)
    val in2 = Input(generic)
    val sel = Input(Bool())
    val out = Output(generic)
}
class eMUX extends Module{
    val io = IO(new eMUXIO(SInt(1.W)))

    def MUX2to1[T<: Data](in1: T, in2: T, sel: Bool): T = {
        Mux(sel, in2, in1)
    }

    io.out := MUX2to1(io.in1, io.in2, io.sel)
}