import scala.io.StdIn._

object exercice1 {

  def tocode(sommeinitiale: Double, n:Int): Object = {
    var somme = 0.0
    var interets = 0.0
    var remboursement = 0.0
    // A ce niveau:
    // La variable n est déjà déclarée et initialisée avec une valeur saisie au clavier
    // La variable sommeinitiale est déjà déclarée et initialisée avec une valeur saisie au clavier
    // Les variables somme, remboursement et interets sont déjà déclarées et initialisées à 0.0
    // Vous pouvez directement utiliser ces variables pour résoudre l'exercice ci-après
    // DEBUT DE VOTRE CODE CI-DESSOUS - ne rien changer ou supprimer avant cette ligne

    val tauxdinteret = 0.05
    somme = sommeinitiale
    remboursement = somme/(n*12)

    // println("Valeur du remboursement mensuel fixe de "+remboursementmensuel+ " CHF.")

    while (somme>0) {
      //println("Montant dû "+somme+" CHF.")
      interets+=(somme*tauxdinteret)
      //println("Intéret payé de "+somme*tauxdinteret+" CHF.")
      //println("Intéret total de "+interets+" CHF.")
      somme-=remboursement
      // println("Le montant dû après le remboursement est de"+somme+" CHF.")
    }

    //  FIN DE VOTRE CODE - ne rien changer ou supprimer après cette ligne
    //  L'affichage du résultat des intérêts est déjà rédigée ci-dessous, vous n'avez pas à le faire
    println("Après "+n+" années, le montant des intérêts à rembourser est de "+interets.round +".")
    interets.round.asInstanceOf[Object]
  }

  def main(args: Array[String]): Unit = {
    // Pour l'examen vous NE DEVEZ PAS REDIGER VOTRE CODE ICI
    tocode(readLine("Montant initial de la somme prêtée ? > ").toDouble,readLine("Nombre d'années ? > ").toInt)
  }
}