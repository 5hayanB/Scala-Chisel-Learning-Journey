package Lab7

import chisel3._
import chisel3.util._
import chisel3.experimental.ChiselEnum

class ManchesterEnc extends Module{
    val io = IO(new Bundle{
        val in = Input(Bool())
        val out = Output(UInt(8.W))
    })
    // Start your code here
    val s0 :: s1 :: Nil = Enum(2)
    val state = RegInit(s0)
    val inStream = RegInit(0.U(8.W))

    switch(state){
        is(s0){
            when(io.in){
                state := s1
                inStream := (inStream << 1) | 1.U
            }.otherwise{
                inStream := (inStream << 1) | 0.U
            }
        }
        is(s1){
            when(io.in){
                state := s0
                inStream := (inStream << 1) | 1.U
            }.otherwise{
                inStream := (inStream << 1) | 0.U
            }
        }
    }
    io.out := inStream
    // End your code here
}