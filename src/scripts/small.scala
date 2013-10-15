import models.RepositorySmall
import utils.Processor

Processor.findBestQuotes(RepositorySmall.demand(), RepositorySmall.offers()).map { result =>
  println(s"total price ${result.totalPrice}")

  println(s"total selection ${result.totalSelectionPrice}")
  println(s"selection size ${result.selection.size}")

  println(s"total rest ${result.totalRestPrice}")
  println(s"rest size ${result.rest.size}")
}

