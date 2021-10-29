package Lab5

import chisel3._
import chisel3.util._
// import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}

// Your code for TransactionIn class
class TransactionIn[T <: Data](datatype: T) extends Bundle{}