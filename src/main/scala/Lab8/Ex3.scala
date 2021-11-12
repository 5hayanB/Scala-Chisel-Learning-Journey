// package Lab8

// import chisel3._
// import chisel3.util._
// import chisel3.util.experimental.loadMemoryFromFile
// import scala.io.Source

// class InstMem(file: String) extends Module{
//     val io = IO(new Bundle{
//         val addr = Input(UInt(32.W))
//         val inst = Output(UInt(32.W))
//     })
//     val imem = Mem(32, UInt(32.W))

//     loadMemoryFromFile(imem, file)
//     io.inst := imem(io.addr / 4.U)
// }