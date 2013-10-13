package models

sealed trait Material {
  override def toString = getClass.getSimpleName
}

object Material {
  def values = List(Glass, Wood, Metal, Paper, Plastic, Ceramic)
}

object Glass extends Material
object Wood extends Material
object Metal extends Material
object Paper extends Material
object Plastic extends Material
object Ceramic extends Material
