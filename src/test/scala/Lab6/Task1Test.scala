package Lab6

import chisel3._
import chisel3.util._
import scala.util.Random
import org.scalatest._
import chiseltest._

class NewTestCounter extends FreeSpec with ChiselScalatestTester{
    "New Minimized Counter" in{
        test(new NewCounter(13)){z =>
        z.clock.step(30)}
    }
}