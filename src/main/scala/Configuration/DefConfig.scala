package Configuration

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors

trait DefConfig {
  implicit val system = ActorSystem(Behaviors.empty, "my-system")
  // needed for the future flatMap/onComplete in the end
  implicit val executionContext = system.executionContext
}
