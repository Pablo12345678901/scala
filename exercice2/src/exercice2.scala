import scala.io.StdIn._

object exercice2 {

  def tocode(): Unit = {
    val Array(tresor_X,tresor_Y,essais) = readLine("Indiquez les coordonnées x et y de l'île au trésor et le nombre max d'essais autorisés, séparés par des virgules > ").split(",").map(_.toInt)
    var bateau_X = 0
    var bateau_Y = 0
    var tentative = 0
    var deplacement = ' '
    var gagne = false
    var deplacementok = false
    // A ce niveau
    // La variable essais est déjà déclarée et initialisée avec une valeur saisie au clavier. Elle ne peut pas être modifiée.
    // Les variables tresor_X and tresor_Y sont déjà déclarées et initialisées avec une valeur saisie au clavier. Elles ne peuvent pas être modifiées
    // Pour calculer la distance entre a(a_X,a_Y) et b(b_X,b_Y), vous devez utiliser la formule:
    //    (math.sqrt( math.pow(a_X - b_X,2) + math.pow(a_Y - b_Y,2) )).toInt
    // Les variables bateau_X et bateau_Y sont déjà déclarées et initialisées à 0
    // Les variables tentative et deplacement sont déjà déclarées et initialisées à 0 et ' '
    // La variable gagne déjà déclarée doit prendre la valeur true quand le joueur gagne et peut ensuite être testée si besoin
    // La variable deplacementok déjà déclarée doit prendre la valeur true si le déplacement courant est possible et peut ensuite être testé si besoin
    // Vous pouvez directement utiliser ces variables pour résoudre l'exercice ci-après
    // DEBUT DE VOTRE CODE CI-DESSOUS - ne rien changer ou supprimer avant cette ligne

    var essaiseffectues = 0


    var D = 0
    while (essaiseffectues<essais)
      {print("Déplacement ? ")
        deplacement = readChar()
        /*
        h pour haut > y+1
        b pour bas > y-1
        g pour gauche > x-1
        d pour droite > x+1
        */


        if ((deplacement=='h') && ((bateau_Y+1)<100))
        {
          bateau_Y+=1

          // /*
          // println("X = "+bateau_X+", Y = "+bateau_Y+" et le trésor se trouve à X = "+tresor_X+" Y = "+tresor_Y+".")
          essaiseffectues+=1
          // println("Nombre d'essai total = "+essais+".")
          // println("Nombre d'essai effectué = "+essaiseffectues+".")
          // */

          if ((bateau_X==tresor_X ) && (bateau_Y==tresor_Y))
          {println("Bravo, vous avez gagné")
            essaiseffectues=essais}
          else {
            if (essaiseffectues<essais)
              {D = (math.sqrt(math.pow(bateau_X-tresor_X,2)+math.pow(bateau_Y-tresor_Y,2))).toInt
                println("Vous êtes à "+D+ " de l’île au trésor")

              }
            else {println("Vous avez perdu, l’île se trouvait à "+tresor_X+","+tresor_Y+".")

            }
          }
        }


        else if ((deplacement=='b') && ((bateau_Y-1)>(-1)))
        {
          bateau_Y-=1

          // /*
          // println("X = "+bateau_X+", Y = "+bateau_Y+" et le trésor se trouve à X = "+tresor_X+" Y = "+tresor_Y+".")
          essaiseffectues+=1
          // println("Nombre d'essai total = "+essais+".")
          // println("Nombre d'essai effectué = "+essaiseffectues+".")
          // */

          if ((bateau_X==tresor_X ) && (bateau_Y==tresor_Y))
          {println("Bravo, vous avez gagné")
            essaiseffectues=essais}
          else {
            if (essaiseffectues<essais)
            {D = (math.sqrt(math.pow(bateau_X-tresor_X,2)+math.pow(bateau_Y-tresor_Y,2))).toInt
              println("Vous êtes à "+D+ " de l’île au trésor")

            }
            else {println("Vous avez perdu, l’île se trouvait à "+tresor_X+","+tresor_Y+".")

            }
          }
        }


        else if ((deplacement=='d') && ((bateau_X+1)<100))
        {
          bateau_X+=1

          // /*
          // println("X = "+bateau_X+", Y = "+bateau_Y+" et le trésor se trouve à X = "+tresor_X+" Y = "+tresor_Y+".")
          essaiseffectues+=1
          // println("Nombre d'essai total = "+essais+".")
          // println("Nombre d'essai effectué = "+essaiseffectues+".")
          // */

          if ((bateau_X==tresor_X ) && (bateau_Y==tresor_Y))
          {println("Bravo, vous avez gagné")
            essaiseffectues=essais}
          else {
            if (essaiseffectues<essais)
            {D = (math.sqrt(math.pow(bateau_X-tresor_X,2)+math.pow(bateau_Y-tresor_Y,2))).toInt
              println("Vous êtes à "+D+ " de l’île au trésor")

            }
            else {println("Vous avez perdu, l’île se trouvait à "+tresor_X+","+tresor_Y+".")

            }
          }
        }


        else if ((deplacement=='g') && ((bateau_X-1)>(-1)))
        {
          bateau_X-=1

          // /*
          // println("X = "+bateau_X+", Y = "+bateau_Y+" et le trésor se trouve à X = "+tresor_X+" Y = "+tresor_Y+".")
          essaiseffectues+=1
          // println("Nombre d'essai total = "+essais+".")
          // println("Nombre d'essai effectué = "+essaiseffectues+".")
          // */

          if ((bateau_X==tresor_X ) && (bateau_Y==tresor_Y))
          {println("Bravo, vous avez gagné")
            essaiseffectues=essais}
          else {
            if (essaiseffectues<essais)
            {D = (math.sqrt(math.pow(bateau_X-tresor_X,2)+math.pow(bateau_Y-tresor_Y,2))).toInt
              println("Vous êtes à "+D+ " de l’île au trésor")

            }
            else {println("Vous avez perdu, l’île se trouvait à "+tresor_X+","+tresor_Y+".")

            }
          }
        }


        else if ((deplacement=='h')  || (deplacement=='b') || (deplacement=='d')|| (deplacement=='g'))
          {println("Déplacement non autorisé")}

      }

    //  FIN DE VOTRE CODE - ne rien changer ou supprimer après cette ligne
  }

  def main(args: Array[String]): Unit = {
    // Pour l'examen vous NE DEVEZ PAS REDIGER VOTRE CODE ICI
    tocode()
  }
}
