package Lab2
import chisel3._
import chisel3.util._

class BarrelShift extends Module{
    val io = IO(new Bundle{
        val in = Vec(4, Input(Bool()))
        val sel = Vec(2, Input(Bool()))
        val shiftType = Input(Bool())
        val out = Vec(4, Output(Bool()))
    })

    // Start your code here
    val select = (io.sel.asUInt)
    io.out(0) := MuxLookup(select, false.B, Array(
        (0.U) -> io.in(0),
        (1.U) -> io.in(1),
        (2.U) -> io.in(2),
        (3.U) -> io.in(3)
    ))
    io.out(1) := MuxLookup(select, false.B, Array(
        (0.U) -> io.in(1),
        (1.U) -> io.in(2),
        (2.U) -> io.in(3),
        (3.U) -> Mux(io.shiftType, 0.U, io.in(0))
    ))
    io.out(2) := MuxLookup(select, false.B, Array(
        (0.U) -> io.in(2),
        (1.U) -> io.in(3),
        (2.U) -> Mux(io.shiftType, 0.U, io.in(0)),
        (3.U) -> Mux(io.shiftType, 0.U, io.in(1))
    ))
    io.out(3) := MuxLookup(select, false.B, Array(
        (0.U) -> io.in(3),
        (1.U) -> Mux(io.shiftType, 0.U, io.in(0)),
        (2.U) -> Mux(io.shiftType, 0.U, io.in(1)),
        (3.U) -> Mux(io.shiftType, 0.U, io.in(2))
    ))
    // End your code here
}