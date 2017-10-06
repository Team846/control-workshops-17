package com.lynbrookrobotics.workshops.seventeen.weekone

import com.lynbrookrobotics.potassium.streams._
import com.lynbrookrobotics.potassium.events.{ContinuousEvent, ImpulseEventSource}
import edu.wpi.first.wpilibj.hal.HAL
import edu.wpi.first.wpilibj.{Compressor, Joystick, RobotBase, Solenoid}

class FunkyBot extends RobotBase {
  override def startCompetition() = {
    val eventPollingSource = new ImpulseEventSource
    val joystick = new Joystick(/*port =*/ 1)
    val solenoid = new Solenoid(/*channel =*/ 2)
    new Compressor().enabled()

    // stream of `joystick.getButton` `kTrigger`
    val triggerButtonStream: Stream[Boolean] = ???

    // represent `triggerButtonStream` as an event
    val triggerButtonEvent: ContinuousEvent = ???

    // when `triggerButtonEvent` says that the trigger is pressed, solenoid.set(true)
    // when `triggerButtonEvent` says that the trigger is released, solenoid.set(false)

    HAL.observeUserProgramStarting()
    while (true) {
      m_ds.waitForData()
      eventPollingSource.fire()
    }
  }
}
