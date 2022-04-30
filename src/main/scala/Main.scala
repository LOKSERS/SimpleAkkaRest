
import akka.http.scaladsl.Http
import Configuration.DefConfig


import scala.io.StdIn

object Main extends App with DefConfig {


  val bindingFuture = Http().newServerAt("localhost", 8080).bind(
    routes.userRoute
  )

  println(s"Server now online. Please navigate to http://localhost:8080/hello\nPress RETURN to stop...")
  StdIn.readLine() // let it run until user presses return
  bindingFuture
    .flatMap(_.unbind()) // trigger unbinding from the port
    .onComplete(_ => system.terminate()) // and shutdown when done
}

