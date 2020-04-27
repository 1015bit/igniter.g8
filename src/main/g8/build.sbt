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
        library.munit % Test
      )
    )

// *****************************************************************************
// Library dependencies
// *****************************************************************************

lazy val library =
  new {
    object Version {
      $if(cats.truthy)$val cats         = "2.1.1"$endif$
      val log4j        = "2.13.1"
      val munit        = "0.7.3"
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
    scalaVersion := "2.13.2",
    organization := "$organization$",
    organizationName := "$organization_name$",
    startYear := Some(2020),
    licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0")),
    scalacOptions ++= scalacOptionsAll,
    Compile / unmanagedSourceDirectories := Seq((Compile / scalaSource).value),
    Test / unmanagedSourceDirectories := Seq((Test / scalaSource).value),
    testFrameworks += new TestFramework("munit.Framework")
)

lazy val scalacOptionsAll = Seq(
  "-unchecked",
  "-deprecation",
  "-feature",
  "-language:_",
  "-target:jvm-1.8",
  "-encoding", "UTF-8"
) ++ scalacOptionsWarning ++ scalacOptionsLinter

lazy val scalacOptionsWarning = Seq(
  "-Wdead-code",
  "-Wextra-implicit",
  "-Wnumeric-widen",
  "-Woctal-literal",
  "-Wself-implicit",
  "-Wvalue-discard",
  "-Wunused:imports",
  "-Wunused:patvars",
  // "-Wunused:privates", // potential bug: enabling unused:privates also warns about unused local definitions
  // "-Wunused:locals",
  "-Wunused:explicits"
)

// copied from monix/minitest :)
lazy val scalacOptionsLinter = Seq(
  "-Xlint:adapted-args", // warn if an argument list is modified to match the receiver
  "-Xlint:nullary-unit", // warn when nullary methods return Unit
  "-Xlint:inaccessible", // warn about inaccessible types in method signatures
  "-Xlint:nullary-override", // warn when non-nullary `def f()' overrides nullary `def f'
  "-Xlint:infer-any", // warn when a type argument is inferred to be `Any`
  "-Xlint:missing-interpolator", // a string literal appears to be missing an interpolator id
  "-Xlint:doc-detached", // a ScalaDoc comment appears to be detached from its element
  "-Xlint:private-shadow", // a private field (or class parameter) shadows a superclass field
  "-Xlint:type-parameter-shadow", // a local type parameter shadows a type already in scope
  "-Xlint:poly-implicit-overload", // parameterized overloaded implicit methods are not visible as view bounds
  "-Xlint:option-implicit", // Option.apply used implicit view
  "-Xlint:delayedinit-select", // Selecting member of DelayedInit
  "-Xlint:package-object-classes", // Class or object defined in package object
)

addCommandAlias("prepare", ";clean;scalafmt;test:scalafmt")
addCommandAlias("validate", ";clean;scalafmtCheck;test:scalafmtCheck;test")
