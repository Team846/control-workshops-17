package com.lynbrookrobotics.workshops.seventeen.weekone

import com.lynbrookrobotics.potassium.tasks.FiniteTask
import squants.motion.Distance

class PControlElevator(elevator: Elevator, target: Int, threshold: Int) extends FiniteTask {
  val current = elevator.position

  // got to the elevator's `target` position using proportional control
  // don't forget to call `finished()`
  override protected def onStart(): Unit = ???

  override protected def onEnd(): Unit = elevator.resetToDefault()
}
