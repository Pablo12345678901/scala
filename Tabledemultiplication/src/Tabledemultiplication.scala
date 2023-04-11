import scala.io.StdIn.readLine

object Tabledemultiplication {
  def main(args: Array[String]): Unit = {
    var x = 1
    while (x<10)
      {println("Voici la table de "+x+".")
        for (i <- 1 to 10) {
        println(x*i)
      }
        println("")
        x+=1
      }
/*
Vous allez devoir écrire un programme qui
calcule et affiche les tables de multiplication
de 1 à 9. Le programme doit sauter une ligne
entre chaque table de multiplication.
 */
  }
}
