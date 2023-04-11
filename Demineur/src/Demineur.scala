import scala.io.StdIn.readInt

object Demineur {
  def main(args: Array[String]): Unit = {

    /*

Vous allez devoir écrire un programme qui reproduit une version simple
du jeu du démineur.

Une grille de 20 x 20 cases remplie avec le caractère *
et 6 bombes dont la position est tirée aléatoirement et cachée au joueur.

Le joueur démarre le jeu avec 3 vies.

A chaque tour, le joueur indique quelle case il veut découvrir en
saisissant le numéro de la ligne et de colonne de la case:

Si la case est vide, elle est « découverte ».
Si la case est occupée par une bombe, il perd une vie,
et s'il n'a plus de vies, il a perdu.

Les bombes découvertes sont indiquées par le caractère @
La grille est affichée à chaque tour.
Les cases découvertes sont représentées par le caractère # si aucune des
cases adjacentes ne contient de bombes.

 */

    var matricecachee = Array.fill(20, 20)(".")

    var bombes = 0

    var x = 0
    var y = 0

    var w = 0
    var z = 0

    println()
    while (bombes < 6) {
      x = (math.random * 19).toInt
      y = (math.random * 19).toInt
      w = x + 1
      z = y + 1
      println("x = " + x + " + 1 = " + w + '\n' + "y = " + y + " + 1 = " + z + '\n')
      matricecachee(x)(y) = "@"
      //@ = bombe
      bombes += 1
      if (bombes == 6) {
        println()
      }
    }


    // besoin d'afficher x=0, y=0 suivi de x=1, y=0

    // /*
    // Donnera une matrice lisible comme une graphe de fonction x grandit vers la droite et y vers le haut.
    var k = matricecachee.size - 1

    while (!(k == (-1))) {
      for (i <- 0 to matricecachee.size - 1) {
        print(matricecachee(i)(k) + "  ")
        if (i == (matricecachee.size - 1)) {
          k -= 1
          println
        }
      }
    }


    // */

    /*
// Donnera une matrice classique x grandit vers droite et y vers bas
var k = 0
while (!(k==(matricecachee.size)))
    {for (i <- 0 to matricecachee.size - 1) {
        print(matricecachee(i)(k) + "  ")
        if (i ==(matricecachee.size-1))
        {k+=1
        println}
      }
    }
*/

    var matricevisible = Array.fill(20, 20)(".")
    var vies = 3

    while (vies > 0)
    {k = matricevisible.size - 1

      println("Quelle sera la coordonnées x (entre 1 et 20) de la valeur test ?")
      var testx = (readInt() - 1)
      println("Quelle sera la coordonnées y (entre 1 et 20) de la valeur test ?")
      var testy = (readInt() - 1)


      if (matricecachee(testx)(testy) == "@") {
        matricevisible(testx)(testy) = "@"
        vies -= 1
        println("Vous avez touché une bombe et perdez une vie. Il vous reste " + vies + " vie(s).")
        if (vies == 0) {
          println("Comme vous n'avez plus de vies, vous avez perdu.")
        }
      else {
        for (c <- -1 to 1; d <- -1 to 1) {
          if ((testx + c > (-1)) && (testx + c < 20) && (testy + d > (-1)) && (testy + d < 20)) {
            if (!(matricecachee(testx + c)(testy + d) == "@")) {
              matricevisible(testx + c)(testy + d) = "#"
            }
          }
        }
        println("Voici les cases découvertes : " + '\n')
        while (!(k == (-1))) {
          for (i <- 0 to matricevisible.size - 1) {
            print(matricevisible(i)(k) + "  ")
            if (i == (matricevisible.size - 1)) {
              k -= 1
              println
            }
          }
        }
      }
    }


    else
    {
      matricevisible(testx)(testy) = "#"
      for (c <- -1 to 1; d <- -1 to 1) {
        if ((testx + c > (-1)) && (testx + c < 20) && (testy + d > (-1)) && (testy + d < 20)) {
          if (!(matricecachee(testx + c)(testy + d) == "@")) {
            matricevisible(testx + c)(testy + d) = "#"
          }
        }
      }
      println("Voici les cases découvertes : " + '\n')
      while (!(k == (-1))) {
        for (i <- 0 to matricevisible.size - 1) {
          print(matricevisible(i)(k) + "  ")
          if (i == (matricevisible.size - 1)) {
            k -= 1
            println
          }
        }
      }
    }
  }

        }


        }
