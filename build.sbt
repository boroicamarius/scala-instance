ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.11"

libraryDependencies ++= Seq(
  "org.postgresql" % "postgresql" % "42.5.4",
  "org.flywaydb" % "flyway-core" % "9.21.1"
)

ThisBuild / assemblyMergeStrategy := {
  case PathList("META-INF", _*) => MergeStrategy.discard
  case _ => MergeStrategy.first
}

lazy val root = (project in file("."))
  .settings(
    name := "Scala-instance",
    idePackagePrefix := Some("com.scaladocker")
  )

Compile / mainClass := Some("com.scaladocker.Main")
