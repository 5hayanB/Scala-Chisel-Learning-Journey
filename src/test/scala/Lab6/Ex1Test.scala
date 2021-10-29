// package Lab6

// import chisel3._
// import chiseltest._
// import org.scalatest._
// import scala.util.Random

// // HARDWIRED TEST:-
// // 
// class TestShiftReg extends FreeSpec with ChiselScalatestTester{
//     "Parallel Load Shift Register" in{
//         test(new ShiftReg()){z =>
//         z.io.in.poke()
//         z.io.out.expect()}
//         z.clock.step(10)
//     }
// }

// // AUTOMATED TEST:-
// // 
// // class TestShiftReg extends FreeSpec with ChiselScalatestTester{
// //     "Parallel Load Shift Register" in{
// //         test(new ShiftReg()){z =>
// //         for(i <- 1 to 10){
// //             val in = Random.nextBoolean()
// //             val state = 
// //             val out = 
// //         }}
// //     }
// // }