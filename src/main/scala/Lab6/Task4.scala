package Lab6

import chisel3._
import chisel3.util._

class UpDownCounter(val max: Int = 10) extends Module{
    val io = IO(new Bundle{
        val out = Output(UInt(log2Ceil(max).W))
        val upDown = Input(Bool())
    })
    // Start your code here
    val count = RegInit(0.U(log2Ceil(max).W))
    when(io.upDown){
        when(count === max.U){
            count := 0.U
        }.otherwise{
            count := count + 1.U
        }
    }.otherwise{
        when(count === 0.U){
            count := max.U
        }.otherwise{
            count := count - 1.U
        }
    }
    io.out := count
    // End your code here
}