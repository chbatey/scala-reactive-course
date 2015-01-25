package week1

import java.util.Random

object Generatos {
  trait Generator[+T] {
    def generate: T

    def map[S](f: T => S): Generator[S] = {
      new Generator[S] {
        def generate = f(Generator.this.generate)
      }
    }

    def flatMap[S](f: T => Generator[S]): Generator[S] = {
      new Generator[S] {
        def generate = f(Generator.this.generate).generate
      }
    }
  }

  val integers = new Generator[Int] {
    val rand = new Random
    def generate: Int = rand.nextInt
  }

  val booleans: Generator[Boolean] = for (i <- integers) yield i < 0

  trait Tree
  case class Inner(left: Tree, right: Tree) extends Tree
  case class Leaf(x: Int) extends Tree

  val trees: Generator[Tree] = for {
    isLeaf <- booleans
    tree <- if (isLeaf) leafNode else innerNode
  } yield tree

  def leafNode: Generator[Leaf] = for {
    value <- integers
  } yield Leaf(value)

  def innerNode: Generator[Inner] = for {
    left <- trees
    right <- trees
  } yield Inner(left, right)

  def main(args: Array[String]) {
    println(integers.generate)


    println(booleans.generate)
    println(booleans.generate)
    println(booleans.generate)

    println(trees.generate)
  }
}
