package Lab8

import chisel3._

class UnmaskedMem extends Module{
    val width: Int = 8
    val io = IO(new Bundle{
        val enable = Input(Bool())
        val write = Input(Bool())
        val addr = Input(UInt(10.W))
        val mask = Input(Vec(4, Bool()))
        val dataIn = Input(Vec(4, UInt(width.W)))
        val dataOut = Output(Vec(4, UInt(width.W)))
    })
    val mem = SyncReadMem(1024, Vec(4, UInt(width.W)))
    val dataInReg = Reg(Vec(4, UInt(width.W)))

    when(io.mask(0)){
        dataInReg(0) := io.dataIn(0)
    }.otherwise{
        dataInReg(0) := 0.U
    }
    when(io.mask(1)){
        dataInReg(1) := io.dataIn(1)
    }.otherwise{
        dataInReg(1) := 0.U
    }
    when(io.mask(2)){
        dataInReg(2) := io.dataIn(2)
    }.otherwise{
        dataInReg(2) := 0.U
    }
    when(io.mask(3)){
        dataInReg(3) := io.dataIn(3)
    }.otherwise{
        dataInReg(3) := 0.U
    }
    
    mem.write(io.addr, dataInReg)
    io.dataOut := mem.read(io.addr, io.enable)
}