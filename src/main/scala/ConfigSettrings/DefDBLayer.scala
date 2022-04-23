package ConfigSettrings

import cats.effect.IO
import doobie.Transactor
import doobie.util.transactor.Transactor.Aux

trait DefDBLayer {

  implicit lazy val connetion: Aux[IO, Unit] = Transactor.fromDriverManager[IO](
    "org.postgresql.Driver", // driver classname
    "jdbc:postgresql:TPRJS", // connect URL (driver-specific)
    "postgres", // user
    "555666" // password
  )

}
