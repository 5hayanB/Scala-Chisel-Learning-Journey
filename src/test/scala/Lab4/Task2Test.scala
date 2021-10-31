package Lab4

import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._
import scala.util.Random
import scala.collection.BitSet

class TestImmdGen extends FreeSpec with ChiselScalatestTester{
    "Immediate Generation Test" in {
        test(new ImmdGen()){z =>
        z.io.instr.poke(6292115.S)  // "h00600293"
        z.io.immd_se.expect(6.S)}
    }
}
