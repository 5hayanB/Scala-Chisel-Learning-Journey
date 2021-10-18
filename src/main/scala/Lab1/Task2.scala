package Lab1
import chisel3._
import chisel3.util._
import java.io.File

class Counter_Up_Down(n: Int) extends Module{
    val io = IO(new Bundle{
        val data_in = Input(UInt(n.W))
        val reload = Input(Bool())
        val out = Output(Bool())
    })
    val counter = RegInit(0.U(n.W))
    val max_count = RegInit(6.U(n.W))
    
    // Your code
    when(counter < max_count){
        counter := counter + 1.U
    }.otherwise{
        counter := counter - 1.U
    }
    when((counter === max_count) || (counter === 0.U)){
        io.out := 1.U
    }.otherwise{
        io.out := 0.U
    }
    when(counter === max_count){
        io.reload := 1.U
    }.otherwise{
        io.reload := 0.U
    }
}