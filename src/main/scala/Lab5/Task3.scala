package Lab5

import chisel3._
import chisel3.util._

// class ITCeMUXIO[T <: Data](datatype: T) extends Bundle{
//     val in1 = Input(datatype.cloneType)
//     val in2 = Input(datatype.cloneType)
//     val sel = Input(Bool())
//     val out = Output(datatype.cloneType)
// }
// class ITCeMUX[T <: Data](datatype: T) extends Module{
//     val io = IO(new ITCeMUXIO(datatype))

//     io.out := Mux(io.sel, io.in2.asSInt, io.in1.asSInt)
// }

// Gives error: asSInt is not a member of parameter T