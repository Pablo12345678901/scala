//Production de code: Le prix du billet//
//À travers ce notebook, nous allons étudier
// le problème suivant, le prix d’un billet
// de concert dépend de l'âge de l'acheteur :
// il vaut 80 CHF pour les plus de 20 ans et
// moins de 60 ans. Il vaut 60 CHF pour les
// moins de 20 ans et les plus de 60 ans. Le
// programme doit indiquer quel montant une
// personne doit payer pour son billet en
// fonction de son âge.

import scala.io.StdIn.readLine

object PrixBillet {
  def main(args: Array[String]): Unit = {
    val age = readLine("Quelle est votre âge ? > ").toInt
    if (age < 20 || age > 60) {
      println("Le prix du billet est de 60 CHF.")
    } else {
      println("Le prix du billet est de 80 CHF.")
    }
  }}
