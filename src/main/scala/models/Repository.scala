package models

trait Repository {
  def demand: List[GeometricObject]
  def offers: Map[Int, List[GeometricObjectQuote]]
}

object RepositoryBig extends Repository {
  def demand =
    for {
      shape <- Shape.values
      color <- Color.values
      material <- Material.values
      area <- 1 to 20
    } yield GeometricObject(shape, color, material, area)


  def offers = Map(
    1 -> offer1,
    2 -> offer2,
    3 -> offer3,
    4 -> offer4
  )

  def offer1 =
    for {
      shape <- Shape.values
      color <- Color.values if Seq(Red, Black, Blue).contains(color)
      material <- Material.values
      area <- 1 to 55
    } yield GeometricObjectQuote(GeometricObject(shape, color, material, area), area * 0.02)

  def offer2 =
    for {
      shape <- Shape.values if Seq(Circle, Rectangle, Triangle, Ellipse).contains(shape)
      color <- Color.values
      material <- Material.values
      area <- 1 to 45
    } yield GeometricObjectQuote(GeometricObject(shape, color, material, area), area * 0.03)

  def offer3 =
    for {
      shape <- Shape.values
      color <- Color.values
      material <- Material.values if Seq(Paper, Plastic, Ceramic).contains(material)
      area <- 1 to 40
    } yield GeometricObjectQuote(GeometricObject(shape, color, material, area), area * 0.02)

  def offer4 =
    for {
      shape <- Shape.values
      color <- Color.values
      material <- Material.values if !Seq(Paper, Plastic, Ceramic).contains(material)
      area <- 1 to 50
    } yield GeometricObjectQuote(GeometricObject(shape, color, material, area), area * 0.03)

}
object RepositorySmall extends Repository {

  def demand: List[GeometricObject] = {
    List(
      GeometricObject(Circle, Blue, Glass, 10),
      GeometricObject(Circle, Blue, Glass, 10),
      GeometricObject(Circle, Blue, Metal, 20),
      GeometricObject(Circle, Blue, Paper, 12)
    )
  }

  def offers = Map(1 -> offer1, 2 -> offer2, 3 -> offer3)

  val offer1 =
    List(
      GeometricObjectQuote(GeometricObject(Circle, Blue, Glass, 10), 3),
      GeometricObjectQuote(GeometricObject(Circle, Blue, Glass, 10), 5),
      GeometricObjectQuote(GeometricObject(Circle, Blue, Paper, 12), 0.30),
      GeometricObjectQuote(GeometricObject(Circle, Blue, Metal, 20), 8)
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
