package Lab3
import chisel3._
import chisel3.util._

class LM_IO_Interface_Decoder_with_Valid extends Bundle{
    val in = Input(UInt(2.W))
    val out = Valid(Output(UInt(4.W)))
}
class Decoder_with_Valid extends Module{
    val io = IO(new LM_IO_Interface_Decoder_with_Valid)

    // Start coding here
    io.out.valid := false.B
    io.out.bits := 0.U
    when(io.in > 0.U){
        switch(io.in){
            is(0.U){
                io.out.valid := true.B
                io.out.bits := 1.U
            }
            is(1.U){
                io.out.valid := true.B
                io.out.bits := 2.U
            }
            is(2.U){
                io.out.valid := true.B
                io.out.bits := 4.U
            }
            is(3.U){
                io.out.valid := true.B
                io.out.bits := 8.U
            }
        }
    }
    // End coding here
}