package db

import com.github.tototoshi.slick.MySQLJodaSupport._
import dao.EventInfoRepository
import models.EventInfo
import org.joda.time.DateTime
import slick.jdbc.MySQLProfile.api._
import slick.lifted.{ProvenShape, Rep, Tag}

import scala.concurrent.{ExecutionContext, Future}

class EventRepositorySqlImpl(db: Database)(implicit ec: ExecutionContext)
  extends TableQuery(new EventRepositoryTable(_))
    with EventInfoRepository {

  override def store(event: EventInfo): Future[Boolean] =
    db.run(this returning this.map(_.id) += event) map (_ > 0)

}

class EventRepositoryTable(tag: Tag) extends Table[EventInfo](tag, "events") {

  def id: Rep[Long] = column[Long]("id", O.PrimaryKey, O.AutoInc)

  def profileId: Rep[Long] = column[Long]("profile_id")

  def eventType: Rep[String] = column[String]("event_type")

  def invokedAt: Rep[DateTime] = column[DateTime]("invoked_at")

  def * : ProvenShape[EventInfo] =
    (id, profileId, eventType, invokedAt) <> (EventInfo.tupled, EventInfo.unapply)
}
