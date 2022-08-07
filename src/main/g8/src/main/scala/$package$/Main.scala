package $package$

import cats.effect.{ ExitCode, IO, IOApp }

object Main extends IOApp:
  private val logger = scribe.cats[IO]

  override def run(args: List[String]): IO[ExitCode] =
    val app = logger.debug("Starting engines...")
    app.as(ExitCode.Success)

end Main
