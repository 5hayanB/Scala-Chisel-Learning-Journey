package Lab8

import chisel3._
import chiseltest._
import org.scalatest._

class TestUnmaskedMem extends FreeSpec with ChiselScalatestTester{
    "Unmasked Memory" in{
        test(new UnmaskedMem()){z =>
        z.io.enable.poke(1.B)
        z.io.write.poke(1.B)
        z.io.addr.poke(4.U)

        z.io.mask(0).poke(1.B)
        z.io.mask(1).poke(0.B)
        z.io.mask(2).poke(0.B)
        z.io.mask(3).poke(1.B)
        
        z.io.dataIn(0).poke(7.U)
        z.io.dataIn(1).poke(2.U)
        z.io.dataIn(2).poke(5.U)
        z.io.dataIn(3).poke(3.U)
        z.clock.step(100)
        // z.io.dataOut.expect()
        }
    }
}