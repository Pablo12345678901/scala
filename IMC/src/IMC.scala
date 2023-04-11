import scala.io.StdIn.readDouble

object IMC {
    def main(args: Array[String]): Unit = {
      // message pour l'utilisateur
      println("Quel est le poids ? >")
      // saisie au clavier du poids
      val masse = readDouble()
      println("Quel est la taille ? >")
      // saisie au clavier de la taille
      val taille = readDouble()
      val IMC = masse / (taille * taille)
      println("L'IMC vaut: " + IMC)
    }

}
