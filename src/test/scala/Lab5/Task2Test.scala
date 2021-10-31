package Lab5

import chisel3._
import chisel3.util._
import chiseltest._
import org.scalatest._
import scala.util.Random

// HARDWIRED TEST:-
// 
// class TestRouter extends FreeSpec with ChiselScalatestTester{
//     "Router Test" in{
//         test(new Router(UInt(22.W))){z =>
//         z.io.in.addr.poke(4.U)
//         z.io.in.data.poke(15.U)
//         z.io.out.addr.expect(4.U)
//         z.io.out.data.expect(15.U)}
//     }
// }

// AUTOMATED TEST:-
// 
class TestRouter extends FreeSpec with ChiselScalatestTester{
    "Router Test" in{
        test(new Router(UInt(32.W))){z =>
        for(i <- 0 until 100){
            val inAddr = (Random.nextLong() & 0x3FFL).U
            val inData = (Random.nextLong() & 0xFFFFFFFFL).U
            val outAddr = inAddr
            val outData = inData

            z.io.in.addr.poke(inAddr)
            z.io.in.data.poke(inData)
            z.io.out.addr.expect(outAddr)
            z.io.out.data.expect(outData)
        }}
    }
}