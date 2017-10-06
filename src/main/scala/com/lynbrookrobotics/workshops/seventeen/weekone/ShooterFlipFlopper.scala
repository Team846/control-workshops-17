package com.lynbrookrobotics.workshops.seventeen.weekone

import com.lynbrookrobotics.potassium.Component
import com.lynbrookrobotics.potassium.streams._
import com.lynbrookrobotics.workshops.seventeen.weekone.FlipOrFlop.FlipOrFlop
import edu.wpi.first.wpilibj.Solenoid
import squants.time.Milliseconds

class ShooterFlipFlopper
(/* what does this constructor need to take in? */)
(/* what does this constructor need to take in? */)
  extends Component[FlipOrFlop](Milliseconds(25)) {

  val solenoid: Solenoid = ???

  // by default, the solenoid should `FLOP`
  override def defaultController: Stream[FlipOrFlop] = ???

  // output `signal` to the hardware
  // `FLIP` opens the solenoid
  // `FLOP` closes the solenoid
  override def applySignal(signal: FlipOrFlop): Unit = ???
}

object FlipOrFlop extends Enumeration {
  type FlipOrFlop = Value
  val FLIP, FLOP = Value
}