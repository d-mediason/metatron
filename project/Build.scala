import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {

  val appName         = "metatron"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    // Add your project dependencies here,
    jdbc,
    anorm,
    "net.debasishg" % "redisclient_2.10" % "2.10"

  )


  val main = play.Project(appName, appVersion, appDependencies).settings(
    // Add your own project settings here      
  )

}
