package com.lynbrookrobotics.workshops.seventeen.weekone

import com.ctre.CANTalon
import com.lynbrookrobotics.potassium.clock.Clock
import com.lynbrookrobotics.potassium.streams.Stream
import edu.wpi.first.wpilibj.AnalogInput
import squants.space.{Feet, Inches}
import squants.time.Milliseconds

class ElevatorHardware(implicit val clock: Clock) {
  val safeRange = Inches(6) to Feet(2)

  val esc1 = new CANTalon(5)
  val esc2 = new CANTalon(7)


  val pot = new AnalogInput(3)

  val position = Stream.periodic(Milliseconds(15))(getPosition)

  def getPosition = Inches((pot.getAverageValue - 2865) * -0.021)

  esc1.setInverted(true)
  esc2.setInverted(true)
}
