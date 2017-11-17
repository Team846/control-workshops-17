package com.lynbrookrobotics.workshops.seventeen.weekone

import com.lynbrookrobotics.potassium.Signal
import com.lynbrookrobotics.potassium.clock.Clock
import com.lynbrookrobotics.potassium.events.{ContinuousEvent, ImpulseEvent, ImpulseEventSource}
import com.lynbrookrobotics.potassium.frc.{WPIClock, WPIClockFailFast}
import com.lynbrookrobotics.potassium.streams._
import com.lynbrookrobotics.potassium.tasks.ContinuousTask
import edu.wpi.first.wpilibj.Joystick.ButtonType
import edu.wpi.first.wpilibj.hal.HAL
import edu.wpi.first.wpilibj.{Compressor, Joystick, RobotBase, Solenoid}
import squants.space.{Feet, Inches}
import squants.time.Milliseconds

class FunkyBot extends RobotBase {
  override def startCompetition() = {
    val eventPollingSource = new ImpulseEventSource
    implicit val impulseEvent: ImpulseEvent = eventPollingSource.event

    implicit val clock: Clock = WPIClockFailFast

    val joystick = new Joystick(1)

    val elevator = new Elevator(new ElevatorHardware)

    val triggerPressedEvent = Signal(
      joystick.getButton(ButtonType.kTrigger)
    ).filter(identity)

    triggerPressedEvent.onStart.foreach(() =>
        new ControlElevator(
          elevator,
          target = Feet(1.7),
          threshold = Inches(1)
        ).init
    )

    HAL.observeUserProgramStarting()
    while (true) {
      m_ds.waitForData()
      eventPollingSource.fire()
    }
  }
}
