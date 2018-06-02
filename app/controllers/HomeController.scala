package controllers

import com.typesafe.scalalogging.LazyLogging
import javax.inject._
import play.api.mvc._

@Singleton
class HomeController @Inject()(cc: ControllerComponents) (implicit assetsFinder: AssetsFinder)
  extends AbstractController(cc) with LazyLogging {

  def index = Action {

    logger.trace("trace log")
    logger.debug("debug log")
    logger.info("info log")
    logger.warn("warn log")
    logger.error("error log")

    Ok(views.html.index("hello"))
  }

}
