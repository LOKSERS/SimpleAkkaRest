package Data


import cats.effect.IO
import doobie.implicits.toSqlInterpolator
import doobie.util.transactor.Transactor.Aux
import doobie.implicits._
import cats.effect.unsafe.implicits.global

//case class UserDTO extends User(
//
//)



case class User(
                 var id: Long,
                 var Name: String,
                 var age: Int,
                 var idSystemRole: Int = 0,
                 var idDepartment: Int = 0
               ) {
}

object User {

  //TODO сделать вставку пользователя

  def findById(idp: Long)(implicit conn: Aux[IO, Unit]): Option[User] = {
    sql"select id, firstname as Name, nage as age from usr where id = $idp"
      .query[User]
      .to[List]
      .transact(conn)
      .unsafeRunSync()
      .headOption
  }

  def findByFirstName(name: String)(implicit conn: Aux[IO, Unit]): List[User] = {
    sql"select id, firstname as Name, nage as age from usr where firstname like '%'||$name||'%'"
      .query[User]
      .to[List]
      .transact(conn)
      .unsafeRunSync()
  }


}




