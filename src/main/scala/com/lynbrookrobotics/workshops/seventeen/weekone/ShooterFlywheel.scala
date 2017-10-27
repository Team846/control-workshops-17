package com.lynbrookrobotics.workshops.seventeen.weekone

import com.lynbrookrobotics.potassium.Component
import com.lynbrookrobotics.potassium.clock.Clock
import com.lynbrookrobotics.potassium.streams._
import edu.wpi.first.wpilibj.{Counter, Solenoid, Spark}
import squants.electro.{ElectricPotential, Volts}
import squants.motion.{AngularVelocity, RadiansPerSecond}
import squants.time.{Frequency, Milliseconds, RevolutionsPerMinute, Seconds}

class ShooterFlywheel(implicit clock: Clock) extends Component[Frequency](Milliseconds(15)) {

  val aMotor = new Spark(3)
  val bMotor = new Spark(4)

  // What is `Hall Effect`? https://en.wikipedia.org/wiki/Hall_effect_sensor
  // What is `Counter`? https://goo.gl/hLuy7t
  val aHallEffect = new Counter(0)
  val bHallEffect = new Counter(1)

  override def defaultController = Stream.periodic(period) {
    RevolutionsPerMinute(0) // by default, the Flywheel should not run
  }

  // output `signal` to the hardware
  override def applySignal(target: Frequency): Unit = {
    // implement bang-bang control for each motor
    // use the *Speed() methods to get sensor data
  }

  def aSpeed() = 0.5 / Seconds(aHallEffect.getPeriod) // there are two magnets inserted into the shooter's flywheel
  def bSpeed() = 0.5 / Seconds(bHallEffect.getPeriod) // therefore, each hall effect tick corresponds to 0.5 rotations
}