package com.lynbrookrobotics.workshops.seventeen.weekone

import com.lynbrookrobotics.potassium.Component
import com.lynbrookrobotics.potassium.streams._
import edu.wpi.first.wpilibj.{Solenoid, Spark}
import squants.electro.{ElectricPotential, Volts}
import squants.time.Milliseconds

class Elevator(/* what should this constructor take in? */)
  extends Component[Double](Milliseconds(15)) {

  val motorController = ??? // CANTalon on port 1234

  override def defaultController: Stream[Double] = ??? // Do not move
  override def applySignal(signal: Double): Unit = ???
}