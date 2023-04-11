import java.io.PrintWriter
import scala.io.{Source, StdIn}

object exercice2 {

  class Ewallet(var idclient: String,var codepin: Int, var argentdisponible: Double,var decouvertautorise: Double, var tauxdefrais: Double) {


    // Méthode pour la vérification de l'identifiant + code pin du client afin de gérer son portefeuille.
    def verifieClient(idclient_verif: String, codepin_verif: Int): Boolean = {
      // idclient_verif contient la valeur à comparer à la valeur d’identifiant du/de la client-e propriétaire du ewallet
      // codepin_verif contient la valeur à comparer à la valeur du code PIN du ewallet
      if ((idclient_verif == idclient) && (codepin_verif == codepin)) {
        return true
      }
      else {
        return false
      }
    }

    // Méthode pour la vérification de l'identifiant uniquement du client afin de savoir s'il existe déjà parmi les portefeuilles existants. S'il n'existe pas, la création d'un nouveau portefeuille se fera.
    def verifieIDuniquement(idclient_verif: String): Boolean = {

      if (idclient_verif == idclient) {
        return true
      }
      else {
        return false
      }
    }


    def operationDebit(montantadebiter: Double): Double = {
      // montantadebiter contient la valeur du montant à débiter.
      // La méthode renvoie la nouvelle valeur du montant disponible si l’opération a pu être réalisée. Elle renvoie la valeur NaN, (Not a Number)3 sinon.
      if (montantadebiter * (1 + tauxdefrais) <= (argentdisponible + decouvertautorise)) {
        argentdisponible -= (montantadebiter * (1 + tauxdefrais))
        println("Opération effectuée : Votre solde disponible restant est de " + argentdisponible)
        return argentdisponible
      }
      else {
        println("L'opération n'a pas pu être effectuée (solde insuffisant). Votre solde est de " + argentdisponible)
        return Double.NaN
      }
    }

    def operationCredit(montantacrediter: Double): Double = {
      // montantacrediter contient la valeur du montant à créditer.
      // La méthode renvoie la nouvelle valeur du montant disponible sur le e-wallet.
      argentdisponible += (montantacrediter * (1 - tauxdefrais))
      println("Opération effectuée : Votre solde disponible restant est de " + argentdisponible)
      return argentdisponible
    }

    def afficheVerif : Unit={
      println("Code pin : "+codepin)
      println("Montant disponible : "+argentdisponible)
    }


    def affiche : Unit ={
    println("Identifiant : "+idclient)
    println("Code pin : "+codepin)
    println("Argent disponible : "+argentdisponible)
    println("Découvert autorisé : "+decouvertautorise)
    println("Taux de frais : "+tauxdefrais+'\n')
  }


  }
// FIN de la class Ewallet

  def menu: Int = {
    println("MENU" + '\n' +
      "1. Créer un porte-monnaie" + '\n' +
      "2. Accéder à son porte-monnaie" + '\n' +
      "3. Quitter le programme" + '\n'
      + "Entrez votre choix :")
    var option = StdIn.readInt()
    return option
  }



def lireEwallet() : Array[Ewallet] = {
  // La methode renvoie un tableau qui contient la liste des ewallets lu depuis le fichier ewallet.txt
  var listedesportefeuilles = new Array[Ewallet](50)
  try {
    val contenufichierexistant = Source.fromFile("ewallet.txt").getLines.toArray
    for (i <- 0 to contenufichierexistant.size - 1) {
      var caracteristique = contenufichierexistant(i).split(",")
      var portefeuilleaajouter = new Ewallet(caracteristique(0),caracteristique(1).toInt,caracteristique(2).toDouble,caracteristique(3).toDouble,caracteristique(4).toDouble)
      listedesportefeuilles(i)=portefeuilleaajouter
    }
  }catch {
    case _=> {
      val redactiondufichier = new PrintWriter("ewallet.txt" )
      redactiondufichier.close()
    }
  }
  return listedesportefeuilles
}


  def sauverEwallet(listeEwallet : Array[Ewallet]): Unit = {
    // listeEwallet : tableau des Ewallet des clients à sauvegarder dans le fichier ewallet.txt
    val redactionnvofichier = new PrintWriter("ewallet.txt")

    for(i <- listeEwallet){
      //
      if (!(i==null)){
      var caracteristiques =i.idclient+","+ i.codepin+","+i.argentdisponible+","+ i.decouvertautorise+","+ i.tauxdefrais+"\n"
        redactionnvofichier.print(caracteristiques)
        // Println ci-dessous à des fins de test pour contrôler ce que le programme sauve dans le fichier txt.
        // println(caracteristiques)
        }
      //
  }
    redactionnvofichier.close()
    }





  def main(args: Array[String]): Unit = {


    // APPEL METHODE LECTURE > Création du portemonnaie + implémentation du contenu depuis le fichier existant, s'il y a.
    val ewallets = lireEwallet()

    var nbdeportemonnaie = 0



    // Besoin adapter le nombre de portemonnaies en fonction du nombre déjà existant si le fichier txt est rempli.
    // Comptage du nombre de portemonnaies existants.
    for(i <- ewallets){
      //
      if (!(i==null)){
        nbdeportemonnaie+=1
      }
      //
    }

    //
    println("Nombre de portemonnaies déjà existants : "+nbdeportemonnaie+"\n")





// DEBUT PROGRAMME


    var choix = 0
    var idclient = ""
    var idclient_verif = ""
    var codepin = 0
    var codepin_verif = 0
    var argentdisponible = 0.0
    var decouvertautorise = 500.0
    var tauxdefrais = 0.03
    var montantadebiter = 0.0
    var montantacrediter = 0.0









    while (!(choix == 3)) {
      choix = menu


      if (choix == 1) {
        var testexistant = false
        idclient_verif = StdIn.readLine("Quel est votre identifiant ?")
        if (nbdeportemonnaie > 0) {
          for (i <- 0 to nbdeportemonnaie - 1) {
            if (ewallets(i).verifieIDuniquement(idclient_verif))
              {
              testexistant = true
            println("Cet identifiant est déjà attribué à un portefeuille existant. Vous ne pouvez pas créer d'autre portefeuille.")
          }
          }
        }


        if (!testexistant) {
          idclient = idclient_verif

          codepin = (math.random * 100000).toInt
          while (codepin < 100) {
            codepin = (math.random * 100000).toInt
          }

          println("Quel sera le montant initial sur le portemonnaie ?")
          argentdisponible = StdIn.readDouble()

          ewallets(nbdeportemonnaie) = new Ewallet(idclient, codepin, argentdisponible, decouvertautorise, tauxdefrais)
          println("Un nouveau portemonnaie a été créé avec cet identifiant.")
          ewallets(nbdeportemonnaie).afficheVerif
          nbdeportemonnaie += 1
        }

      }

      else if (choix == 2) {
        idclient_verif = StdIn.readLine("Quel est votre identifiant ?")
        println("Quel est votre code pin ?")
        codepin_verif = StdIn.readInt()
        var action = false
        for (i <- 0 to nbdeportemonnaie - 1) {
          if (ewallets(i).verifieClient(idclient_verif, codepin_verif)) {
            println("SOUS-MENU" + '\n' +
              "1. Débiter votre porte-monnaie" + '\n' +
              "2. Créditer votre porte-monnaie" + '\n' +
              "Entrez votre choix :")
            choix = StdIn.readInt()
            if (choix == 1) {
              println("Quel montant souhaitez-vous débiter ?")
              montantadebiter = StdIn.readDouble()
              ewallets(i).operationDebit(montantadebiter)
              action = true
            }

            else if (choix == 2) {
              println("Quel montant souhaitez-vous créditer ?")
              montantacrediter = StdIn.readDouble()
              ewallets(i).operationCredit(montantacrediter)
              action = true
            }
          }
          if ((i == nbdeportemonnaie - 1) && (!action)) {
            println("L'identifiant et/ou mot de passe non valide(s).")
          }
        }
      }
    }

    // Cela quitte le menu
    println("Vous quittez le menu."+'\n')


    // AFFICHAGE DES PORTEFEUILLES CI-DESSOUS
    println("Affichage des portefeuilles."+'\n')
    for (i <- 0 to nbdeportemonnaie-1)
    {println("Portefeuille "+(i+1))
      ewallets(i).affiche}


    // SAUVEGARDE des portefeuilles dans le fichier txt.
sauverEwallet(ewallets)

  }
}
