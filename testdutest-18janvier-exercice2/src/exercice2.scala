import scala.io.StdIn

object exercice2 {
  /*
  - VOTRE CODE DOIT COMMENCER JUSTE APRES CE COMMENTAIRE -
  N'effacez ou ne modifiez rien au-dessus de ce commentaire
  */

  /*
  Rédigez la déclaration de la classe demandée dans l'énoncé
  et utilisez la dans la méthode game pour réaliser le jeu.
  DEBUT de la déclaration de la classe >>
  */
  class Pion(var couleur:String="noir", var force:Int=0){

    // METHODE AFFICHE
    def affiche:Unit={
      println("couleur: "+couleur+", "+"force: "+force)
    }

    // METHODE CHOIX COULEUR
    def choixCouleur(parametre:String):Unit={
      couleur = parametre
    }

    // METHODE CHANGE
    def change(tour:Int):Unit={
      if ((couleur=="noir") && (tour%2==0)){couleur="blanc"}
      else if ((couleur=="noir")&& (!(tour%2==0))){couleur="noir"}
      else if ((couleur=="blanc")&& (!(tour%2==0))){couleur="noir"}
      else if ((couleur=="blanc")&& (tour%2==0)){couleur="blanc"}
    }

    // METHODE MANGE
    def mange(Pion:Pion):Unit={
      if (Pion.couleur==couleur)
      {if (couleur=="noir"){couleur="blanc"
      force+=1}
      else{couleur="noir"
      force-=1}
      }
    }
    //MON COMMENTAIRE : FIN DE LA DECLARATION DE LA CLASS
  }


  /*
  << FIN de la déclaration de la classe
  */


  def game(): Unit = {
    /*
    REDIGEZ LE CODE DU JEU DANS LA METHODE game :
    */
    var tour = 0

    // CREATION DES 2 PIONS
var pionprogramme = new Pion
    var pionjoueur = new Pion

    // CHOIX DES COULEURS POUR CHACUN DES PIONS
    var choix = StdIn.readLine("Quelle est la couleur initiale du pion du jeu ? ")
    pionprogramme.choixCouleur(choix)
    // POUR TEST println("Couleur du pion du programme "+pionprogramme.couleur)
    choix = StdIn.readLine("Quelle est la couleur initiale de votre pion ? ")
    pionjoueur.choixCouleur(choix)
    // POUR TEST  println("Couleur du pion du joueur "+pionjoueur.couleur)

    var manger = ""
    var changer = ""

while ((tour<5) && (pionjoueur.force<2)){
  tour+=1
  println("Tour "+tour)
  manger = StdIn.readLine("Voulez-vous manger le pion du jeu ? (o/n) ")

  if (manger=="o"){pionjoueur.mange(pionprogramme)
  print("Situation de votre pion; ")
    pionjoueur.affiche}

  if (pionjoueur.force<2) {changer = StdIn.readLine("Voulez-vous changer la couleur de votre pion ? (o/n) ")
  if (manger=="o"){pionjoueur.change(tour)
    // DEBUT TEST
    /*
    print("Situation de votre pion ; ")
    pionjoueur.affiche
     */
  // FIN TEST
  }}

  pionprogramme.change(tour)
  // DEBUT TEST
  /*
  println("La couleur du pion du programme est maintenant "+pionprogramme.couleur+".")
  */
  // FIN TEST
}
    if (tour==5) {println("Vous avez perdu !")} else println("Vous avez gagné en "+tour+" tours.")

  }






  /*
  - VOTRE CODE DOIT SE TERMINER JUSTE AVANT CE COMMENTAIRE
  N'effacez ou ne modifiez rien après ce commentaire
   */
  def main(args: Array[String]): Unit = {
    /*
    Pour l'examen, vous ne DEVEZ PAS écrire votre code ici
    */
    game()
  }
}