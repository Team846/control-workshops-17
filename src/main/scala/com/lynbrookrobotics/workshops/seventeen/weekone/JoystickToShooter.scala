package com.lynbrookrobotics.workshops.seventeen.weekone

import com.lynbrookrobotics.potassium.tasks.ContinuousTask

class JoystickToShooter(/* what should this constructor take in? */) extends ContinuousTask {

  // map Joystick `throttle` values to Shooter speeds
  override protected def onStart(): Unit = ???

  // reset the Shooter to its original state
  override protected def onEnd(): Unit = ???
}
