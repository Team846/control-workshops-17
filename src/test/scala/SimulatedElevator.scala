import com.lynbrookrobotics.potassium.clock.Clock
import com.lynbrookrobotics.workshops.seventeen.weekone.ElevatorHardware
import com.lynbrookrobotics.potassium.streams._
import squants.space.Length

class SimulatedElevator(implicit override val clock: Clock) extends ElevatorHardware {
  // TODO: Methods must exist in ElevatorHardware
  override val position: Stream[Length] = ???
}
