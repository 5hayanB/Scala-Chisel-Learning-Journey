package Lab6

import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest._
import scala.util.Random

class TestUpDownCounter extends FreeSpec with ChiselScalatestTester{
    "Lab 6 Up Down Counter" in{
        test(new UpDownCounter()){z =>
        for(i <- 1 to 100){
            val upDown = Random.nextBoolean()

            z.io.upDown.poke(upDown.B)
            z.clock.step(1)
        }}
    }
}