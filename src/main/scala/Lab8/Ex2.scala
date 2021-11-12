package Lab8

import chisel3._
import chisel3.util._

class BankedMemIO extends Bundle{
    val rAddr = Input(UInt(6.W))
    val wAddr = Input(UInt(6.W))
    val wEn = Input(Bool())
    val wData = Input(UInt(32.W))
    val out = Output(UInt(32.W))
}
class BankedMem extends Module{
    val io = IO(new BankedMemIO())
    val mem1 = SyncReadMem(32, UInt(32.W))
    val mem2 = SyncReadMem(32, UInt(32.W))
    val wDataReg = RegNext(io.wData)
    val forwardEn = RegNext(io.wEn && (io.rAddr === io.wAddr))
    var memData = 0.U

    when(io.rAddr(5)){
        memData = mem2.read(io.rAddr(4, 0))
    }.otherwise{
        memData = mem1.read(io.rAddr(4, 0))
    }
    when(io.wEn){
        when(io.wAddr(5)){
            mem2.write(io.wAddr(4, 0), io.wData)
        }.otherwise{
            mem1.write(io.wAddr(4, 0), io.wData)
        }
    }
    io.out := Mux(forwardEn, wDataReg, memData)
}