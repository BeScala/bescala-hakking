package models


case class GeometricObject(shape: Shape, color: Color, material: Material, area: Double)

case class GeometricObjectQuote(geometricObject:GeometricObject, price:Double)
