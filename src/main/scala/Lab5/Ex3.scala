package Lab5

import chisel3._
import chisel3.util._

// Class definition with function as parameter
class Operator[T <: Data](n: Int, generic: T)(op: (T, T) => T) extends Module{
    require(n > 0)  // reduce only works on non-empty Vecs

    val io = IO(new Bundle{
        val in = Input(Vec(n, generic))
        val out = Output(Vec(n, generic))
    })
    val out = io.in.reduce(op).asUInt
    
    for(i <- 0 until n){
        io.out(i) := out(i)
    }
}
