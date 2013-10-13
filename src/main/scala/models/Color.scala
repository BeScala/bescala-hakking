package models

sealed trait Color {
  override def toString = getClass.getSimpleName
}
object Color {
  def values = List(Red, Orange, Yellow, Green, Blue, White, Black)
}
object Red extends Color
object Orange extends Color
object Yellow extends Color
object Green extends Color
object Blue extends Color
object White extends Color
object Black extends Color
