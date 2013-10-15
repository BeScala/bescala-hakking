package actors

import akka.actor.Actor
import akka.actor.Props
import models.GeometricObjectQuote
import models.GeometricObject
import utils.Processor


object ProcessorActor {
  case class DemandMessage(demand: List[GeometricObject], offersMap: Map[Int, List[GeometricObjectQuote]])
}

class ProcessorActor extends Actor {
  import ProcessorActor._

  
  def receive = {
    case DemandMessage(demand, offersMap) => {
      val resultOpt = Processor.findBestQuotes(demand, offersMap)
      
      sender ! resultOpt
    }
  }

}