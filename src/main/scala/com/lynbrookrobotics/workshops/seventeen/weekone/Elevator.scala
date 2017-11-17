package com.lynbrookrobotics.workshops.seventeen.weekone

import com.lynbrookrobotics.potassium.clock.Clock
import com.lynbrookrobotics.potassium.{Component, streams}
import com.lynbrookrobotics.potassium.streams._
import squants.{Dimensionless, Percent}
import squants.space.{Feet, Inches}
import squants.time.Milliseconds

class Elevator(hardware: ElevatorHardware)
              (implicit val clock: Clock) extends Component[Dimensionless] {

  private val cancelSafety = hardware.position
    .map(!hardware.safeRange.contains(_))
    .foreach { it =>
      hardware.esc1.enableBrakeMode(it)
      hardware.esc2.enableBrakeMode(it)
    }

  override def defaultController = Stream.periodic(Milliseconds(15))(Percent(0))

  override def applySignal(signal: Dimensionless): Unit = {
    val current = hardware.getPosition
    if ((current > hardware.safeRange.upper && signal > Percent(0)) ||
      (current < hardware.safeRange.lower && signal < Percent(0))) {
      println("Safety Triggered!")
      hardware.esc1.set(0)
      hardware.esc2.set(0)
    } else {
      if (signal.abs < Percent(30)) {
        hardware.esc1.set(signal.toPercent)
        hardware.esc2.set(signal.toPercent)
      } else {
        hardware.esc1.set(0.3 * signal.toPercent.signum)
        hardware.esc2.set(0.3 * signal.toPercent.signum)
      }
    }
  }
}
