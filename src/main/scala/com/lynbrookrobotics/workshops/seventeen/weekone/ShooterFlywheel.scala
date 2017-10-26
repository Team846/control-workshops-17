package com.lynbrookrobotics.workshops.seventeen.weekone

import com.lynbrookrobotics.potassium.Component
import com.lynbrookrobotics.potassium.streams._
import edu.wpi.first.wpilibj.{Solenoid, Spark}
import squants.electro.{ElectricPotential, Volts}
import squants.time.Milliseconds

class ShooterFlywheel extends Component[Double](Milliseconds(15)) {

  val leftMotor = new Spark(3)
  val rightMotor = new Spark(4)

  // by default, the Flywheel should not run
  override def defaultController: Stream[Double] = ???

  // output `signal` to the hardware
  override def applySignal(signal: Double): Unit = ???
}