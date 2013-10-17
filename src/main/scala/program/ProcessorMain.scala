package program

import akka.actor.ActorSystem
import akka.actor.Props
import scala.concurrent.duration._
import scala.concurrent.Await
import akka.pattern.ask
import actors.ProcessorActor
import models.RepositoryBig._
import akka.util.Timeout
import utils.Result

object ProcessorMain {

  def main(args: Array[String]): Unit = {
    import ProcessorActor._

    implicit val timeout = Timeout(5 seconds)
    
    val system = ActorSystem("Processor")
    
    val processorActor = system.actorOf(Props[ProcessorActor], "processoractor")
    
    val resultfuture = processorActor ? DemandMessage(demand, offers)
    
    val result = Await.result(resultfuture, 5 seconds).asInstanceOf[Option[Result]]
    
    result.map{ r => r.print(println) }
    
    system.shutdown
    system.awaitTermination
  }

}