package Data


import cats.effect.IO
import doobie.implicits.toSqlInterpolator
import doobie.util.transactor.Transactor.Aux
import doobie.implicits._
import cats.effect.unsafe.implicits.global


case class User(
                 var id: Long,
                 var Name: String,
                 var age: Int,
               ) {
}

object User {

  def findById(idp: Long)(implicit conn: Aux[IO, Unit]): Option[User] = {
    sql"select id, firstname as Name, nage as age from usr where id = $idp"
      .query[User] // Query0[String]
      .to[List] // ConnectionIO[List[String]]
      .transact(conn) // IO[List[String]]
      .unsafeRunSync() // List[String]
      .headOption
  }


}




