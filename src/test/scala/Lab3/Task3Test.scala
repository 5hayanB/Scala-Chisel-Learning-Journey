package Lab3
import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest._

class Test_Decoder_with_Valid extends FreeSpec with ChiselScalatestTester{
    "Decoder with Valid" in{
        test(new Decoder_with_Valid()){z =>
        z.io.in.poke(2.U)
        z.io.out.bits.expect(4.U)
        z.io.out.valid.expect(true.B)}
    }
}