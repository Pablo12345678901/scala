import java.io.{FileWriter, PrintWriter}
import scala.io.Source
import scala.io.StdIn.readLine
import scala.util.Random



object exercice2 {
  class Ewallet(vid: String , vmontant: Double, vdecouvert: Double, vfrais: Float, afficher : Boolean = true) {

    val random = new Random()

    var codepin = 100 + random.nextInt((99999 - 100) + 1)
    val idalpha = vid
    var montant = vmontant

    if (afficher==true) println("Votre pin est " + codepin + " et vous avez un montant de : " + montant + "CHF ")



    def verifclient(idClient_verif: String, codepin_verif: Int): Boolean = {
      return idClient_verif == idalpha && codepin_verif == codepin
    }


    def operationDebit(valeuradebiter: Double): Unit = {
      if ((montant + vdecouvert)* vfrais + montant + vdecouvert >= valeuradebiter){
        montant -= valeuradebiter
        println("\nVotre compte a été débité. \nSolde restant : " +montant+ " CHF ")
      }
      else
        println("\nImpossible de débiter ce montant. ")
    }



    def operationCredit(valeuracrediter: Double): Unit = {
      montant += valeuracrediter - valeuracrediter*vfrais
      println(valeuracrediter + "CHF ont  été crédité au compte. \n Solde restant : " +montant)
    }



    def afficheverif(): Unit = {
      println(" ")
      println("\nVoici les informations du Ewallet : ")
      println("\nCode PIN: " + codepin)
      println("\nMontant disponible : " + montant)
    }
  }




  def sauverEwallet(eWallets: Array[Ewallet]): Unit ={
   val source = Source.fromFile("ewallets.txt").mkString
   val xw = new PrintWriter(new FileWriter("ewallets.txt", true))
   for (ewalletperso <- eWallets){

     if (ewalletperso != null && !source.contains(ewalletperso.idalpha)) {
       xw.println(ewalletperso.idalpha + " , " + ewalletperso.codepin + " , " + ewalletperso.montant)
     }
   }
   xw.close()
 }




  def lireEwallet(): Array[Ewallet] = {
    var eWallets = new Array[Ewallet](50)
    try {
      val pr = Source.fromFile("ewallets.txt")
      val lignepr = pr.reset.getLines
      var i = 0
      while (!lignepr.isEmpty) {
        var ligne = lignepr.next
        var unEWallet = ligne.split(" , ")
        eWallets(i) = new Ewallet(unEWallet(0), unEWallet(2).toDouble, 500.0, 0.03F, false)
        eWallets(i).codepin = unEWallet(1).toInt
        i += 1
      }
      pr.close()
    } catch {
      case e =>
        new PrintWriter("ewallets.txt").close()
    }
    return eWallets
  }



  def main(args: Array[String]): Unit = {
    val ewallets= lireEwallet()


    var compteur: Int = 25
    var enmarche = true
    while (enmarche==true) {
      println("\nMenu : \n 1. Créer un porte-monnaie \n 2. Accéder à son porte-monnaie \n 3. Quitter le programme ")
      val choixmenu = readLine("\nEntrez votre choix : ").toInt
      if (choixmenu == 1) {
        val importer = readLine("\nEntrez votre identifiant client : ")
        var libre = true
        for (i <- 0 to compteur)
          if (ewallets(i) != null && (ewallets(i).idalpha == importer)) libre = false

        if (libre) {
          ewallets(compteur) = new Ewallet(importer, readLine("Entrez le montant que vous souhaitez créditer sur le compte ? ").toDouble, 500,0.03F)
          compteur += 1
        } else
          println("\nCe Ewallet existe déjà ")
      }



      if (choixmenu == 2) {
        var idclient = readLine("\nQuel est votre identifiant client ? ")
        var ewalletcorrecte = false
        for (i <- 0 to compteur)
          if (ewallets(i) != null && ewallets(i).idalpha == idclient) ewalletcorrecte=true


        if (ewalletcorrecte) {
          var codepin = readLine("\nEntrez votre code pin : ").toInt
            var pincorrecte = false
            var ewalletperso:Ewallet = null
            for (i <- 0 to compteur)
              if (ewallets(i) != null && ewallets(i).codepin==codepin) {
                pincorrecte = true
                ewalletperso = ewallets(i)
              }
              if (pincorrecte){
                val choix2 = readLine("\nMenu : \n 1. Debiter \n 2. Créiter \n 3. Afficher les infos \n Entrez votre choix (1 , 2 , 3) ").toInt
                if (choix2 == 1) ewalletperso.operationDebit(readLine("Quel montant souhaitez-vous debiter ? : ").toDouble)
                if (choix2 == 2) ewalletperso.operationCredit(readLine("Quel montant souhaitez-vous crediter ? : ").toDouble)
                if (choix2 == 3) ewalletperso.afficheverif()
              } else
                println("\nCode pin invalide")
            } else
          println("\nCe Ewallet n'existe pas")
      }
            if (choixmenu == 3) {
              for (ewalletperso <- ewallets) {
                if (ewalletperso != null) ewalletperso.afficheverif()
              }
              sauverEwallet(ewallets)
              enmarche = false
            }
          }
    }
}






