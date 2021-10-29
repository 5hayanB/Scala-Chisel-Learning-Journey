// package Lab6

// import chisel3._
// import chisel3.util._

// class TwoShotTimerIO extends Bundle{
//     val din = Input(UInt(3.W))
//     val onTimer = Output(UInt(1.W))
//     val offTimer = Output(UInt(1.W))
// }
// class TwoShotTimer extends Module{
//     val io = IO(new TwoShotTimerIO())
//     val onTimer = RegInit(0.U(1.W))
//     val offTimer = RegInit(1.U(1.W))
//     val reload = RegInit(0.U(1.W))
//     val timerCount = RegInit(0.U(3.W))
//     val done = timerCount === 0.U
//     val next = WireInit(0.U)

//     reload := Mux(timerCount === 0.U, 1.B, 0.B)
//     when((reload & offTimer).asBool){
//         next := io.din
//         offTimer := 0.U
//         onTimer := 1.U
//     }.elsewhen((reload & onTimer).asBool){
//         next := io.din
//         offTimer := 1.U
//         onTimer := 0.U
//     }.elsewhen(!done){
//         next := timerCount - 1.U
//     }
//     io.offTimer := offTimer
//     io.onTimer := onTimer
//     timerCount := next
// }