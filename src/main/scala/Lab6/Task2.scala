package Lab6

import chisel3._
import chisel3.util._

class CounterWithXOR(val max: Int = 1) extends Module{
    val io = IO(new Bundle{
        val out = Output(UInt(log2Ceil(max + 1).W))
    })
    // Start coding here
    val count = RegInit(0.U(log2Ceil(max + 1).W))
    
    when((count(log2Ceil(max + 1) - 1).asUInt ^ 1.U).asBool){
        count := count + 1.U
    }.otherwise{
        count := 0.U
    }
    io.out := count
    // End your code here
}