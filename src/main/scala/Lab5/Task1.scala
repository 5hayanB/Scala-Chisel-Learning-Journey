package Lab5

import chisel3._
import chisel3.util._

class Adder(width: Int) extends Module{
    require(width >= 0)

    // Your code begins from here
    val io = IO(new Bundle{
        val in0 = Input(SInt(width.W))
        val in1 = Input(SInt(width.W))
        val sum = Output(SInt(width.W))
    })

    io.sum := io.in0 + io.in1
    // Your code ends here
}