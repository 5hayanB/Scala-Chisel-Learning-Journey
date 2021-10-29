// package Lab5

// import chisel3._
// import chisel3.util._

// // class Operator[T <: Data](n :Int, generic: T)(op: (T,T) => T)extends Module{
// //     val io = IO(new Bundle{
// //         val in = Input(Vec(n, UInt(4.W)))
// //         val out = Output(Vec(n, UInt(4.W)))
// //     })

// //     for (i <- 0 until n){
// //         io.out(i) := io.in.reduce(_+_)
// //         // io.out(1) := io.in.reduce(_+_)
// //     }
// // }

// class OperatorIO[T <: Data](n: Int, generic: T) extends Bundle{
//     val in = Input(Vec(n, generic))
//     val out = Output(Vec(n, generic))
// }
// class Operator[T <: Data](n: Int, generic: T)(op: (T,T) => T) extends Module{
//     require(n > 0)
//     val io = IO(new OperatorIO(n, generic))
   
//    // val addedOut = Vec(n, generic)// io.in.reduce((x, y) => x + y))

//     for(i <- 0 to n){
//         io.out(i) := io.in.reduce(_ + _)
//     }
// }