package Data

import cats.effect.IO
import doobie.implicits.toSqlInterpolator
import doobie.util.transactor.Transactor.Aux
import doobie.implicits._
import cats.effect.unsafe.implicits.global

case class Departments(var id: Long,
                       var sCaption: String,
                       var sDesignation: String)

object Departments {

  def findById(idp: Long)(implicit conn: Aux[IO, Unit]): Option[Departments] = {
    sql"select id, Caption , Designation from departments where id = $idp"
      .query[Departments] // Query0[String]
      .to[List] // ConnectionIO[List[String]]
      .transact(conn) // IO[List[String]]
      .unsafeRunSync() // List[String]
      .headOption
  }

}
