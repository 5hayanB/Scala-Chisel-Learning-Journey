package Lab8

import chisel3._
import chisel3.util._

class MemAssignment extends Module{
    val io = IO(new Bundle{
        val memOut = Vec(4, Output(UInt(32.W)))
        val requester = Vec(4, Flipped(Decoupled(Input(UInt(32.W)))))
    })
    // Start your code from here
    val queue1 = Queue(io.requester(0), 32)
    val queue2 = Queue(io.requester(1), 32)
    val queue3 = Queue(io.requester(2), 32)
    val queue4 = Queue(io.requester(3), 32)
    val arb = Module(new RRArbiter(UInt(32.W), 4))
    val memBank = Mem(4, UInt(32.W))

    arb.io.out.ready := 1.B

    // Connecting the inputs
    arb.io.in(0) <> queue1
    arb.io.in(1) <> queue2
    arb.io.in(2) <> queue3
    arb.io.in(3) <> queue4

    // Connecting the arbiter and the memory bank
    when(queue1.ready){
        memBank.write(0.U, arb.io.out.bits)
    }.elsewhen(queue2.ready){
        memBank.write(1.U, arb.io.out.bits)
    }.elsewhen(queue3.ready){
        memBank.write(2.U, arb.io.out.bits)
    }.elsewhen(queue4.ready){
        memBank.write(3.U, arb.io.out.bits)
    }
    // Connecting the memory banks with output
    io.memOut(0) := memBank.read(0.U)
    io.memOut(1) := memBank.read(1.U)
    io.memOut(2) := memBank.read(2.U)
    io.memOut(3) := memBank.read(3.U)
    // End your code here
}
