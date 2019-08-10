// *****************************************************************************
// Projects
// *****************************************************************************

lazy val `$project_name$` =
  project
    .in(file("."))
    .settings(settings)
    .settings(
      libraryDependencies ++= Seq(
        library.scalaCheck % Test,
        library.scalaTest  % Test
      ) ++ library.log4j
    )

// *****************************************************************************
// Library dependencies
// *****************************************************************************

lazy val library =
  new {
    object Version {
      val log4j      = "2.11.2"
      val log4jScala = "11.0"
      val scalaCheck = "1.14.0"
      val scalaTest  = "3.0.8"
    }
    val log4jApi       = "org.apache.logging.log4j"  % "log4j-api"            % Version.log4j
    val log4jCore      = "org.apache.logging.log4j"  % "log4j-core"           % Version.log4j
    val log4jScala     = "org.apache.logging.log4j" %% "log4j-api-scala"      % Version.log4jScala
    val log4jslf4j     = "org.apache.logging.log4j"  % "log4j-slf4j-impl"     % Version.log4j
    val scalaCheck     = "org.scalacheck"           %% "scalacheck"           % Version.scalaCheck
    val scalaTest      = "org.scalatest"            %% "scalatest"            % Version.scalaTest

    val log4j = Seq(log4jApi, log4jCore, log4jScala, log4jslf4j)
  }

// *****************************************************************************
// Settings
// *****************************************************************************

lazy val settings = commonSettings

lazy val commonSettings =
  Seq(
    scalaVersion := "2.12.8",
    organization := "$organization$",
    organizationName := "$organization_name$",
    startYear := Some(2019),
    licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0")),
    scalacOptions ++= Seq(
      "-unchecked",
      "-deprecation",
      "-feature",
      "-language:_",
      "-target:jvm-1.8",
      "-encoding", "UTF-8",
      "-Ypartial-unification",
      "-Ywarn-dead-code",
      "-Ywarn-extra-implicit",
      "-Ywarn-inaccessible",
      "-Ywarn-infer-any",
      "-Ywarn-nullary-override",
      "-Ywarn-nullary-unit",
      "-Ywarn-numeric-widen",
      "-Ywarn-unused:implicits",
      "-Ywarn-unused:imports",
      "-Ywarn-unused:locals",
      "-Ywarn-unused:params",
      "-Ywarn-unused:patvars",
      "-Ywarn-unused:privates",
      "-Ywarn-value-discard"
    ),
    Compile / unmanagedSourceDirectories := Seq((Compile / scalaSource).value),
    Test / unmanagedSourceDirectories := Seq((Test / scalaSource).value),
)

addCommandAlias("validate", ";clean;scalafmtCheck;test:scalafmtCheck;test")
