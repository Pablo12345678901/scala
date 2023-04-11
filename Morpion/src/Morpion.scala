import javax.xml.transform.OutputKeys
import scala.io.StdIn.readLine
import scala.io.StdIn.readInt

/*
Écrire un programme qui permet à deux utilisateurs de jouer au jeu du Morpion
(Tic-tac-toe) https://fr.wikipedia.org/wiki/Tic-tac-toe.
Le jeu se joue tour à tour.
Il est basé sur une grille de taille 3 par 3.
Chaque joueur, chacun à leur tour, doit entrer dans une case de la grille le
symbole qui leur est attribué : O ou X.
Le gagnant est celui qui arrive à aligner trois symboles identiques, horizontalement,
verticalement ou en diagonale.
Il est possible qu’aucun des joueurs ne gagne. Une fois que la grille est complète (aucun
coup possible) ou qu'un joueur gagne, le programme devra afficher un message :
"Fin de Partie : Joueur ... a gagné" ou alors "Fin de Partie : Match nul".
Vous devez utiliser des méthodes pour écrire ce programmeC
*/

//PARTIE TEST DU CODE BUG

object Morpion {


  //Méthode définissant qui commence ?
  /* def quiCommence() = {
    val nomjoueur1 = readLine("Joueur 1, quel est votre nom ?")
    val nomjoueur2 = readLine("Joueur 2, quel est votre nom ?")
    val nomdesjoueurs = Array(nomjoueur1, nomjoueur2)
    var random = (math.random * 2).toInt
    var premierjoueur = nomdesjoueurs(random)
    var deuxiemejoueur = nomdesjoueurs(1 - random)
    val joueurs = (premierjoueur, deuxiemejoueur)
    println("Le joueur " + premierjoueur + " commence et aura le symbôle X")
    println("Le joueur " + deuxiemejoueur + " jouera ensuite et aura le symbôle 0.")
    val symbole = Array("X", "O")
  }
*/

  //Méthode définissant la grille
  /*  def creationgrille():Unit = {
    var grille =Array.fill(3,3)("*")
    var k = grille.size-1
while (!(k==(-1)))
{for (i <- 0 to grille.size - 1) {
  print(grille(i)(k) + "  ")
  if (i ==(grille.size-1))
  {k-=1
    println}
  }}}
*/

  //Méthode définissant la saisie des coordonnées
  /*
  def coordonneestest():Unit = {
    println("Veuillez saisir les coordonnées du coup que vous souhaitez jouer")
    var axex = -1
    var axey = -1
      println("Quel sera la coordonnée x entre 1 et 3 de votre coup ?")
      axex = readInt()-1
  while ((axex<0)||(axex>2))
  {println("Ce nombre n'est pas entre 1 et 3. Veuillez ressaisir une autre coordonnée x entre 1 et 3.")
    axex = readInt()-1}
    println("Quel sera la coordonnée y entre 1 et 3 de votre coup ?")
    axey = readInt()-1
    while ((axey<0)||(axey>2))
    {println("Ce nombre n'est pas entre 1 et 3. Veuillez ressaisir une autre coordonnée y entre 1 et 3.")
      axey = readInt()-1}
    }
  */

  /*  //Méthode définissant le contrôle des coordonnées
  def controlecoordonnee():Unit = {
    grille(axex)(axey)=="*"

  }
*/


  //Méthode définissant le contrôle d'un alignement de 3 symbôles identiques
  /*def nomDeLaMethode(arg1:Type1, arg2:Type2...):typeDuResultat = {
    expressions
      [return] resultat
  }
  */


  def main(args: Array[String]): Unit = {

    // Qui commence ?
    val nomjoueur1 = readLine("Joueur 1, quel est votre nom ?")
    val nomjoueur2 = readLine("Joueur 2, quel est votre nom ?")
    val nomdesjoueurs = Array(nomjoueur1, nomjoueur2)
    var random = (math.random * 2).toInt
    var premierjoueur = nomdesjoueurs(random)
    var deuxiemejoueur = nomdesjoueurs(1 - random)
    val joueurs = (premierjoueur, deuxiemejoueur)
    println("Le joueur " + premierjoueur + " commence et aura le symbôle X")
    println("Le joueur " + deuxiemejoueur + " jouera ensuite et aura le symbôle 0.")
    val symbole = Array("X", "O")


    var grille = Array.fill(3, 3)("*")
    var gagne = false
    var tour = 0

    //Affichage grille
    var k = grille.size - 1
    while (!(k == (-1))) {
      for (i <- 0 to grille.size - 1) {
        print(grille(i)(k) + "  ")
        if (i == (grille.size - 1)) {
          k -= 1
          println
        }
      }
    }


    // Le jeu continue tant que les 9 cases ne sont pas remplies où qu'aucun joueur n'a gagné.
    while ((gagne == false) && (tour < 9)) {

      // Demande des coordonnées pour le coup.
      println("Veuillez saisir les coordonnées du coup que vous souhaitez jouer")
      var axex = -1
      var axey = -1
      println("Quel sera la coordonnée x entre 1 et 3 de votre coup ?")
      axex = readInt() - 1
      while ((axex < 0) || (axex > 2)) {
        println("Ce nombre n'est pas entre 1 et 3. Veuillez ressaisir une autre coordonnée x entre 1 et 3.")
        axex = readInt() - 1
      }
      println("Quel sera la coordonnée y entre 1 et 3 de votre coup ?")
      axey = readInt() - 1
      while ((axey < 0) || (axey > 2)) {
        println("Ce nombre n'est pas entre 1 et 3. Veuillez ressaisir une autre coordonnée y entre 1 et 3.")
        axey = readInt() - 1
      }


      // Contrôle si case est occupée
      if (grille(axex)(axey) == "*") {
        if (tour % 2 == 0) {
          grille(axex)(axey) = "X"
        }
        else {
          grille(axex)(axey) = "O"
        }
        tour += 1


        // Affichage grille
        var k = grille.size - 1
        while (!(k == (-1))) {
          for (i <- 0 to grille.size - 1) {
            print(grille(i)(k) + "  ")
            if (i == (grille.size - 1)) {
              k -= 1
              println
            }
          }
        }
      }
      else {
        println("Cette est déjà occupée. Ressaissez de nouvelles coordonnées.")
      }


      // Contrôle si un des joueurs a gagné. = 4 tests : colonnes, lignes et diagonales et le big test final.

      // test colonne

      // test ligne

      // test diagonale

      // big test final

      //FIN DU WHILE
    }
    //Si toutes les cases sont remplies, alors fin du jeu + match nul.
    if (tour == 9) {
      println("Fin du jeu : match nul.")
    }

  }
}
