package Lab1
import chisel3._
import chisel3.util._
import java.io.File

class Counter_Up_Down(n: Int,data_in: UInt) extends Module{
    val io = IO(new Bundle{
        //val data_in = Input(UInt(n.W))
        val out = Output(Bool())
    })
    val counter = RegInit(0.U(n.W))
    val max_count = RegInit(data_in)
    val chkpoint = RegInit(0.U(n.W))
    
    // Your code
    when((counter =/= 0.U) & (counter =/= max_count)){
        io.out := false.B
        when(chkpoint === 0.U){
            counter := counter + 1.U
        }.otherwise{
            counter := counter - 1.U
        }
    }.elsewhen(counter === 0.U){
        chkpoint := 0.U
        io.out := true.B
        counter := counter + 1.U
    }.otherwise{
        chkpoint := max_count
        io.out := true.B
        counter := counter - 1.U
    }
}