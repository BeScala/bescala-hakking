package models

trait Repository {
  def demand: List[GeometricObject]
  def offers: Map[Int, List[GeometricObjectQuote]]
}

object RepositoryReliable extends Repository {

  def demand: List[GeometricObject] = {
    List(
      GeometricObject(Circle, Blue, Glass, 10),
      GeometricObject(Circle, Blue, Glass, 10),
      GeometricObject(Circle, Blue, Metal, 20.1),
      GeometricObject(Circle, Blue, Paper, 12.1)
    )
  }

  def offers = Map(1 -> offer1, 2 -> offer2, 3 -> offer3)

  val offer1 =
    List(
      GeometricObjectQuote(GeometricObject(Circle, Blue, Glass, 10), 3),
      GeometricObjectQuote(GeometricObject(Circle, Blue, Glass, 10), 5),
      GeometricObjectQuote(GeometricObject(Circle, Blue, Paper, 12.1), 0.30),
      GeometricObjectQuote(GeometricObject(Circle, Blue, Metal, 20.1), 8)
    )


  val offer2 =
    List(
      GeometricObjectQuote(GeometricObject(Circle, Blue, Glass, 10), 2),
      GeometricObjectQuote(GeometricObject(Circle, Blue, Ceramic, 11), 4)
    )

  val offer3 =
    List(
      GeometricObjectQuote(GeometricObject(Circle, Blue, Metal, 11), 5),
      GeometricObjectQuote(GeometricObject(Circle, Blue, Glass, 10), 3)
    )


}
