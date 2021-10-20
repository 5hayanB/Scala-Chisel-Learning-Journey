package Lab1
import chisel3._

class Counter(counterBits: UInt) extends Module{
    val io = IO (new Bundle{
        val result = Output(Bool())
        })
    val max = (1.U << counterBits) - (1.U)
    val count = RegInit((0.U(16.W)).asSInt)
    when((count).asUInt === max){
        count := (0.U).asSInt
    }.otherwise{
        count := count + (1.U).asSInt
        }
    io.result := count((15.S).asUInt)
}