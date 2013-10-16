import models.RepositoryBig
import utils.Processor

val start = System.currentTimeMillis()
Processor.findBestQuotes(RepositoryBig.demand(20), RepositoryBig.offers(100)).map { result =>
  result.print(println)
}
val end = System.currentTimeMillis()
println(s"total time: ${end - start}")

