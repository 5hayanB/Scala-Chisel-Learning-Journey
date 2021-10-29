package Lab1
import chisel3._

class ParamCounter(size: Int, maxValue: Int) extends Module{
    val io = IO(new Bundle{
        val result = Output(Bool())
        })
    var result = 0.B
    // 'genCounter' with counter size 'n'
    def genCounter(n: Int, max: Int) = {
        val count = RegInit(0.U(n.W))
        when(count === (max).asUInt){
            count := 0.U
        }.otherwise{
            count := count + 1.U
            }
        count
    }
    // genCounter instantiation
    val counter1 = genCounter(size, maxValue)
    when(counter1 === maxValue.asUInt){
        result = 1.B
    }
    io.result := result
}
