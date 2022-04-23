import ConfigSettrings.{DefActorSystem, DefDBLayer}
import akka.http.scaladsl.Http


object Main extends App with DefActorSystem with DefDBLayer{

  val bindingFuture = Http().newServerAt("localhost", 8080).bind(Routes.defRoute)

}
