package Configuration

import Data.User
import spray.json.DefaultJsonProtocol.{IntJsonFormat, LongJsonFormat, StringJsonFormat, jsonFormat3, jsonFormat4}

trait DefJsonFormat{
  implicit val format = jsonFormat3(User.apply)
}
