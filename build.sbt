name := "todo.cli"
organization := "objektwerks"
version := "0.8-SNAPSHOT"
scalaVersion := "3.6.4"
libraryDependencies ++= Seq(
  "org.scalafx" %% "scalafx" % "23.0.1-R34",
  "com.lihaoyi" %% "os-lib" % "0.11.5-M3",
  "com.lihaoyi" %% "upickle" % "4.1.0",
  "com.typesafe" % "config" % "1.4.3",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
  "ch.qos.logback" % "logback-classic" % "1.5.18",
  "org.scalatest" %% "scalatest" % "3.2.19" % Test
)
scalacOptions ++= Seq(
  "-Wunused:all"
)