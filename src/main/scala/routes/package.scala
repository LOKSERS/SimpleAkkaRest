import Configuration.{DefConfig, DefDBConfig, DefJsonFormat}
import Data.User
import akka.http.scaladsl.model.{ContentTypes, HttpEntity, StatusCodes}
import akka.http.scaladsl.server.{Directives, Route}
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport._

import scala.concurrent.Future

package object routes extends Directives with DefDBConfig with DefConfig with DefJsonFormat {

  lazy val defRoute: Route = {
    path("") {
      get {
        complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>Say hello to akka-http</h1>"))
      }
    }
  }

  lazy val userRoute: Route = {
    concat(
      get {
        pathPrefix("user" / LongNumber) {
          id =>
            val maybeUser = Future(User.findById(id))
            onSuccess(maybeUser) {
              case Some(user)
              => complete(StatusCodes.OK, user)
              case None => complete(User(id, "Loks", 13))
            }
        }
      },
      defRoute
    )
  }
}
