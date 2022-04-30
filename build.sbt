name := "AkkaHttpRest"

version := "0.1"

scalaVersion := "2.13.8"

lazy val doobieVersion = "1.0.0-RC1"
val AkkaVersion = "2.6.8"
val AkkaHttpVersion = "10.2.9"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
  "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % AkkaHttpVersion,
  "org.tpolecat" %% "doobie-postgres" % "1.0.0-RC2"
)

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % AkkaVersion
// https://mvnrepository.com/artifact/com.typesafe.play/play-json
libraryDependencies += "com.typesafe.play" %% "play-json" % "2.10.0-RC6"
// https://mvnrepository.com/artifact/de.heikoseeberger/akka-http-play-json
libraryDependencies += "de.heikoseeberger" %% "akka-http-play-json" % "1.40.0-RC1"

