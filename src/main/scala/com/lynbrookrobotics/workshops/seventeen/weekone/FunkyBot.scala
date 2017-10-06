package com.lynbrookrobotics.workshops.seventeen.weekone

import com.lynbrookrobotics.potassium.clock.Clock
import com.lynbrookrobotics.potassium.events.{ContinuousEvent, ImpulseEvent, ImpulseEventSource}
import com.lynbrookrobotics.potassium.frc.WPIClock
import com.lynbrookrobotics.potassium.streams._
import com.lynbrookrobotics.potassium.tasks.ContinuousTask
import com.lynbrookrobotics.workshops.ShooterFlipFlopper
import edu.wpi.first.wpilibj.hal.HAL
import edu.wpi.first.wpilibj.{Compressor, Joystick, RobotBase, Solenoid}

class FunkyBot extends RobotBase {
  override def startCompetition() = {
    val eventPollingSource = new ImpulseEventSource
    implicit val impulseEvent: ImpulseEvent = eventPollingSource.event
    implicit val clock: Clock = WPIClock
    val joystick = new Joystick(/*port =*/ 1)
    val flipFlopper = new ShooterFlipFlopper
    new Compressor().enabled()

    // stream of `joystick.getButton` `kTrigger`
    val triggerButtonStream: Stream[Boolean] = ???

    // represent `triggerButtonStream` as an event
    val triggerButtonEvent: ContinuousEvent = ???

    // first, `Flip` for 3 seconds
    // then `WaitTask` for 3 seconds
    // then `Flip` until trigger release
    val flipFlop: ContinuousTask = ???

    // on `triggerButtonEvent`, `flipFlop`

    HAL.observeUserProgramStarting()
    while (true) {
      m_ds.waitForData()
      eventPollingSource.fire()
    }
  }
}
