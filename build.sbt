name := "contester-dbmodel"

javaOptions in run ++= Seq("-XX:+HeapDumpOnOutOfMemoryError", "-Xloggc:gclog.txt", "-Xms512m", "-Xmx512m",
  "-XX:MaxPermSize=256m", "-XX:+CMSClassUnloadingEnabled")

scalaVersion := "2.12.12"

version := "2020.0.1-SNAPSHOT"

organization := "org.stingray.contester"

scalacOptions ++= Seq(
  "-Xfatal-warnings",  // New lines for each options
  "-deprecation",
  "-Xasync",
  "-unchecked",
  "-language:implicitConversions",
  "-language:higherKinds",
  "-language:existentials",
  "-language:postfixOps",
  "-opt:l:method",
  "-opt:l:inline",
  "-opt-inline-from:<sources>"
)

updateOptions := updateOptions.value.withCachedResolution(true)

resolvers ++= Seq(
  Resolver.jcenterRepo,
  Resolver.sonatypeRepo("snapshots"),
  Resolver.typesafeRepo("releases")
)

val slickPG = "0.19.2"

libraryDependencies ++= Seq(
  "org.scala-lang.modules" %% "scala-async" % "0.10.0",
  "org.scala-lang" % "scala-reflect" % scalaVersion.value % Provided,
  "com.github.nscala-time" %% "nscala-time" % "2.24.0",
  "com.typesafe.slick" %% "slick" % "3.3.2",
  "com.typesafe.slick" %% "slick-hikaricp" % "3.3.2",
  "org.postgresql" % "postgresql" % "42.2.14",
  "com.github.tminglei" %% "slick-pg" % slickPG,
  "com.github.tminglei" %% "slick-pg_joda-time" % slickPG,
  "com.github.tminglei" %% "slick-pg_play-json" % slickPG,
  "org.scalatest" %% "scalatest" % "3.0.5" % "test"
).map(_.exclude("org.slf4j", "slf4j-jdk14")).map(_.exclude("org.slf4j", "slf4j-log4j12"))
