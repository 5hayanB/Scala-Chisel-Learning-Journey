package Lab2
import org.scalatest._
import chisel3._
import chiseltest._

class TestMUX_2to1 extends FreeSpec with ChiselScalatestTester{
    "2 to 1 MUX with Comb. Circuits" in{
        test(new MUX_2to1()){x =>
        x.io.in_A.poke(5.U)
        x.io.in_B.poke(13.U)
        x.io.select.poke(true.B)
        x.clock.step(0)
        x.io.out.expect(13.U)}
    }
}