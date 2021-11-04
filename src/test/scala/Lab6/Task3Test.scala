package Lab6

import chisel3._
import chisel3.util._
import org.scalatest._
import chiseltest._
import scala.util.Random

// HARDWIRED TEST:-
// 
// class TestShiftRegWithParallelLoad extends FreeSpec with ChiselScalatestTester{
//     "Task 3 Shift Register" in{
//         test(new ShiftRegWithParallelLoad()){z =>
//         z.io.in.poke(false.B)
//         z.io.load.poke(true.B)
//         z.io.loadIn(0).poke(true.B)
//         z.io.loadIn(1).poke(true.B)
//         z.io.loadIn(2).poke(true.B)
//         z.clock.step(1)
//         z.io.out(0).expect(true.B)
//         z.io.out(1).expect(true.B)
//         z.io.out(2).expect(true.B)}
//     }
// }

// AUTOMATED TEST:-
// 
class TestShiftRegWithParallelLoad extends FreeSpec with ChiselScalatestTester{
    "Task 3 Shift Register" in{
        test(new ShiftRegWithParallelLoad()){z =>
        for(i <- 1 to 100){
            val load = Random.nextBoolean()
            val in = Random.nextBoolean()
            val load0 = Random.nextBoolean()
            val load1 = Random.nextBoolean()
            val load2 = Random.nextBoolean()
            val out0 = if(load == true){load0}
                        else{in}
            val out1 = if(load == true){load1}
                        else{out0}
            val out2 = if(load == true){load2}
                        else{out1}

            z.io.in.poke(in.B)
            z.io.load.poke(load.B)
            z.io.loadIn(0).poke(load0.B)
            z.io.loadIn(1).poke(load1.B)
            z.io.loadIn(2).poke(load2.B)
            z.clock.step(1)
            z.io.out(0).expect(out0.B)
            z.io.out(1).expect(out1.B)
            z.io.out(2).expect(out2.B)
        }}
    }
}