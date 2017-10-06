package com.lynbrookrobotics.workshops.seventeen.weekone

import com.lynbrookrobotics.potassium.Component
import com.lynbrookrobotics.potassium.streams._
import edu.wpi.first.wpilibj.Solenoid
import squants.time.Milliseconds

class ShooterFlipFlopper
(/* what does this constructor need to take in? */)
(/* what does this constructor need to take in? */)
  extends Component[FlipOrFlop](Milliseconds(25)) {

  val solenoid: Solenoid = ???

  // by default, the solenoid should `FlopState`
  override def defaultController: Stream[FlipOrFlop] = ???

  // output `signal` to the hardware
  // `FlipState` opens the solenoid
  // `FlopState` closes the solenoid
  override def applySignal(signal: FlipOrFlop): Unit = ???
}

sealed trait FlipOrFlop
case object FlipState extends FlipOrFlop
case object FlopState extends FlipOrFlop