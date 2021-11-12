package Lab7

import chisel3._
import chisel3.util._
import chisel3.experimental.ChiselEnum
import chiseltest._
import org.scalatest._
import scala.util.Random

class TestManchesterEnc extends FreeSpec with ChiselScalatestTester{
    "Manchester Encoding" in {
        test(new ManchesterEnc()){a =>
        for(i <- 0 until 100){
            val in = Random.nextBoolean()

            a.io.in.poke(in.B)
            a.clock.step(1)
        }}
    }
}