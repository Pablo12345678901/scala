object exercice1 {
  def main(args: Array[String]): Unit = {

    /*
    Énoncé
    Le programme doit simuler les opérations suivantes :
● Proposer à l’usager/ère de choisir sa zone tarifaire
● Proposer d’indiquer s’elle/il a un demi-tarif
● Demander combien de billets au total l’usager/ère veut obtenir
o et s’elle/il a un demi-tarif, combien de billets à demi-tarif
● Demander à l’usager/ère d’insérer son argent (elle/il doit taper successivement le montant
de chaque pièce insérée).
● Demander à l’usager/ère de confirmer son achat.
● S’elle/il confirme, les billets sont imprimés et la monnaie lui est rendue.
● S’elle/il ne confirme pas, les pièces qu’elle/il a insérées lui sont rendues.
     */


    import scala.io.StdIn.readChar
    import scala.io.StdIn.readInt



 //   ● Proposer à l’usager/ère de choisir sa zone tarifaire


    var prixticketpleintarif = 0.0

    println('\n' + "Sélectionnez la zone tarifaire correspondant à votre trajet (1 pour Centre, 2 " +
      "pour Ville et 3 pour Agglomération : ")
    val zone = readInt()
    if (zone==1)
    {prixticketpleintarif=2.0}
    else if (zone==2)
    {prixticketpleintarif=2.4}
    else {prixticketpleintarif=3.0}





 //    ● Proposer d’indiquer s’elle/il a un demi-tarif

    var nombredeticketdemitarif = 0
    var nombredeticketpleintarif = 0
    var montantdu = 0.0

    println('\n' + "Avez-vous le demi-tarif (o/n) ? :")
    val demitarif = readChar()
    if (demitarif=='o')
    {montantdu = prixticketpleintarif/2
      nombredeticketdemitarif +=1
    }
    else if (demitarif=='n')
    {montantdu = prixticketpleintarif
      nombredeticketpleintarif +=1}





 // ● Demander combien de billets au total l’usager/ère veut obtenir

    println('\n' + "Combien de billets au total ? : ")
var nombretotaldeticket = readInt()
    while (nombretotaldeticket<1)
    {println('\n' + "Le nombre total de ticket doit être supérieur ou égal à 1. Veuillez le ressaisir : ")
      nombretotaldeticket = readInt()}





 // o et s’elle/il a un demi-tarif, combien de billets à demi-tarif

    if (nombredeticketdemitarif>0)
    {println('\n' + "Dont combien de billets demi-tarifs ? : ")
      nombredeticketdemitarif = readInt()
    while ((nombredeticketdemitarif>nombretotaldeticket)||(nombredeticketdemitarif<=0))
      {println('\n' + "Le nombre de ticket demi tarif doit être d'au moins 1. Par ailleurs il ne peut être plus grand que le " +
        "nombre de ticket total. Veuillez le ressaisir : ")
        nombredeticketdemitarif = readInt()}
    }
    {nombredeticketpleintarif = nombretotaldeticket}
    nombredeticketpleintarif = nombretotaldeticket - nombredeticketdemitarif





 // ● Demander à l’usager/ère d’insérer son argent (elle/il doit taper successivement le montant
    // de chaque pièce insérée).

    var nombredepiecede5CHF = 0
    var nombredepiecede2CHF = 0
    var nombredepiecede1CHF = 0
    var nombredepiecede50centimes = 0
    var nombredepiecede20centimes = 0
    var nombredepiecede10centimes = 0
    var pieceinseree = 0.0
    montantdu = (nombredeticketpleintarif * prixticketpleintarif) + (nombredeticketdemitarif * (prixticketpleintarif/2))
    // ci-dessous transformation du montant pour éviter les erreurs d'arrondis
    montantdu = (montantdu*10).toInt
    montantdu = montantdu/10.toDouble
    // Type BigDecimal utilisé pour contrecarrer des problèmes d'arrondis apparaissant
    // au niveau du calcul de la monnaie à rendre en cas de confirmation.
    var montantpaye :BigDecimal = 0.0

    // Ce println est là à des fins de test.
    /*
    println('\n' + "Il y a "+nombredeticketpleintarif+" ticket(s) plein tarif."+'\n'
      + "Il y a "+nombredeticketdemitarif+" ticket(s) demi tarif."+'\n'
      + "Le montant total dû est de "+montantdu+" CHF."+'\n')
    */

    while (montantdu>montantpaye)
    {println('\n' + "Saisissez le montant de la pièce que vous insérez " +
      "(5 pour une pièce de 5 CHF, 2 pour une pièce de 2 CHF, 1 pour une pièce de 1 CHF, " +
      "50 pour une pièce de 50 cts, 20 pour une pièce de 20 cts et 10 pour " +
      "une pièce de 10 cts) : ")
      pieceinseree = readInt()

      while (!(pieceinseree==5) && !(pieceinseree==2) && !(pieceinseree==1) && !(pieceinseree==50) && !(pieceinseree==20) && !(pieceinseree==10))
        {println('\n' + "Cette pièce n’est pas acceptée. ")
          pieceinseree = readInt()}

      if ((pieceinseree==5) || (pieceinseree==2) || (pieceinseree==1))
      {montantpaye += pieceinseree
        if (pieceinseree==5)
          {nombredepiecede5CHF+=1}
        else if (pieceinseree==2)
        {nombredepiecede2CHF+=1}
        else {nombredepiecede1CHF+=1}
      }

        else {montantpaye += (pieceinseree/100)
        // ci-dessous transformation du montant pour éviter les erreurs d'arrondis
        montantpaye = (montantpaye*100).toInt
        montantpaye = montantpaye/100
        if (pieceinseree==50)
        {nombredepiecede50centimes+=1}
        else if (pieceinseree==20)
        {nombredepiecede20centimes+=1}
        else {nombredepiecede10centimes+=1}}

      // Ce println est là à des fins de test.
      /*
      println('\n' + "Le montant total payé pour le moment est de "+montantpaye+ " CHF."+ '\n')
      */


    }





  //  ● Demander à l’usager/ère de confirmer son achat.

    println('\n' + "Confirmez-vous l’achat (o/n) ? ")
    val confirmationdachat = readChar()






    // var nomdelazone est utile pour l'impression de la zone sur le ticket,
    // en cas de confirmation positive.
    // MAIS elle doit être déclarée avant le if else if.
    var nomdelazone: String = "xxx"








  // ● S’elle/il ne confirme pas, les pièces qu’elle/il a insérées lui sont rendues.

    if (confirmationdachat=='n')
    {
      // Construction du message final

      var message5CHF=""
      var message2CHF=""
      var message1CHF=""
      var message50centimes=""
      var message20centimes=""
      var message10centimes=""

      if (!(nombredepiecede5CHF==0))
      {message5CHF=nombredepiecede5CHF+ " pièce(s) de 5 CHF"}

      if (!(nombredepiecede2CHF==0))
      {message2CHF=nombredepiecede2CHF+ " pièce(s) de 2 CHF"}

      if (!(nombredepiecede1CHF==0))
      {message1CHF=nombredepiecede1CHF+ " pièce(s) de 1 CHF"}

      if (!(nombredepiecede50centimes==0))
      {message50centimes=nombredepiecede50centimes+ " pièce(s) de 50 centimes"}

      if (!(nombredepiecede20centimes==0))
      {message20centimes=nombredepiecede20centimes+ " pièce(s) de 20 centimes"}

      if (!(nombredepiecede10centimes==0))
      {message10centimes=nombredepiecede10centimes+ " pièce(s) de 10 centimes"}


      // Mettre des virgules entre les messages s'il y a un autre message ensuite uniquement.

      var nvirguleentre5et2 = ""
      if (
        (!(nombredepiecede5CHF==0)) &&
          ((!(nombredepiecede2CHF==0)) || (!(nombredepiecede1CHF==0)) || (!(nombredepiecede50centimes==0)) || (!(nombredepiecede20centimes==0)) || (!(nombredepiecede10centimes==0)))
      )
        {nvirguleentre5et2=", "}

      var nvirguleentre2et1 = ""
      if (
        (!(nombredepiecede2CHF==0)) &&
          ((!(nombredepiecede1CHF==0)) || (!(nombredepiecede50centimes==0)) || (!(nombredepiecede20centimes==0)) || (!(nombredepiecede10centimes==0)))
      )
      {nvirguleentre2et1=", "}

      var nvirguleentre1et50 = ""
      if (
        (!(nombredepiecede1CHF==0)) &&
          ( (!(nombredepiecede50centimes==0)) || (!(nombredepiecede20centimes==0)) || (!(nombredepiecede10centimes==0)))
      )
      {nvirguleentre1et50=", "}

      var nvirguleentre50et20 = ""
      if (
        (!(nombredepiecede50centimes==0)) &&
          ( (!(nombredepiecede20centimes==0)) || (!(nombredepiecede10centimes==0)) )
      )
      {nvirguleentre50et20=", "}

      var nvirguleentre20et10 = ""
      if (
        (!(nombredepiecede20centimes==0)) &&
           (!(nombredepiecede10centimes==0))
      )
      {nvirguleentre20et10=", "}


      // affichage du message final
      val messagefinal = message5CHF + nvirguleentre5et2 + message2CHF + nvirguleentre2et1 + message1CHF + nvirguleentre1et50 + message50centimes + nvirguleentre50et20 + message20centimes + nvirguleentre20et10 + message10centimes
      println('\n' + "Retour de votre monnaie : "+messagefinal+".")


    }




    // ● S’elle/il confirme, les billets sont imprimés et la monnaie lui est rendue.

    else if (confirmationdachat=='o')
    {
      {
        if (zone == 1)
        {nomdelazone = "Centre"}
        else if (zone == 2)
        {nomdelazone = "Ville"}
        else
        {nomdelazone = "Agglomération"}
      }


      // à des fins esthétiques
      println('\n' + "Impression du ticket" + '\n')


      // Impression du ticket
      println('\n' + "Ticket zone tarifaire : "+nomdelazone+ '\n' +
        "Plein tarif : " + nombredeticketpleintarif + '\n' +
        "Demi-tarif : " + nombredeticketdemitarif + '\n' +
        "Montant total TTC : " + montantdu + '\n' +
        "Les transports Scala vous souhaitent un bon trajet" + '\n')


      // Calcul de la monnaie à rendre
      if (montantdu<montantpaye)
      {var montantarendre = ((montantpaye-montantdu)*100).toInt


        nombredepiecede5CHF = (montantarendre/500).toInt
        montantarendre-=(nombredepiecede5CHF*500)

        nombredepiecede2CHF = (montantarendre/200).toInt
          montantarendre-=(nombredepiecede2CHF*200)

        nombredepiecede1CHF = (montantarendre/100).toInt
          montantarendre-=(nombredepiecede1CHF*100)

        nombredepiecede50centimes = (montantarendre/50).toInt
          montantarendre-=(nombredepiecede50centimes*50)

        nombredepiecede20centimes = (montantarendre/20).toInt
          montantarendre-=(nombredepiecede20centimes*20)

        nombredepiecede10centimes = (montantarendre/10).toInt
          montantarendre-=(nombredepiecede10centimes*10)



        // Construction du message final

        var message5CHF=""
        var message2CHF=""
        var message1CHF=""
        var message50centimes=""
        var message20centimes=""
        var message10centimes=""

        if (!(nombredepiecede5CHF==0))
        {message5CHF=nombredepiecede5CHF+ " pièce(s) de 5 CHF"}

        if (!(nombredepiecede2CHF==0))
        {message2CHF=nombredepiecede2CHF+ " pièce(s) de 2 CHF"}

        if (!(nombredepiecede1CHF==0))
        {message1CHF=nombredepiecede1CHF+ " pièce(s) de 1 CHF"}

        if (!(nombredepiecede50centimes==0))
        {message50centimes=nombredepiecede50centimes+ " pièce(s) de 50 centimes"}

        if (!(nombredepiecede20centimes==0))
        {message20centimes=nombredepiecede20centimes+ " pièce(s) de 20 centimes"}

        if (!(nombredepiecede10centimes==0))
        {message10centimes=nombredepiecede10centimes+ " pièce(s) de 10 centimes"}


        // Ci-dessous = mettre des virgules entre les messages s'il y a un autre message qui suit uniquement.

        var ovirguleentre5et2 = ""
        if (
          (!(nombredepiecede5CHF==0)) &&
            ((!(nombredepiecede2CHF==0)) || (!(nombredepiecede1CHF==0)) || (!(nombredepiecede50centimes==0)) || (!(nombredepiecede20centimes==0)) || (!(nombredepiecede10centimes==0)))
        )
        {ovirguleentre5et2=", "}

        var ovirguleentre2et1 = ""
        if (
          (!(nombredepiecede2CHF==0)) &&
            ((!(nombredepiecede1CHF==0)) || (!(nombredepiecede50centimes==0)) || (!(nombredepiecede20centimes==0)) || (!(nombredepiecede10centimes==0)))
        )
        {ovirguleentre2et1=", "}

        var ovirguleentre1et50 = ""
        if (
          (!(nombredepiecede1CHF==0)) &&
            ( (!(nombredepiecede50centimes==0)) || (!(nombredepiecede20centimes==0)) || (!(nombredepiecede10centimes==0)))
        )
        {ovirguleentre1et50=", "}

        var ovirguleentre50et20 = ""
        if (
          (!(nombredepiecede50centimes==0)) &&
            ( (!(nombredepiecede20centimes==0)) || (!(nombredepiecede10centimes==0)) )
        )
        {ovirguleentre50et20=", "}

        var ovirguleentre20et10 = ""
        if (
          (!(nombredepiecede20centimes==0)) &&
            (!(nombredepiecede10centimes==0))
        )
        {ovirguleentre20et10=", "}



        // Affichage du message final
        val messagefinal = message5CHF + ovirguleentre5et2 + message2CHF + ovirguleentre2et1 + message1CHF + ovirguleentre1et50 + message50centimes + ovirguleentre50et20 + message20centimes + ovirguleentre20et10 + message10centimes
        println('\n' + "Votre monnaie : "+messagefinal+".")

      }
    }






    // FIN





  }
}
