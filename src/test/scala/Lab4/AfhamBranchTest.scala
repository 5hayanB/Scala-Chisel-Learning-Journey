// package Lab4
// import chisel3._
// import chiseltest._
// import org.scalatest._
// import chisel3.util._
// import scala.util.Random

// class TestBranchModule extends FreeSpec with ChiselScalatestTester{
//     "Automated Branch Control Test" in{
//         test(new BranchModule()){a =>
//         for(i <- 0 until 10){
//             val func3Array = Array(0.U, 1.U, 4.U, 5.U, 6.U, 7.U)
//             val func3Index = Random.nextInt(6)
//             val func3 = func3Array(func3Index)
//             val br = Random.nextBoolean()
//             val in1 = 4.S
//             val in2 = 5.S
//             var out = false.B
//             if(br === true.B){
//                 switch(func3){
//                     is(0.U){
//                         out = Mux(in1 === in2, true.B, false.B)
//                     }
//                     is(1.U){
//                         out = Mux(in1 =/= in2, false.B, true.B)
//                     }
//                     is(4.U){
//                         out = Mux(in1 < in2, true.B, false.B)
//                     }
//                     is(5.U){
//                         out = Mux(in1 >= in2, true.B, false.B)
//                     }
//                     is(6.U){
//                         out = Mux(in1.asUInt < in2.asUInt, true.B, false.B)
//                     }
//                     is(7.U){
//                         out = Mux(in1.asUInt >= in2.asUInt, true.B, false.B)
//                     }
//                 }
//             }else{
//                 out = false.B
//             }
//             println(func3, br, in1, in2, out)
//             a.io.fnct3.poke(func3)
//             a.io.branch.poke(br.B)
//             a.io.arg_x.poke(in1)
//             a.io.arg_y.poke(in2)
//             a.io.br_taken.expect(out)
//         }
//         }
//     }
// }