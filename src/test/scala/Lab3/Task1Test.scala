package Lab3
import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest._

class TestBranchControl extends FreeSpec with ChiselScalatestTester{
    "Branch Control" in{
        test(new BranchControl()){a =>
        a.io.fnct3.poke(1.U)
        a.io.branch.poke(true.B)
        a.io.arg_x.poke(4.U)
        a.io.arg_y.poke(5.U)
        a.io.br_taken.expect(true.B)
        }
    }
}