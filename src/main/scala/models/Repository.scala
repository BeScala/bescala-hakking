package models

trait Repository {
  def demand(num: Int): List[GeometricObject]
  def offers(num:Int): Map[Int, List[GeometricObjectQuote]]
}

object RepositoryBig extends Repository {
  def demand(num: Int = 10) =
    for {
      shape <- Shape.values
      color <- Color.values
      material <- Material.values
      area <- 1 to num
    } yield GeometricObject(shape, color, material, area)


  def offers(num:Int) = Map(
    1 -> offer1(num),
    2 -> offer2(num),
    3 -> offer3(num),
    4 -> offer4(num)
  )

  def offer1(num:Int) =
    for {
      shape <- Shape.values
      color <- Color.values if Seq(Red, Black, Blue).contains(color)
      material <- Material.values
      area <- 1 to num
    } yield GeometricObjectQuote(GeometricObject(shape, color, material, area), area * 0.02)

  def offer2(num:Int) =
    for {
      shape <- Shape.values if Seq(Circle, Rectangle, Triangle, Ellipse).contains(shape)
      color <- Color.values
      material <- Material.values
      area <- 1 to num
    } yield GeometricObjectQuote(GeometricObject(shape, color, material, area), area * 0.03)

  def offer3(num:Int) =
    for {
      shape <- Shape.values
      color <- Color.values
      material <- Material.values if Seq(Paper, Plastic, Ceramic).contains(material)
      area <- 1 to num
    } yield GeometricObjectQuote(GeometricObject(shape, color, material, area), area * 0.02)

  def offer4(num:Int) =
    for {
      shape <- Shape.values
      color <- Color.values
      material <- Material.values if !Seq(Paper, Plastic, Ceramic).contains(material)
      area <- 1 to num
    } yield GeometricObjectQuote(GeometricObject(shape, color, material, area), area * 0.03)

}
object RepositorySmall extends Repository {

  def demand(num: Int = 0): List[GeometricObject] = {
    List(
      GeometricObject(Circle, Blue, Glass, 10),
      GeometricObject(Circle, Blue, Glass, 10),
      GeometricObject(Circle, Blue, Metal, 20),
      GeometricObject(Circle, Blue, Paper, 12)
    )
  }

  def offers(num:Int = 0) = Map(1 -> offer1, 2 -> offer2, 3 -> offer3)

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
