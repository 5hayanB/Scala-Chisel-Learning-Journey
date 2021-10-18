package Lab1
import chisel3._
import chiseltest._
import org.scalatest._

class ParamCounterTest extends FreeSpec with ChiselScalatestTester{
    "Counter with Max Parameter" in {
        test(new ParamCounter(4, 10)){x =>
        x.clock.step(30)}
    }
}