package program

import akka.actor.ActorSystem
import akka.actor.Actor
import akka.actor.Props
import scala.concurrent.duration._
import scala.concurrent.Await
import akka.pattern.ask
import actors.ProcessorActor

object ProcessorMain {

  def main(args: Array[String]): Unit = {
    val system = ActorSystem("Processor")
    
    val processorActor = system.actorOf(Props[ProcessorActor], "processoractor")
    
    system.shutdown
    system.awaitTermination
  }

}