package week3

import scala.concurrent.Future
import scala.util.{Failure, Success}

import scala.concurrent.ExecutionContext.Implicits.global

trait Socket {
  def readFromMemory(): Future[Array[Byte]]
  def sendToEurope(packet: Array[Byte]): Future[Array[Byte]]
}

object Main extends App {
  def socket = new Socket {
    override def sendToEurope(packet: Array[Byte]): Future[Array[Byte]] = ???
    override def readFromMemory(): Future[Array[Byte]] = ???
  }

  val confirmation: Future[Array[Byte]] = socket.readFromMemory() flatMap {
    socket.sendToEurope
  }
}
