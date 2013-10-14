package actors

import org.scalatest.{Matchers, FunSpec}
import akka.testkit.TestActorRef
import scala.concurrent.duration._
import scala.concurrent.Await
import akka.pattern.ask
import models.GeometricObjectQuote
import models.GeometricObject
import models._
import akka.actor.ActorSystem
import akka.util.Timeout

class ProcessorActorTest extends FunSpec with Matchers {
  import ProcessorActor._
  
  implicit val system = ActorSystem("test")
  implicit val timeout = Timeout(5 seconds)
  
  describe("A ProcessorActor") {
    it("should send back a Some(Result) if offersMap fullfill demand") {
      val processorActor = TestActorRef(new ProcessorActor(offers))
      val demand1 = DemandMessage(demand)
      
      val resultFuture = processorActor ? demand1
      val resultOption = Await.result(resultFuture, 5 seconds).asInstanceOf[Option[utils.Result]]
      
      resultOption should be ('defined)

      resultOption.map { result =>
      result.totalPrice should be (22.3)
      result.totalSelectionPrice should be(13.3)
      result.totalRestPrice should be(9)
      }
    }
  }
  
  def demand: List[GeometricObject] = List(
    GeometricObject(Circle, Blue, Glass, 10),
    GeometricObject(Circle, Blue, Glass, 10),
    GeometricObject(Circle, Blue, Metal, 20.1),
    GeometricObject(Circle, Blue, Paper, 12.1)
  )
  
  def offers = Map(1 -> offer1, 2 -> offer2)
  
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