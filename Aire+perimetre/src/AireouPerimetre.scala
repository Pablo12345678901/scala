import scala.io.StdIn.readDouble

object AireouPerimetre {def main(args: Array[String]): Unit = {
  println("Voulez-vous peindre un cercle ou un rectangle ? Pour un cercle, tapez 1, pour rectangle, tapez 2.")
  val calcul = readDouble()
  if (calcul == 2) {
    println("Quelle est la longueur en mètre(s) ?")
    val longueur = readDouble()
    println("Quelle est la largeur en mètre(s)?")
    val largeur = readDouble()
    val airerectangle = longueur*largeur
    val perimetrerectangle = 2*(longueur+largeur)
    println("L'aire du rectangle est de "+airerectangle + " m2 et le périmètre du rectangle est de " + perimetrerectangle + " m.")
  } else if (calcul == 1) {
    println("Quelle est le rayon en mètre(s) ?")
    val rayon = readDouble()
    val airecercle = math.Pi *(rayon*rayon)
    val perimetrecercle = 2*math.Pi*rayon
    println("L'aire du cercle est de "+ airecercle + " m2 et le périmètre du cercle est de " + perimetrecercle + " m.")
  }
}

}
