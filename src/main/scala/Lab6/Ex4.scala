package Lab6

import chisel3._
import chisel3.util._

class MyQueue extends Module{
    // Your code begins here
    val io = IO(new Bundle{
        val in = Flipped(Decoupled(UInt(8.W)))
        val out = Decoupled(UInt(8.W))
    })
    val queue1 = Queue()
    // Your code ends here
}