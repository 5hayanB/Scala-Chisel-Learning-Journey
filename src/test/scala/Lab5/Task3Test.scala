package Lab5

import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest._
import scala.util.Random

// HARDWIRED TEST:-
//
// class TestITCeMUX extends FreeSpec with ChiselScalatestTester{
//     "Inclusive Type-Casting eMUX Test" in{
//         val data = UInt
//         val widths = 4
//         test(new ITCeMUX(data(widths.W))){z =>
//         z.io.in1.poke(4.U)
//         z.io.in2.poke(5.U)
//         z.io.sel.poke(false.B)
//         z.io.out.expect(4.U)}
//     }
// }

// AUTOMATED TEST:-
//
// class TestITCeMUX extends FreeSpec with ChiselScalatestTester{
//     "Automated Inclusive Type-Casting eMUX Test" in{
//         val data = 
//     }
// }