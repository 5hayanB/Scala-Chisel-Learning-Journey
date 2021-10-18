package Lab1
import org.scalatest._
import chiseltest._
import chisel3._

class ResetCounterTest extends FreeSpec with ChiselScalatestTester{
    "Reset Counter" in{
        test(new ResetCounter()){x =>
        x.clock.step(30)}
    }
}