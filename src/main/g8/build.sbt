// *****************************************************************************
// Projects
// *****************************************************************************

ThisBuild / scalafixDependencies += "com.github.liancheng" %% "organize-imports" % "0.4.3"

lazy val `$project_name$` =
  project
    .in(file("."))
    .settings(settings)
    .settings(
      libraryDependencies ++= Seq(
        $if(cats.truthy)$library.catsCore,$endif$
        library.log4jSlf4j,
        library.scalaLogging,
        library.munit % Test
      )
    )

// *****************************************************************************
// Library dependencies
// *****************************************************************************

lazy val library =
  new {
    object Version {
      $if(cats.truthy)$val cats         = "2.4.1"$endif$
      val log4j        = "2.13.3"
      val munit        = "0.7.21"
      val scalaLogging = "3.9.2"
    }
    $if(cats.truthy)$val catsCore       = "org.typelevel"              %% "cats-core"            % Version.cats$endif$
    val log4jSlf4j     = "org.apache.logging.log4j"    % "log4j-slf4j-impl"     % Version.log4j
    val munit          = "org.scalameta"              %% "munit"                % Version.munit
    val scalaLogging   = "com.typesafe.scala-logging" %% "scala-logging"        % Version.scalaLogging
  }

// *****************************************************************************
// Settings
// *****************************************************************************

lazy val settings = commonSettings

lazy val commonSettings =
  Seq(
    scalaVersion := "2.13.4",
    organization := "$organization$",
    organizationName := "$organization_name$",
    startYear := Some(2020),
    licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0")),
    scalacOptions ++= customScalacOptions,
    Compile / unmanagedSourceDirectories := Seq((Compile / scalaSource).value),
    Test / unmanagedSourceDirectories := Seq((Test / scalaSource).value),
    testFrameworks += new TestFramework("munit.Framework")
)

lazy val customScalacOptions = Seq(
  "-unchecked",
  "-deprecation",
  "-feature",
  "-language:_",
  "-target:jvm-1.8",
  "-encoding", "UTF-8"
)

addCommandAlias("prepare", ";clean;scalafmt;test:scalafmt")
addCommandAlias("validate", ";clean;scalafmtCheck;test:scalafmtCheck;test")
