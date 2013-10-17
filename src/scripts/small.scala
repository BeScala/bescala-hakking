import models.RepositorySmall
import utils.Processor

Processor.findBestQuotes(RepositorySmall.demand, RepositorySmall.offers).map { result =>
  result.print(println)
}

