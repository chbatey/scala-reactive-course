package week3

import java.util.concurrent.TimeUnit

import com.typesafe.scalalogging.LazyLogging

import scala.collection.immutable.IndexedSeq
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

import scala.concurrent.ExecutionContext.Implicits.global

object Futures extends App with LazyLogging {


  val future1 = Future {
    logger.debug("hello")
  }

  val future2 = Future {
    logger.debug("hello")
  }

//  Future.failed()

  val whatType: IndexedSeq[() => Future[Unit]] = (1 to 3).map(_ => () => future1)
  val failed = Future.failed(new Exception("Oh dear"))

  Await.ready(future1.zip(future2), Duration(1, TimeUnit.SECONDS))

  def retry[T](noTimes: Int)(block: =>Future[T]): Future[T] = {
    val ns: Iterator[Int] = (1 to noTimes).iterator
    val attempts: Iterator[() => Future[T]] = ns.map(_=> ()=>block)
    val failed = Future.failed(new Exception("i gave up"))


    attempts.foldRight(() =>failed)((block, a) => block().fallbackTo { a() })
  }
}
