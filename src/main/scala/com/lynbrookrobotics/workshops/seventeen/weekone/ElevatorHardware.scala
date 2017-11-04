package com.lynbrookrobotics.workshops.seventeen.weekone

import com.ctre.CANTalon
import edu.wpi.first.wpilibj.AnalogInput
import squants.space.{Feet, Inches}

class ElevatorHardware {
  val safeRange = Inches(6) to Feet(2)

  val esc1 = new CANTalon(5)
  val esc2 = new CANTalon(7)


  val pot = new AnalogInput(3)

  // TODO: add member position of type Stream[Length]

  esc1.setInverted(true)
  esc2.setInverted(true)
}
