package Lab6

import chisel3._
import chisel3.util._

class ShiftReg(val init: Int = 15) extends Module{
    val io = IO(new Bundle{
        val out = Output(Bool())
    })
    val state = RegInit(init.U(4.W))  // Register initializaion

    // Serial data out starting from LSB
    val nextState = state >> 1
    io.out := state(0)
    state := nextState
}