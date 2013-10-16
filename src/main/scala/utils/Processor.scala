package utils

import models.{GeometricObjectQuote, GeometricObject}
import scala.annotation.tailrec

object Processor {

  def findBestQuotes(demand: List[GeometricObject], offersMap: Map[Int, List[GeometricObjectQuote]]): Option[Result] = {
    lookup(demand, Accumulator(rest = offersMap)).map {
      acc =>
        val rest = acc.rest.values.flatten.toList
        Result(acc.selection, rest, offersMap)
    }
  }


  @tailrec
  private def lookup(demand: List[GeometricObject], acc: Accumulator): Option[Accumulator] = {
    demand match {
      case x :: xs => {
        findMatchingQuotes(x, acc.rest) match {
          case Some((offerId, selectedQuote)) => {
            val quotes = acc.rest(offerId)

            // remove selected quote from original list
            val filteredQuotes = quotes.filterNot(_ == selectedQuote)

            // build updated map
            val updatedOffersMap = acc.rest + (offerId -> filteredQuotes)

            // continue searching with demand tail and new accumulator
            lookup(xs, Accumulator(acc.selection :+ selectedQuote, updatedOffersMap))
          }
          case _ => None
        }
      }
      case Nil => Some(acc)
    }
  }

  private def findMatchingQuotes(geometricObject: GeometricObject, offers: Map[Int, List[GeometricObjectQuote]]): Option[(Int, GeometricObjectQuote)] = {

    // reduce map to contain only matches
    val preSelectionMap = for {
        (offerId, quotes) <- offers
      } yield (offerId, quotes.filter(_.geometricObject == geometricObject))

    val preSelection = preSelectionMap.map {
      case (offerId, quotes) => quotes.map { quote => offerId -> quote }
    }.flatten.toList

    selectBestQuote(preSelection)
  }

  private def selectBestQuote(quotes: List[(Int, GeometricObjectQuote)]): Option[(Int, GeometricObjectQuote)] = {
    val bestQuote = quotes match {
      case Nil => None
      case _ => {
        val min = quotes.minBy {
          case (i, g) => g.price
        }
        Some(min)
      }
    }
    bestQuote
  }
}


private case class Accumulator(selection: List[GeometricObjectQuote] = List(),
                               rest: Map[Int, List[GeometricObjectQuote]] = Map())

case class Result(selection: List[GeometricObjectQuote] = List(),
                  rest: List[GeometricObjectQuote] = List(),
                  offersMap: Map[Int, List[GeometricObjectQuote]]) {

  val totalSelectionPrice = selection.map(_.price).sum
  val totalRestPrice = rest.map(_.price).sum
  val totalPrice = totalSelectionPrice + totalRestPrice

  def print(f: (String) => Unit) : Unit = {
    f(s"total price $totalPrice")

    f(s"total selection $totalSelectionPrice")
    f(s"selection size ${selection.size}")

    f(s"total rest $totalRestPrice")
    f(s"rest size ${rest.size}")

    f(s"offers is ${offersMap.keys.mkString(", ")}")
  }
}