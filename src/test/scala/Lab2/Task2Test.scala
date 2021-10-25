package Lab2
import chiseltest._
import chisel3._
import org.scalatest._
import chisel3.util._

class TestBarrelShift extends FreeSpec with ChiselScalatestTester{
    "4-Bit Barrel Shifter" in{
        test(new BarrelShift()){x =>
        x.io.in(0).poke(false.B)
        x.io.in(1).poke(false.B)
        x.io.in(2).poke(true.B)
        x.io.in(3).poke(false.B)
        x.io.shiftType.poke(true.B)
        x.io.sel(0).poke(false.B)
        x.io.sel(1).poke(true.B)
        x.io.out(0).expect(true.B)
        x.io.out(1).expect(false.B)
        x.io.out(2).expect(false.B)
        x.io.out(3).expect(false.B)}
    }
}
