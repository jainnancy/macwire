name := "macwire"

version := "0.1"

scalaVersion := "2.12.8"

resolvers += "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"

libraryDependencies += "com.softwaremill.macwire" %% "macros" % "2.3.2-SNAPSHOT" % "provided"

libraryDependencies += "com.softwaremill.macwire" %% "util" % "2.3.2-SNAPSHOT"
