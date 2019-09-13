// *****************************************************************************
// Projects
// *****************************************************************************

lazy val `$project_name$` =
  project
    .in(file("."))
    .settings(settings)
    .settings(
      libraryDependencies ++= Seq(
        $if(cats.truthy)$library.catsCore,$endif$
        library.log4jSlf4j,
        library.scalaLogging,
        library.minitest % Test
      )
    )

// *****************************************************************************
// Library dependencies
// *****************************************************************************

lazy val library =
  new {
    object Version {
      $if(cats.truthy)$val cats         = "2.0.0"$endif$
      val log4j        = "2.12.1"
      val minitest     = "2.7.0"
      val scalaLogging = "3.9.2"
    }
    $if(cats.truthy)$val catsCore       = "org.typelevel"              %% "cats-core"            % Version.cats$endif$
    val log4jSlf4j     = "org.apache.logging.log4j"    % "log4j-slf4j-impl"     % Version.log4j
    val minitest       = "io.monix"                   %% "minitest"             % Version.minitest
    val scalaLogging   = "com.typesafe.scala-logging" %% "scala-logging"        % Version.scalaLogging
  }

// *****************************************************************************
// Settings
// *****************************************************************************

lazy val settings = commonSettings

lazy val commonSettings =
  Seq(
    scalaVersion := "2.13.0",
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
      "-Wdead-code",
      "-Wextra-implicit",
      "-Wnumeric-widen",
      "-Woctal-literal",
      "-Wself-implicit",
      "-Wunused",
      "-Wvalue-discard",
      "-Xlint:_"
    ),
    Compile / unmanagedSourceDirectories := Seq((Compile / scalaSource).value),
    Test / unmanagedSourceDirectories := Seq((Test / scalaSource).value),
    testFrameworks += new TestFramework("minitest.runner.Framework")
)

addCommandAlias("prepare", ";clean;scalafmt;test:scalafmt")
addCommandAlias("validate", ";clean;scalafmtCheck;test:scalafmtCheck;test")
