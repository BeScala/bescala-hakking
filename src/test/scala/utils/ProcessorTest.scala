package utils

import org.scalatest.{Matchers, FunSpec}
import models._
import models.GeometricObjectQuote
import models.GeometricObject

class ProcessorTest extends FunSpec with Matchers {

  describe("A Processor") {

    it("should produce a Some(Result) if offersMap fulfill demand") {
      val resultOpt = Processor.findBestQuotes(demand, Map(1 -> offer1, 2 -> offer2))

      resultOpt should be ('defined)

      resultOpt.map { result =>
        result.totalPrice should be (22.3)
        result.totalSelectionPrice should be(13.3)
        result.totalRestPrice should be(9)
      }
    }

    it("should produce a None if offersMap DOES NOT fulfill demand") {
      val resultOpt = Processor.findBestQuotes(demand, Map())
      resultOpt should be (None)
    }
  }


  def demand: List[GeometricObject] = List(
    GeometricObject(Circle, Blue, Glass, 10),
    GeometricObject(Circle, Blue, Glass, 10),
    GeometricObject(Circle, Blue, Metal, 20.1),
    GeometricObject(Circle, Blue, Paper, 12.1)
  )

  def offers = Map(1 -> offer1, 2 -> offer2, 3 -> offer3)

  val offer1 =
    List(
      GeometricObjectQuote(GeometricObject(Circle, Blue, Glass, 10), 3),
      GeometricObjectQuote(GeometricObject(Circle, Blue, Glass, 10), 5),
      GeometricObjectQuote(GeometricObject(Circle, Blue, Paper, 12.1), 0.30),
      GeometricObjectQuote(GeometricObject(Circle, Blue, Metal, 20.1), 8)
    )


  val offer2 =
    List(
      GeometricObjectQuote(GeometricObject(Circle, Blue, Glass, 10), 2),
      GeometricObjectQuote(GeometricObject(Circle, Blue, Ceramic, 11), 4)
    )

  val offer3 =
    List(
      GeometricObjectQuote(GeometricObject(Circle, Blue, Metal, 11), 5),
      GeometricObjectQuote(GeometricObject(Circle, Blue, Glass, 10), 3)
    )

}
