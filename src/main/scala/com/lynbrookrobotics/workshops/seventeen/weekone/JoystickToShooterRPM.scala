package com.lynbrookrobotics.workshops.seventeen.weekone

import com.lynbrookrobotics.potassium.clock.Clock
import com.lynbrookrobotics.potassium.tasks.ContinuousTask
import com.lynbrookrobotics.potassium.streams._
import edu.wpi.first.wpilibj.Joystick
import squants.time.{Milliseconds, RevolutionsPerMinute}

class JoystickToShooterRPM(val joystick: Joystick, val shooterFlywheel: ShooterFlywheel)
                          (implicit val clock: Clock)
  extends ContinuousTask {

  val maxRPM = RevolutionsPerMinute(2500)

  override protected def onStart() = shooterFlywheel.setController(
    Stream.periodic(Milliseconds(10))(joystick.getThrottle * maxRPM)
  )

  // reset the Shooter to its default state
  override protected def onEnd() = shooterFlywheel.resetToDefault()
}
