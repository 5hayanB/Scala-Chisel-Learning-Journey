package Lab4
import chisel3._
import chiseltest._
import org.scalatest._
import chisel3.util._
import scala.util.Random

class TestBranchModule extends FreeSpec with ChiselScalatestTester{
    "Automated Branch Control Test" in{
        test(new BranchModule()){a =>
        for(i <- 0 until 10){
            val func3Array = Array(0.U, 1.U, 4.U, 5.U, 6.U, 7.U)
            val func3Index = Random.nextInt(6)
            val func3 = func3Array(func3Index)
            val br = Random.nextBoolean()
            val in1 = Random.nextInt()
            val in2 = Random.nextInt()
            if(br == true){
                val out = func3Index match{
                    case 0 => if(in1 == in2){true.B}
                                else{false.B}
                    case 1 => if(in1 != in2){true.B}
                                else{false.B}
                    case 2 => if(in1 < in2){true.B}
                                else{false.B}
                    case 3 => if(in1 >= in2){true.B}
                                else{false.B}
                    case 4 => if(in1.asUInt < in2.asUInt){true.B}
                                else{false.B}
                    case 5 => if(in1.asUInt >= in2.asUInt){true.B}
                                else{false.B}
                }
            }else{
                val out = false.B
            }
            a.io.fnct3.poke(func3)
            a.io.branch.poke(br.B)
            a.io.arg_x.poke(in1.S)
            a.io.arg_y.poke(in2.S)
            a.io.br_taken.expect(out)
        }
        }
    }
}