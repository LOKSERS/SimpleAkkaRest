import ConfigSettrings.DefDBLayer
import Entity.User
import akka.http.scaladsl.model.{ContentTypes, HttpEntity, StatusCodes}
import akka.http.scaladsl.server.{Directives, Route}


package object Routes extends Directives with DefDBLayer {

  val defRoute: Route = {
    path("hello") {
      get {
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>Welcome!</h1>"))
      }
    }
    get {
      pathPrefix("user" / LongNumber) { id =>
        val userOpt = User.findById(id)
        userOpt match {
          case Some(user) => complete(StatusCodes.OK, User.toJson(user))
          case None => complete(StatusCodes.NotFound)
        }

      }
    }
  }

}
