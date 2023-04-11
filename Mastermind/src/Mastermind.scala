import scala.io.StdIn.readLine

object Mastermind {
  def main(args: Array[String]): Unit = {

    /*
    Vous allez devoir écrire un programme qui génère une suite
    de 3 couleurs que l'utilisateur doit ensuite deviner.
    L'utilisateur a 8 essais pour trouver la combinaison. A
    chaque entrée d'une couleur, le programme indique, pour
    chaque couleur si elle est correcte, si elle existe mais
    elle n'est pas à la bonne place, ou si c'est une erreur.
     */

    //Génération de 3 couleurs

    var listecouleur = Array("bleu","jaune","rouge","violet","noir","blanc", "beige", "doré", "argenté")
    var mastermind = Array("-", "-", "-")
    var couleur = "-"
    for (i <- 0 to (mastermind.size) - 1) {
      couleur = listecouleur((listecouleur.size * math.random).toInt)
      mastermind(i) = couleur
      listecouleur = listecouleur.filter(x => (!(x == couleur)))
    }
    println(mastermind.mkString(", "))

    var essai = 0
    var reponsecorrecte = 0

    // Choix des couleurs par l'utilisateur

    var couleur1 = readLine("Chosir la couleur n°1 (écrire en minuscule).")
    var couleur2 = readLine("Chosir la couleur n°2 (écrire en minuscule).")
    var couleur3 = readLine("Chosir la couleur n°3 (écrire en minuscule).")

    var tableautest = Array(couleur1,couleur2,couleur3)

    // Test
    // 1 = couleur correcte + bonne place ?
    // 2 = couleur correcte mais pas bonne place ?
    // sinon mauvaise couleur

while ((reponsecorrecte<3) && (essai < 8))
    {for (i <- 0 to (mastermind.size-1))

    if (mastermind(i) == tableautest(i))
    {println("La couleur " + tableautest(i) + " est à la bonne place.")
        reponsecorrecte += 1
      if (reponsecorrecte==3) {println("Vous avez gagné.")}}

      else if (mastermind.contains(tableautest(i)))
    {println("La couleur " + tableautest(i) + " est présente mais n'est pas à la bonne place.")
      reponsecorrecte = 0}

    else {println("La couleur " + tableautest(i) + " n'est pas présente dans le tableau.")
      reponsecorrecte = 0}

      essai += 1
      if ((reponsecorrecte<3) && (essai<8))
      {println("Il vous reste " + (8 - essai) + " essai(s).")
      couleur1 = readLine("Réessayez : chosissez une nouvelle couleur n°1 (écrire en minuscule).")
      couleur2 = readLine("Réessayez : chosissez une nouvelle couleur n°2 (écrire en minuscule).")
      couleur3 = readLine("Réessayez : chosissez une nouvelle couleur n°3 (écrire en minuscule).")
        tableautest = Array(couleur1,couleur2,couleur3)}
      else if ((reponsecorrecte<3) && (essai == 8))
      {println("Il ne vous reste aucun essai. Vous avez perdu. Les couleurs étaient "+mastermind(0)+", "+mastermind(1)+", "+mastermind(2)+".")}




    }


}

}
