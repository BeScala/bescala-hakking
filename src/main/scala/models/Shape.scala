package models

sealed trait Shape {
  override def toString = getClass.getSimpleName
}
object Shape {
  def values = List(Square, Rectangle, Triangle, Circle, Ellipse)
}
object Square extends Shape
object Rectangle extends Shape
object Triangle extends Shape
object Circle extends Shape
object Ellipse extends Shape