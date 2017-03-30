name := "kafka-client"
version := "1.0"
scalaVersion := "2.12.1"

libraryDependencies += "org.apache.kafka" % "kafka-clients" % "0.10.2.0"

lazy val root = (project in file(".")).
  settings(
    name := "kafka-client",
    version := "1.0",
    scalaVersion := "2.12.1",
    mainClass in Compile := Some("Boot")
  )

// META-INF discarding
mergeStrategy in assembly <<= (mergeStrategy in assembly) { (old) =>
{
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
}