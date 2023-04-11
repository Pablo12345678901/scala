import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn.readLine
import scala.io.StdIn.readChar
import scala.io.StdIn.readDouble
import scala.io.StdIn.readInt

object CaisseEnregistreuse {
  def main(args: Array[String]): Unit = {

    /*
    Vous allez devoir écrire un programme qui simule une caisse enregistreuse.
    Le programme propose une invite de commande qui supporte :

    a : entrée d'un achat
    q : quitter la caisse
    i : afficher tous les achats
    s : sommer l'argent de la caisse
    c : effectuer un crédit (raison et montant)
    p : effectuer un pourcentage de réduction sur un article de la caisse

    Chaque article doit être entré avec son prix. Les achats et leur prix
    doivent être contenus dans des tableaux dynamiques.
     */

    var listeachat = ArrayBuffer[String]()
    var listeprix = ArrayBuffer[Double]()
    var nomdarticle = ""
    var total = 0.0
    var prix = 0.0


    println("Que souhaiteriez-vous faire ? Tapez : " + '\n' + "a : entrée d'un achat" + '\n' + "q : quitter la caisse" + '\n' + "i : afficher tous les achats" + '\n' + "s : sommer l'argent de la caisse" + '\n' + "c : effectuer un crédit (raison et montant)" + '\n' + "p : effectuer un pourcentage de réduction sur un article de la caisse")
    var bouton = readChar()
    while (!(bouton == 'q'))
    {if (bouton == 'a') {
        nomdarticle = readLine("Quel est le nom du produit.")
        listeachat += nomdarticle
        println("Quel est son prix ?")
        prix = readDouble()
        listeprix += prix
      }

      else if (bouton == 'i') {
        for (i <- 0 to (listeachat.size - 1)) {
          println(listeachat(i) + " " + listeprix(i) + " CHF")
        }
      }

      else if (bouton == 's') {
        total = listeprix.sum
        println("Total = " + total + " CHF.")
      }


      /// A FAIRE
      else if (bouton == 'c') {
        // dmd nom produit
        // dmd prix
        // si nom produit existe pas > le dire
        // sinon produit existe et
        // si prix correspond > retirer produit + prix
        // sinon prix ne correspond pas > le dire
        // fin 1er si
        // fin 2eme si

        nomdarticle = readLine("Quel est le nom du produit.")
        if (!(listeachat.contains(nomdarticle))) {
          println("Ce produit ne figure pas dans la liste des achats.")
        }
        else {
          println("Quel est son prix ?")
          prix = readDouble()
          var prixetarticlejuste = 0
          if (!(listeprix.contains(prix))) {
            println("Ce produit figure dans la liste des achats mais son prix ne correspond pas.")
          }
          else if (prixetarticlejuste == 0) {
            for (i <- 0 to listeachat.size - 1) if ((nomdarticle == listeachat(i)) && prix == listeprix(i)) {
              listeprix -= listeprix(i)
              listeachat -= listeachat(i)
              prixetarticlejuste += 1
            }
          }

          if ((listeachat.contains(nomdarticle)) && (listeprix.contains(prix)) && ((prixetarticlejuste == 0))) {
            println("Ce produit figure dans la liste des achats mais son prix ne correspond pas.")
          }
        }
    }


        else if (bouton == 'p') {
          nomdarticle = readLine("Quel est le nom du produit sur lequel vous souhaitez faire un rabais ?")
          if (listeachat.contains(nomdarticle)) {
            println("Quel rabais en pourcent (positif) souhaiteriez-vous appliquer ?")
            var rabais = readInt()
            for (i <- 0 to listeachat.size - 1)
              if (nomdarticle == listeachat(i))
                listeprix(i) = ((((listeprix(i) * (1 - ((rabais.toDouble) / 100)) * 100).toInt).toDouble) / 100)
          }
          else println("Ce produit n'est pas dans la liste des achats.")
        }
        println("Que souhaiteriez-vous faire ? Tapez : " + '\n' + "a : entrée d'un achat" + '\n' + "q : quitter la caisse" + '\n' + "i : afficher tous les achats" + '\n' + "s : sommer l'argent de la caisse" + '\n' + "c : effectuer un crédit (raison et montant)" + '\n' + "p : effectuer un pourcentage de réduction sur un article de la caisse")
        bouton = readChar()
    }
      if (bouton == 'q') {println("Vous quittez la caisse.")}

  }
}
