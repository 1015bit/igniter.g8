// *****************************************************************************
// Global settings
// *****************************************************************************

// Core settings
ThisBuild / licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))
ThisBuild / organization := "$organization$"
ThisBuild / scalaVersion := "3.3.0"
ThisBuild / startYear    := Some(2023)

// Plugin settings
ThisBuild / scalafixDependencies += "com.github.liancheng" %% "organize-imports" % lib.V.organizeImports
ThisBuild / semanticdbEnabled := true
ThisBuild / semanticdbVersion := scalafixSemanticdb.revision

// *****************************************************************************
// Projects
// *****************************************************************************

lazy val `$project_name$` =
  project
    .in(file("."))
    .settings(commonSettings)
    .settings(
      libraryDependencies ++= Seq(
        lib.catsEffect,
        lib.scribeCats,
        lib.catsEffectTestkit % Test,
        lib.munit             % Test
      )
    )

// *****************************************************************************
// Library dependencies
// *****************************************************************************

lazy val lib =
  new {

    object V {
      val catsEffect      = "3.5.1"
      val munit           = "0.7.29"
      val organizeImports = "0.6.0"
      val scribe          = "3.11.7"
    }

    val catsEffect        = "org.typelevel"        %% "cats-effect"         % V.catsEffect
    val catsEffectTestkit = "org.typelevel"        %% "cats-effect-testkit" % V.catsEffect
    val munit             = "org.scalameta"        %% "munit"               % V.munit
    val organizeImports   = "com.github.liancheng" %% "organize-imports"    % V.organizeImports
    val scribeCats        = "com.outr"             %% "scribe-cats"         % V.scribe
  }

// *****************************************************************************
// Settings
// *****************************************************************************

lazy val commonSettings =
  Seq(
    testFrameworks += new TestFramework("munit.Framework")
  )

// *****************************************************************************
// Aliases
// *****************************************************************************

addCommandAlias("prepare", ";clean;scalafixAll;scalafmtAll")
addCommandAlias("validate", ";clean;scalafixAll --check;scalafmtCheckAll;test")
