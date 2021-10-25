package Lab3
import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._

class Test_ImmdValGen extends FreeSpec with ChiselScalatestTester{
    "Test" in {
        test(new ImmdValGen()){z =>
        z.io.instr.poke("hFFC00293".U)
        z.io.immd_se.expect(-4.S)}
    }
}