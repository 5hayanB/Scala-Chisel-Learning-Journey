package Lab1
import chisel3._

class ResetCounter extends Module{
    val io = IO(new Bundle{
        val result = Output(Bool())
    })
    val  count = RegInit(0.U(5.W))
    when(count(4.U) === 1.U){
        count := 0.U
    }.otherwise{
        count := count + 1.U
    }
    io.result := count(4.U)
}