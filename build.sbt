scalaVersion := "2.12.4"

enablePlugins(JettyPlugin, TomcatPlugin)

libraryDependencies ++= Seq(
  "javax" % "javaee-api" % "8.0",
  "org.hibernate" % "hibernate-core" % "5.2.12.Final",
  "com.h2database" % "h2" % "1.4.196"
)

// containerArgs ++= Seq("--module=cdi")
