package controllers

import java.time.ZonedDateTime

import akka.actor.ActorSystem
import ch.qos.logback.classic.{Level, LoggerContext}
import com.typesafe.scalalogging.LazyLogging
import javax.inject._
import org.slf4j.LoggerFactory
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class LogLevelController @Inject()(
  cc: ControllerComponents,
  actorSystem: ActorSystem)(implicit exec: ExecutionContext)
  extends AbstractController(cc) with LazyLogging {

  def changeLevel(level: String) = Action.async {

    println(s"current time: ${ZonedDateTime.now()}")

    logger.trace("before: trace log")
    logger.debug("before: debug log")
    logger.info("before: info log")
    logger.warn("before: warn log")
    logger.error("before: error log")

    val context: LoggerContext =
      LoggerFactory.getILoggerFactory.asInstanceOf[LoggerContext]
    context.getLogger(this.getClass).setLevel(Level.valueOf(level))

    logger.trace("after: trace log")
    logger.debug("after: debug log")
    logger.info("after: info log")
    logger.warn("after: warn log")
    logger.error("after: error log")

    Future.successful(Ok)
  }

}
