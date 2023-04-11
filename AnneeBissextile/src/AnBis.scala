import io.StdIn.readLine

object AnBis {
  def main(args: Array[String]): Unit = {
    val annee = readLine("Bissextile ou non ? Veuillez saisir un numéro d'année. > ").toInt
    //"si l'année est divisible par 4 et non divisible par 100, ou
    if (((annee%4==0) && !(annee%100==0)) || (annee%400==0)) {
      println("L'année "+annee+" est bissextile.")
    } else {
        println("L'année "+annee+" n'est pas bissextile.")
    }
    val b = annee%9
    println(b)
    //Sinon, l'année n'est pas bissextile (elle a 365 jours)."

  }

}
