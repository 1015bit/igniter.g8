package $package$

import com.typesafe.scalalogging.StrictLogging

object Main extends StrictLogging {

  def main(args: Array[String]): Unit = {
    logger.debug("be")
    logger.info("curious")
  }

}
