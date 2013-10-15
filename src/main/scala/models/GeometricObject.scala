package models


case class GeometricObject(shape: Shape, color: Color, material: Material, area: Long)

case class GeometricObjectQuote(geometricObject:GeometricObject, price:Double)
