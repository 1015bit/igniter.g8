lazy val `igniter` =
  project
    .in(file("."))
    .enablePlugins(ScriptedPlugin)
    .settings(
      organization := "io.ontherocks",
      organizationName := "Petra Bierleutgeb",
      Test / test := {
        val _ = (Test / g8Test).toTask("").value
      },
      scriptedLaunchOpts ++= List("-Xms1024m",
                                  "-Xmx1024m",
                                  "-XX:ReservedCodeCacheSize=128m",
                                  "-Xss2m",
                                  "-Dfile.encoding=UTF-8"
      ),
      resolvers += Resolver.url("typesafe",
                                url("https://repo.typesafe.com/typesafe/ivy-releases/")
      )(Resolver.ivyStylePatterns)
    )
