package Lab6

import chisel3._
import chisel3.util._

class MyQueue extends Module{
    // Your code begins here
    val io = IO(new Bundle{
        val in = Flipped(Decoupled(UInt(8.W)))
        val out = Decoupled(UInt(8.W))
    })
    val queue1 = Queue(io.in, 5)
    val queue2 = Queue(queue1, 5)

    io.out <> queue2
    // Your code ends here
}

// SIMPLE QUEUE:-
// 
// class MyQueue extends Module{
//     val io = IO(new Bundle{
//         val in = Flipped(Decoupled(UInt(8.W)))  // Valid = Input, Ready = Output, Bits = Input
//         val out = Decoupled(UInt(8.W))  // Valid = Output, Ready = Input, Bits = Output
//     })
//     val queue = Queue(io.in, 5)  // Depth = 5
//     io.out <> queue
// }
