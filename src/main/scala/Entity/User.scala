package Entity


import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import cats.effect.IO
import doobie.implicits.toSqlInterpolator
import doobie.util.transactor.Transactor.Aux
import doobie.implicits._
import cats.effect.unsafe.implicits.global
import spray.json.{DefaultJsonProtocol, NullOptions, RootJsonFormat}


sealed case class User(var id: Long,
                      var Name: String,
                     )

object User {

  def findById(idp: Long)(implicit conn: Aux[IO, Unit]): Option[User] = {
    sql"select id, name from user where id = $idp"
      .query[User] // Query0[String]
      .to[List] // ConnectionIO[List[String]]
      .transact(conn) // IO[List[String]]
      .unsafeRunSync() // List[String]
      .headOption
  }

  def toJson(user: User): String = {
    "{" +
      s"\"Name\" : ${user.Name}" +
      s"\"id\" : ${user.id}" +
      "}"
  }

}
