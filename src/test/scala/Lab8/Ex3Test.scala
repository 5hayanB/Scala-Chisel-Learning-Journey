// package Lab8

// import chisel3._
// import chisel3.util._
// import chisel3.util.experimental.loadMemoryFromFile
// import scala.io.Source
// import chiseltest._
// import org.scalatest._

// class TestInstMem extends FreeSpec with ChiselScalatestTester{
//     "Instruction Memory Test" in{
//         test(new InstMem("/src/main/test/scala/Lab8/memoryFile.txt")){z =>
//         z.io.addr.poke(32.U)
//         z.clock.step(100)}
//     }
// }