package com.lynbrookrobotics.workshops.seventeen.weekone

import com.lynbrookrobotics.potassium.clock.Clock
import com.lynbrookrobotics.potassium.tasks.FiniteTask
import com.lynbrookrobotics.potassium.streams._
import edu.wpi.first.wpilibj.Joystick
import squants.motion.Distance
import com.lynbrookrobotics.potassium.units._
import squants.Percent
import squants.space.{Feet, Inches}

class ControlElevator(elevator: Elevator, target: Distance, threshold: Distance)
                     (implicit clock: Clock) extends FiniteTask {

  // go to the elevator's `target` position using proportional control
  // don't forget to call `finished()`
  override protected def onStart(): Unit = ???

  override protected def onEnd(): Unit = elevator.resetToDefault()
}
