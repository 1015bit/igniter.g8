// *****************************************************************************
// Global settings
// *****************************************************************************

ThisBuild / scalaVersion := "3.1.0"
ThisBuild / organization := "$organization$"
ThisBuild / startYear    := Some(2021)
ThisBuild / licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))

ThisBuild / scalafixDependencies += lib.organizeImports

// *****************************************************************************
// Projects
// *****************************************************************************

lazy val `$project_name$` =
  project
    .in(file("."))
    .settings(settings)
    .settings(
      libraryDependencies ++= Seq(
        $if(cats.truthy)$lib.catsCore,$endif$
        lib.log4jSlf4j,
        lib.scalaLogging,
        lib.munit % Test
      )
    )

// *****************************************************************************
// Library dependencies
// *****************************************************************************

lazy val lib =
  new {
    object V {
      $if(cats.truthy)$val cats         = "2.6.1"$endif$
      val log4j           = "2.14.1"
      val munit           = "0.7.29"
      val scalaLogging    = "3.9.4"
      val organizeImports = "0.6.0"
    }
    $if(cats.truthy)$val catsCore       = "org.typelevel"              %% "cats-core"            % V.cats$endif$
    val log4jSlf4j      = "org.apache.logging.log4j"    % "log4j-slf4j-impl"     % V.log4j
    val munit           = "org.scalameta"              %% "munit"                % V.munit
    val scalaLogging    = "com.typesafe.scala-logging" %% "scala-logging"        % V.scalaLogging
    val organizeImports = "com.github.liancheng"       %% "organize-imports"     % V.organizeImports
  }


// *****************************************************************************
// Settings
// *****************************************************************************

lazy val settings = commonSettings

lazy val commonSettings =
  Seq(
    scalacOptions ++= commonScalacOptions,
    Compile / unmanagedSourceDirectories := Seq((Compile / scalaSource).value),
    Test / unmanagedSourceDirectories    := Seq((Test / scalaSource).value),
    testFrameworks += new TestFramework("munit.Framework")
  )

lazy val commonScalacOptions = Seq(
  "-deprecation",
  "-encoding",
  "UTF-8",
  "-explain",
  "-explain-types",
  "-feature", // warn about usage of features that need to be enabled explicitly
  "-indent",
  "-language:_",
  "-new-syntax", // `then` and `do`
  "-print-lines",
  "-unchecked",
  "-Ykind-projector:underscores", // use new type lambda syntax
  //"-Xfatal-warnings",
  "-Xmigration"
  //"-Xsemanticdb"
)

// *****************************************************************************
// Aliases
// *****************************************************************************

addCommandAlias("prepare", ";clean;scalafmt;test:scalafmt")
addCommandAlias("validate", ";clean;scalafmtCheck;test:scalafmtCheck;test")