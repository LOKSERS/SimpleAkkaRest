package Configuration

import Data.User
import spray.json.DefaultJsonProtocol.{IntJsonFormat, LongJsonFormat, StringJsonFormat, jsonFormat3, jsonFormat4, jsonFormat5}

trait DefJsonFormat{
  implicit val format = jsonFormat5(User.apply)
}
