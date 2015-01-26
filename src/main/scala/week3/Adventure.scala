package week3

import scala.util.Try

abstract class Coin
abstract class Treasure

trait Adventure {
  def collectCoins(): Try[List[Coin]]
  def buyTreasure(coins: List[Coin]): Try[Treasure]
}

object Game extends App {
  val adventure = new Adventure {

    override def collectCoins(): Try[List[Coin]] = ???

    override def buyTreasure(coins: List[Coin]): Try[Treasure] = ???
  }


  val treasure: Try[Treasure] = for {
    coins <- adventure.collectCoins()
    treasure <- adventure.buyTreasure(coins)
  } yield treasure

}
