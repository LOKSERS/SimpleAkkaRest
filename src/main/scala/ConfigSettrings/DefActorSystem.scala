package ConfigSettrings

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors

trait DefActorSystem {
  // needed to run the route
  implicit val system = ActorSystem(Behaviors.empty, "SprayExample")
  // needed for the future map/flatmap in the end and future in fetchItem and saveOrder
  implicit val executionContext = system.executionContext

}
