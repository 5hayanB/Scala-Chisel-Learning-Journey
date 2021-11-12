// package Lab8

// import chisel3._
// import chisel3.util._

// class MemAssignment extends Module{
//     val io = IO(new Bundle{
//         val memOut = Vec(4, Output(UInt(32.W)))
//         val requester = Vec(4, Flipped(Decoupled(Input(UInt(32.W)))))
//     })
//     // Start your code from here
//     val queue1 = Queue(io.requester(0), 32)
//     val queue2 = Queue(io.requester(1), 32)
//     val queue3 = Queue(io.requester(2), 32)
//     val queue4 = Queue(io.requester(3), 32)
//     val arb = Module(new RRArbiter(UInt(32.W), 4))
//     val memBank = Mem(4, UInt(32.W))

//     // Connecting the inputs
//     arb.io.in(0) <> queue1
//     arb.io.in(1) <> queue2
//     arb.io.in(2) <> queue3
//     arb.io.in(3) <> queue4

//     // Connecting the arbiter and the memory bank
//     when(io.requester(0).ready){
//         memBank(0) <> arb.io.in(0)
//     }
    
//     memBank(1) <> arb.io.in(1)
//     memBank(2) <> arb.io.in(2)
//     memBank(3) <> arb.io.in(3)

//     // Connecting the memory banks with output
//     io.memOut(0) <> memBank(0)
//     io.memOut(1) <> memBank(1)
//     io.memOut(2) <> memBank(2)
//     io.memOut(3) <> memBank(3)
//     // End your code here
// }
