package com.lynbrookrobotics.workshops.seventeen.weekone

import com.lynbrookrobotics.potassium.Signal
import com.lynbrookrobotics.potassium.clock.Clock
import com.lynbrookrobotics.potassium.events.{ContinuousEvent, ImpulseEvent, ImpulseEventSource}
import com.lynbrookrobotics.potassium.frc.WPIClock
import com.lynbrookrobotics.potassium.streams._
import com.lynbrookrobotics.potassium.tasks.ContinuousTask
import edu.wpi.first.wpilibj.Joystick.ButtonType
import edu.wpi.first.wpilibj.hal.HAL
import edu.wpi.first.wpilibj.{Compressor, Joystick, RobotBase, Solenoid}

class FunkyBot extends RobotBase {
  override def startCompetition() = {
    val eventPollingSource = new ImpulseEventSource
    implicit val impulseEvent: ImpulseEvent = eventPollingSource.event
    implicit val clock: Clock = WPIClock
    val joystick = new Joystick(/*port =*/ 1)
    val flywheel = new ShooterFlywheel

    Signal(joystick.getButton(ButtonType.kTrigger))
      .filter(identity)
      .foreach(new JoystickToShooterRPM(
        joystick, flywheel
      ))

    HAL.observeUserProgramStarting()
    while (true) {
      m_ds.waitForData()
      eventPollingSource.fire()
    }
  }
}
