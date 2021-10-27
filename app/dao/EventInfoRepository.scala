package dao

import models.EventInfo

import scala.concurrent.Future

trait EventInfoRepository {
  def store(event: EventInfo): Future[Boolean]
}
