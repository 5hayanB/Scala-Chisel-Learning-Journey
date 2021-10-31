package Lab6

import chisel3._
import chisel3.util._

class TwoShotTimer(start: Int) extends Module{
    val io = IO(new Bundle{
        val offTimer = Output(Bool())
        val onTimer = Output(Bool())
    })
    val timer = RegInit(0.U(3.W))
    val max = start.U
    val chkpoint = RegInit(start.U(3.W))
    var cycle = 0.U

    when((timer =/= 0.U) && (timer =/= max)){
        when(chkpoint === max){
            timer := timer + 1.U
            io.offTimer := 1.B
            io.onTimer := 0.B
        }.otherwise{
            timer := timer - 1.U
            io.offTimer := 0.B
            io.onTimer := 1.B
        }
    }.elsewhen(timer === 0.U){
        timer := timer + 1.U
        io.offTimer := 1.B
        io.onTimer := 0.B
        chkpoint := max
        cycle = cycle + 1.U
    }.otherwise{
        timer := timer - 1.U
        io.offTimer := 0.B
        io.onTimer := 1.B
        chkpoint := 0.U
    }
}