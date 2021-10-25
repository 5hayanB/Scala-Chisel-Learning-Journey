package Lab3
import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest._

class TestALU extends FreeSpec with ChiselScalatestTester{
    "Exercise 2 ALU" in{
        test(new ALU()){x =>
        x.io.rs1.poke(2.U)
        x.io.rs2.poke(2.U)
        x.io.aluOp.poke(1.U)
        x.io.out.expect(8.U)}
    }
}