import scala.io.StdIn.readLine

object Combien {
  def main(args: Array[String]): Unit = {
    /*
    Production de code : Combien ?
    Vous allez écrire un programme qui permet
    de trouver si un tableau d'entiers contient
    une valeur saisie au clavier. Si le tableau
    contient la valeur, le programme devra
    indiquer le nombre de fois que la valeur est
    contenue dans le tableau. Si la valeur n'est
    pas contenue dans le tableau, le programme
    indiquera la valeur 0.

    Le programme devra commencer par la saisie du
    nombre de valeurs du tableau et la saisie des
    valeurs.
     */

    var tailletableau = readLine("Combien de cellules contient le tableau ?").toInt
    val tableau = Array.fill(tailletableau)(0)
     var numerocellule = 1
    for (index <- 0 to tableau.size-1) {tableau(index) = readLine("Choisissez la " +
      "valeur d'un nombre entier pour la "+numerocellule+" cellule du tableau.").toInt
       numerocellule+=1
    }

    val nombretest = readLine("Choisissez un nombre entier et le programme vous " +
      "retournera le nombre d'occurence(s) de ce nombre dans les cellules du tableau. >").toInt

    var nombredoccurence = 0

    for(index <- 0 to tableau.size-1) if (tableau(index)==nombretest) {nombredoccurence+=1}
    println("Il y a "+nombredoccurence+" occurence(s) du nombre entier "+nombretest+" dans le tableau.")
  }
}
