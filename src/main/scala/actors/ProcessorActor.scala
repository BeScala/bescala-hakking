package actors

import akka.actor.Actor
import akka.actor.Props
import models.GeometricObjectQuote
import models.GeometricObject
import utils.Processor

object ProcessorActor {
  case class DemandMessage(demand: List[GeometricObject])
}

class ProcessorActor(offersMap: Map[Int, List[GeometricObjectQuote]]) extends Actor {
  import ProcessorActor._
  
  def receive = {
    case DemandMessage(demand) => {
      val resultOpt = Processor.findBestQuotes(demand, offersMap)
      
      sender ! resultOpt
    }
  }

}