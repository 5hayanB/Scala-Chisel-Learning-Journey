package Lab8

import chisel3._
import chiseltest._
import org.scalatest._

class TestBankedMem extends FreeSpec with ChiselScalatestTester{
    "2-Banked Memory" in{
        test(new BankedMem()){a =>
        a.io.rAddr.poke("b000100".U)
        a.io.wAddr.poke("b000100".U)
        a.io.wEn.poke(1.B)
        a.io.wData.poke(7.U)
        a.clock.step(50)
        a.io.out.expect(7.U)
        }
    }
}