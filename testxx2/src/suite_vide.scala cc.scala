import scala.io.StdIn.readLine

object suite_vide {


  def tocode(m: Int): Object = {
    var n = m
    var serie = "La série est : "
 /*Vous devez travailler avec les variables n et serie.
m ne peut être modifié, d'où le besoin d'une autre variable (n). serie est la variable qui va contenir votre reponse.
 DEBUT DE VOTRE CODE - ne rien supprimer ou modifier au-dessus de ce commentaire */



// ***** FIN DE VOTRE CODE - ne rien supprimer ou modifier au-dessous de ce commentaire
    serie.asInstanceOf[Object]
  }

  /*
Pour l'examen, vous ne DEVEZ PAS rédiger votre code ici.
  Ne rien changer ci-dessous
   */
  def main(args: Array[String]): Unit = {
    println(tocode(readLine("Quelle est la valeur de départ de la série ? > ").toInt))
  }

}
