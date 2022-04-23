name := "Sclaimplicittest"

version := "0.1"

scalaVersion := "2.13.8"

lazy val doobieVersion = "1.0.0-RC1"

libraryDependencies ++= Seq(
  "org.tpolecat" %% "doobie-core"     % doobieVersion,
  "org.tpolecat" %% "doobie-postgres" % doobieVersion,
  "org.tpolecat" %% "doobie-specs2"   % doobieVersion
)
