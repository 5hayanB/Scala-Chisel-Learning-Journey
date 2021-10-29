package Lab6

import chisel3._
import chisel3.util._

class ShiftReg(val init: Int = 1) extends Module{
    val io = IO(new Bundle{
        val in = Input(Bool())
        val out = Output(UInt(4.W))
    })
    val state = RegInit(init.U(4.W))  // Register initializaion

    // Serial data in at LSB
    val nextState = (state << 1) | io.in
    state := nextState
    io.out := state
}