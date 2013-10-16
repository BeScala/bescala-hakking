import models.RepositoryBig
import utils.Processor


Processor.findBestQuotes(RepositoryBig.demand(100), RepositoryBig.offers(200)).map { result =>
  result.print(println)
}

