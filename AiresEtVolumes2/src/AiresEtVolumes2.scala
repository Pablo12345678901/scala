

object AiresEtVolumes2 {

  /*
    Vous allez rédiger un programme qui permet de réaliser les
    calculs de surface et de volume:
      d'un cylindre
      et d'un parallélépipède rectangle
    en utilisant des méthodes.
    Vous devez définir 4 méthodes différentes.
      Vous devez aussi tester vos méthodes directement dans le
      programme (pas besoin d'entrée clavier).
    */

def airecylindre(rayon:Double,hauteur:Double):Double = {
  println("Le rayon du cylindre vaut "+rayon)
  println("La hauteur du cylindre vaut "+hauteur)
  val resultat = (2*math.Pi*rayon)*(rayon+hauteur)
  println("L'aire du cylindre est de "+resultat)
  return resultat
}

def volumecylindre(rayon:Double,hauteur:Double):Double = {
  println("Le rayon du cylindre vaut "+rayon)
  println("La hauteur du cylindre vaut "+hauteur)
  val resultat = math.Pi*math.pow(rayon,2)*hauteur
  println("Le volume du cylindre est de "+resultat)
  return resultat
}

  def aireparallepipederectangle(hauteurr:Double,largeur:Double,longueur:Double):Double = {
    println("La hauteur du parallèpipède rectangle vaut "+hauteurr)
    println("La largeur du parallèpipède rectangle vaut "+largeur)
    println("La longueur du parallèpipède rectangle vaut "+longueur)
    val resultat = 2*((hauteurr*largeur)+(hauteurr*longueur)+(largeur*longueur))
    println("L'aire du parralèpipède rectangle est de "+resultat)
    return resultat
  }


  // def
  def volumeparallepipederectangle(hauteurr:Double,largeur:Double,longueur:Double):Double = {
    println("La hauteur du parallèpipède rectangle vaut "+hauteurr)
    println("La largeur du parallèpipède rectangle vaut "+largeur)
    println("La longueur du parallèpipède rectangle vaut "+longueur)
    val resultat = hauteurr*largeur*longueur
    println("Le volume du parralèpipède rectangle est de "+resultat)
    return resultat
  }


  def main(args: Array[String]): Unit = {

    var rayon = 2
    var hauteur = 5
    airecylindre(rayon,hauteur)
    println("")
    volumecylindre(rayon,hauteur)
    println("")
    var hauteurr = 5
    var largeur = 5
    var longueur = 5
    aireparallepipederectangle(hauteurr,largeur,longueur)
    println("")
    volumeparallepipederectangle(hauteurr,largeur,longueur)
    println("")



  }
}
