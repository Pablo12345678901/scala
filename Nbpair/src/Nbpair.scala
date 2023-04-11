import scala.io.StdIn.readInt

/*
Nombres pairs :
Vous allez devoir produire un programme qui
affiche les n premiers nombres pairs à partir
de 0 en utilisant la boucle for.

Le programme doit demander n à l'utilisateur.
*/

object Nbpair {
  def main(args: Array[String]): Unit = {
    var n = 0
    println("Voici un programme vous donnant les n premiers nombres pairs. Choisissez n tel que n soit un nombre entier. >")
      n = readInt()
//    println(n)
    while (n<=0)
    {
      println("n doit être plus grand que 0.")
      n = readInt()
    }
    for (x<-0 to n*2 by 2) println("Le "+x/2+" nombre pair est: "+x)
  }
}
/*
while (n<=0)
{
    println("n doit être plus grand que 0.")
    n = readInt()
}

 */