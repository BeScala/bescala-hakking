package utils

import models.GeometricObjectQuote
import models.GeometricObject
import models.Circle
import models.Blue
import models.Glass
import models.Paper
import models.Metal
import models.Ceramic

object Data {
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