import scala.io.StdIn._

object exercice1{

  def main(args: Array[String]): Unit = {

    //déclaration des variables
    val tarif_centre = 2.0
    val tarif_ville = 2.4
    val tarif_agg = 3.0
    var tarif = 0.0
    var zone = ""

    //choix zone de tarif
    var choixzone = readLine(" Sélectionnez la zone tarifaire correspondant à votre trajet (1 pour Centre, 2 pour Ville et 3 pour Agglomération : ").toInt
    if (choixzone == 1) {
      tarif = tarif_centre
      zone = "centre"
    }
    else if (choixzone == 2) {
      tarif = tarif_ville
      zone = "ville"
    }
    else if (choixzone == 3) {
      tarif = tarif_agg
      zone = "agglomération"
    }

    //demande de demi tarif
    var demitarif = false
    var demitarif2 = readLine("avez vous le demi-tarif (o/n) ? :")
    if (demitarif2 == "o") {
      demitarif = true
    }
    else {
      demitarif = false
    }

    //demande quantité de billets
    var billet = readLine("combien de billets au total ? :").toInt
    while (billet < 1) {
      billet = readLine("combien de billets au total ? :").toInt
    }

    //si demi tarif
    var nbdemitarif = 0
    if (demitarif) {
      nbdemitarif = readLine("Dont combien de billets demi-tarif ? :").toInt
      while (nbdemitarif > billet || nbdemitarif < 1) {
        nbdemitarif = readLine("Dont combien de billets demi-tarif ? :").toInt
      }
    }

    //calcul prix
    var billetentier = billet - nbdemitarif
    var prix = (billetentier * tarif) + (nbdemitarif * tarif / 2)

    //les pièces
    var cinq = 0
    var deux = 0
    var un = 0
    var cinquante = 0
    var vingt = 0
    var dix = 0

    var monnaie = 0.0
    while (monnaie < prix) {
      val piece = readLine(" Saisissez le montant de la pièce que vous insérez :").toInt
      if (piece == 5) {
        monnaie = monnaie + 5
        cinq = cinq + 1
      }
      else if (piece == 2) {
        monnaie = monnaie + 2
        deux = deux + 1
      }
      else if (piece == 1) {
        monnaie = monnaie + 1
        un = un + 1
      }
      else if (piece == 50) {
        monnaie = monnaie + 0.5
        cinquante = cinquante + 1
      }
      else if (piece == 20) {
        monnaie = monnaie + 0.2
        vingt = vingt + 1
      }
      else if (piece == 10) {
        monnaie = monnaie + 0.1
        dix = dix + 1
      }
      else {
        println("Cette pièce n'est pas acceptée")
      }
    }

    //confirmation d'achat et rendre la monnaie
    var confirm = readLine("Confirmez vous l'achat (o/n)?")
    var txt5 = ""
    var txt2 = ""
    var txt1 = ""
    var txt50 = ""
    var txt20 = ""
    var txt10 = ""
    if (confirm == "n") {
      if (cinq == 1) {
        txt5 = "1 pièce de 5CHF,"
      }
      else if (cinq > 1) {
        txt5 = s"$cinq pièces de 5CHF, "
      }
      if (deux == 1) {
        txt2 = "1 pièce de 2CHF, "
      }
      else if (deux > 1) {
        txt2 = s"$deux pièces de 2CHF, "
      }
      if (un == 1) {
        txt1 = "1 pièce de 1CHF, "
      }
      else if (un > 1) {
        txt1 = s"$un pièces de 1CHF, "
      }
      if (cinquante == 1) {
        txt50 = "1 pièce de 50 centimes, "
      }
      else if (cinquante > 1) {
        txt50 = s"$cinquante pièces de 50 centimes, "
      }
      if (vingt == 1) {
        txt20 = "1 pièce de 20 centimes, "
      }
      else if (vingt > 1) {
        txt20 = s"$vingt pièces de 20 centimes, "
      }
      if (dix == 1) {
        txt10 = "1 pièce de 10 centimes, "
      }
      else if (dix > 1) {
        txt10 = s"$dix pièces de 10 centimes, "
      }

      println("Retour de votre monnaie : " + txt5 + txt2 + txt1 + txt50 + txt20 + txt10)
    } else {
      //impression du billet
      println(s"ticket zone tarifaire : $zone")
      println(s"Plein tarif : $billetentier")
      println(s"Demi-tarif : $nbdemitarif")
      println(s"Montant total TTC : $prix")
      println("Les transports Scala vous souhaitent un bon trajet")

      //rendre la monnaie
      var arendre = (monnaie-prix)*100
      var arendre5 = ""
      var arendre2 = ""
      var arendre1 = ""
      var arendre50 = ""
      var arendre20 = ""
      var arendre10 = ""

      if (arendre / 500 >= 1) {
        if (arendre / 500 < 2) {
          arendre5 = "1 pièce de 5CHF, "
        }
        else {
          arendre5 = arendre / 500 + "pièces de 5CHF, "
        }
        arendre = arendre % 500
      }
      if (arendre / 200 >= 1) {
        if (arendre / 200 < 2) {
          arendre2 = "1 pièce de 2CHF, "
        }
        else {
          arendre2 = arendre / 200 + "pièces de 2CHF, "
        }
        arendre = arendre % 200
      }
      if (arendre / 100 >= 1) {
        if (arendre / 100 < 2) {
          arendre1 = "1 pièce de 1CHF, "
        }
        else {
          arendre1 = arendre / 100 + "pièces de 1CHF, "
        }
        arendre = arendre % 100
      }
      if (arendre / 50 >= 1) {
        if (arendre / 50 < 2) {
          arendre50 = "1 pièce de 50 centimes, "
        }
        else {
          arendre50 = arendre / 50 + "pièces de 50 centimes, "
        }
        arendre = arendre % 50
      }
      if (arendre / 20 >= 1) {
        if (arendre / 20 < 2) {
          arendre20 = "1 pièce de 20 centimes, "
        }
        else {
          arendre20 = arendre / 20 + "pièces de 20 centimes, "
        }
        arendre = arendre % 20
      }
      if (arendre / 10 >= 1) {
        if (arendre / 10 < 2) {
          arendre10 = "1 pièce de 10 centimes, "
        }
        else {
          arendre10 = arendre / 10 + "pièces de 10 centimes, "
        }
      }

      println("votre monnaie : " + arendre5 + arendre2 + arendre1 + arendre50 + arendre20 + arendre10)
    }

  }
}