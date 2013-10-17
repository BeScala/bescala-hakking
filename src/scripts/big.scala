import models.RepositoryBig
import utils.Processor

val start = System.currentTimeMillis()
Processor.findBestQuotes(RepositoryBig.demand, RepositoryBig.offers).map { result =>
  result.print(println)
}
val end = System.currentTimeMillis()
println(s"total time: ${end - start}")

