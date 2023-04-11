import scala.io.StdIn.readLine

object Divination {
  def main(args: Array[String]): Unit = {
    /*Étude & Énoncé: Divination

  Dans un premier temps, effectuez une étude cas, décrivez les
  variables et les structures que vous allez utiliser. Puis,*/


    /*Vous allez devoir écrire un programme qui choisit au hasard
    un nombre entre 0 et 20*/

    var n = math.random
    // println(n)
    n = 20 * n
    // println(n)
    var nombrealeatoire= n.toInt
    // println(nombrealeatoire)
    if (nombrealeatoire == 0) {
      nombrealeatoire += 1
    }
     // println(nombrealeatoire)

    /* et propose à l'utilisateur de le
  deviner en décomptant les essais. Si l'utilisateur arrive
  à plus de 6 essais, il/elle a perdu.*/

    var nombretest = readLine("Devinez le nombre entre 1 et 20 choisi par l'ordinateur. Vous avez 6 essais. Tapez un nombre >").toLong
    var essais = 6

    /*À chaque essai, le
  programme doit informer l'utilisateur si son entrée est
  plus grande ou plus petite que nombre à deviner.*/

    {
      while (essais>0) {
        if (nombretest == nombrealeatoire) {
          essais -= essais
          println("Vous avez trouvé le bon nombre qui était : " + nombrealeatoire + ".")
        }
        else {
          essais -= 1
          if (essais == 0) {
            println("Ce n'est pas " + nombretest + ". Dommage, il ne vous reste aucun essai : vous avez perdu. Le nombre était : " + nombrealeatoire + ".")
          }
          else if (nombretest > nombrealeatoire) {
            println("Le nombre que vous avez choisi est plus grand que le nombre choisi par l'ordinateur.")
            nombretest = readLine("Il vous reste " + essais + " essais. Essayez un autre nombre entre 1 et 20. >").toLong
          }
          else {
            println("Le nombre que vous avez choisi est plus petit que le nombre choisi par l'ordinateur.")
            nombretest = readLine("Il vous reste " + essais + " essais. Essayez un autre nombre entre 1 et 20. >").toLong
          }
        }
      }
    }
    }
}
