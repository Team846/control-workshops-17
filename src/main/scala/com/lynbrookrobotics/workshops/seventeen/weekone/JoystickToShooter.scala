package com.lynbrookrobotics.workshops.seventeen.weekone

import com.lynbrookrobotics.potassium.clock.Clock
import com.lynbrookrobotics.potassium.tasks.ContinuousTask
import com.lynbrookrobotics.potassium.streams._
import edu.wpi.first.wpilibj.{AnalogInput, Joystick}

class JoystickToShooter(joystick: Joystick, flywheel: Elevator)
                       (implicit clock: Clock)
  extends ContinuousTask {

  val pot = new AnalogInput(3)

  override protected def onStart(): Unit = {
    val controller = Stream.periodic(flywheel.period)(joystick.getY())
    Stream.periodic(flywheel.period)(pot.getAverageValue).foreach { it=>
      if (it < 500 || it > 2500) {
        println(s"UNSAFE!!! pot=$it")
        System.exit(1)
      }
    }
    flywheel.setController(
      controller
    )
  }

  override protected def onEnd(): Unit = flywheel.resetToDefault()
}
