package Lab1
import org.scalatest._
import chiseltest._
import chisel3._

class CounterTest extends FreeSpec with ChiselScalatestTester{
    "Counter with SInt Type Count" in {
        test(new Counter(4.U)){a =>
        a.clock.step(10)
        }
    }
}