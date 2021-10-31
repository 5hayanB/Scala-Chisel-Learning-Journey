package Lab5

import chisel3._
import chisel3.util._

// Your code for TransactionIn class
class TransactionIn[T <: Data](datatype: T) extends Bundle{
    val addr = Input(UInt(10.W))
    val data = Input(datatype.cloneType)
}
// Your code for TransactionOut class
class TransactionOut[T <: Data](datatype: T) extends Bundle{
    val addr = Output(UInt(10.W))
    val data = Output(datatype.cloneType)
}
class Router[T <: Data](gen: T) extends Module{
    // Your code begins here
    val io = IO(new Bundle{
        val in = new TransactionIn(gen)
        val out = new TransactionOut(gen)
    })

    io.out <> io.in
    // Your code ends here
}