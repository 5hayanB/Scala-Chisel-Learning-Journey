// package Lab5

// import chisel3._
// import chiseltest._
// import chisel3.util._
// import org.scalatest._
// import scala.util.Random

// // class TestOperator extends FreeSpec with ChiselScalatestTester{
// //     "Operator Test" in{
// //         test(new Operator(2, UInt(4.W))(_+_)){z =>
// //         z.io.in(0).poke(1.U)
// //         z.io.in(1).poke(1.U)
// //         // z.io.out.expect(2.U)
// //         }
// //     }
// // }

// class TestOperator extends FreeSpec with ChiselScalatestTester{
//     "Operator Test" in{
//         test(new Operator(4, UInt(4.W))(_ + _)){z =>
//         z.io.in(0).poke(0.U)
//         z.io.in(1).poke(1.U)
//         z.io.in(2).poke(0.U)
//         z.io.in(3).poke(1.U)
//         z.io.out.expect(2.U)
//         }
//     }
// }