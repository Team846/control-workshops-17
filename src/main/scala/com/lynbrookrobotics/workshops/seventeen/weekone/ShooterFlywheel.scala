package com.lynbrookrobotics.workshops.seventeen.weekone

import com.lynbrookrobotics.potassium.Component
import com.lynbrookrobotics.potassium.streams._
import edu.wpi.first.wpilibj.{Solenoid, Spark}
import squants.electro.{ElectricPotential, Volts}
import squants.time.Milliseconds

class ShooterFlywheel(/* what should this constructor take in? */)
  extends Component[(Double, Double)](Milliseconds(15)) {

  val aMotor = new Spark(3)
  val bMotor = new Spark(4)

  // by default, the Flywheel should not run
  override def defaultController: Stream[(Double, Double)] = ???

  // output
  // `signal` `_1` to `aMotor`
  // `signal` `_2` to `bMotor`
  override def applySignal(signal: (Double, Double)): Unit = ???
}