package Lab5

import chiseltest._
import chisel3._
import chisel3.util._
import org.scalatest._
import scala.util.Random

// HARDWIRED TEST:-
//
// class TesteMUX extends FreeSpec with ChiselScalatestTester{
//     "Type Parameterized MUX using Bundles" in{
//         test(new eMUX()){a =>
//         a.io.in1.poke(1.B)
//         a.io.in2.poke(0.B)
//         a.io.sel.poke(1.B)
//         a.io.out.expect(0.B)
//         }
//     }
// }

// AUTOMATED TEST:-
//
class TesteMUX extends FreeSpec with ChiselScalatestTester{
    "Type Parameterized MUX using Bundles" in{
        test(new eMUX()){a =>
        for(i <- 0 until 100){
            val in1 = Random.nextBoolean()
            val in2 = Random.nextBoolean()
            val sel = Random.nextBoolean()
            val out = if(sel == true){in2}
                        else{in1}
        
        a.io.in1.poke(in1.B)
        a.io.in2.poke(in2.B)
        a.io.sel.poke(sel.B)
        a.io.out.expect(out.B)}}
    }
}