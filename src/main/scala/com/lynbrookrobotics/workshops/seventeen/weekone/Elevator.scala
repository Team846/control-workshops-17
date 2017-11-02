package com.lynbrookrobotics.workshops.seventeen.weekone

import com.ctre.CANTalon
import com.lynbrookrobotics.potassium.clock.Clock
import com.lynbrookrobotics.potassium.{Component, streams}
import com.lynbrookrobotics.potassium.streams._
import edu.wpi.first.wpilibj.AnalogInput
import squants.time.Milliseconds

// https://github.com/Team846/code-2015/blob/91d2449d921f8a08c90275e0f3b54ae9af6738d7/src/com/team846/frc2015/components/Elevator.java
class Elevator(implicit val clock: Clock) extends Component[Double](Milliseconds(15)) {
  val safeRange = 700 to 2800 // https://github.com/Team846/code-2015/blob/master/LRT15.txt
  val esc = new CANTalon(1234) // no port specified !?!?
  val pot = new AnalogInput(3)

  val position = Stream.periodic(period)(pot.getAverageValue) // in 2015 code, there was an IIR filter here

  override def defaultController = Stream.periodic(period)(0)

  override def applySignal(signal: Double): Unit = {
    val potVal = pot.getAverageValue
    if (!(safeRange contains potVal)) {
      println(s"UNSAFE!!! pot=$potVal")
    } else {
      esc.set(signal)
    }
  }
}
