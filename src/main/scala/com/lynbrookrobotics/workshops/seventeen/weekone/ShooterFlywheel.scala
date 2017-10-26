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

  // by default, the Flywheel should not run
  override def defaultController = Stream.periodic(period) {
    RevolutionsPerMinute(0)
  }

  // output `signal` to the hardware
  override def applySignal(target: Frequency): Unit = {
    // do the following for both motors:
    //    if it is going too slow, apply duty cycle of 1
    //    if it is going too fast, apply duty cycle of 0
  }

  // there are two magnets inserted into the shooter's flywheel
  // therefore, each hall effect tick corresponds to 0.5 rotations
  def aSpeed() = 0.5 / Seconds(aHallEffect.getPeriod)
  def bSpeed() = 0.5 / Seconds(bHallEffect.getPeriod)
}