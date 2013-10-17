package program

import akka.actor.ActorSystem
import akka.actor.Actor
import akka.actor.Props
import scala.concurrent.duration._
import scala.concurrent.Await
import akka.pattern.ask
import models.RepositorySmall
import akka.util.Timeout
import utils.Result

object ProcessorMain {

  def main(args: Array[String]): Unit = {
    
    import RepositorySmall._
    
    implicit val timeout = Timeout(5 seconds)
    
    val system = ActorSystem("Processor")
    
    system.shutdown
    system.awaitTermination
  }

}