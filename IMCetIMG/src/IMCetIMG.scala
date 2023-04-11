import scala.io.StdIn.readLine

object IMCetIMG {def main(args: Array[String]): Unit = {

  //Vous devez rédiger un programme calculant
  // l'IMC et l'IMG en fonction de la taille,
  // du poids et du sexe de l'utilisateur.
  // Enfin, vous devez fournir une
  // interprétation de l'IMC et IMG obtenue.
  // IMC = poids * taille^2
  // IMG = (1,2 × IMC) + (0,23 × âge) - (10,8 × S) - 5,4
  // av S = 0 pour femme et S = 1 pour homme
  val taille = readLine("Combien mesurez-vous (mètre) ? ").toDouble
  val poids = readLine("Combien pesez-vous ? ").toDouble
  val age = readLine("Quel âge avez-vous ? ").toInt
  var sexe = readLine("Êtes-vous une femme (tapez 0) ou un homme (tapez 1) ? ").toInt
  if (!(sexe == 1 || sexe == 0)) {
    sexe = readLine("Veuillez taper 0 si vous êtes une femme ou 1 si vous êtes un homme. ").toInt
  }
  var IMC = poids / (taille * taille)
  var IMG = (1.2 * IMC) + (0.23 * age) - (10.8 * sexe) - 5.4

  println("Votre IMC est de " + IMC + ".")

  // moins de 16,5 	dénutrition
  //16,5 à 18,5 	maigreur
  //18,5 à 24,9 	poids normal
  //25 à 29,9 	surpoids
  //30 à 34,9 	obésité modérée
  //35 à 39,9 	obésité sévère
  //40 et plus 	obésité morbide ou massive

  if (IMC < 16.5) {
    println("Selon votre IMC, vous êtes dans un état de dénutrition.")
  } else if (IMC < 18.5) {
    println("Selon votre IMC, vous êtes dans un état de maigreur.")
  } else if (IMC < 25) {
    println("Selon votre IMC, vous êtes dans un état de poids normal.")
  } else if (IMC < 30) {
    println("Selon votre IMC, vous êtes dans un état de surpoids.")
  } else if (IMC < 35) {
    println("Selon votre IMC, vous êtes dans un état d'obésité modérée.")
  } else if (IMC < 40) {
    println("Selon votre IMC, vous êtes dans un état d'obésité sévère.")
  } else {
    println("Selon votre IMC, vous êtes dans un état d'obésité morbide ou massive.")
  }

  println("Votre IMG est de " + IMG + ".")

  //Description 	Femme 	Homme
  //Minimum vital 	10–13 % 	2–5 %
  //Athlétique 	14–20 % 	6–13 %
  //En forme 	21–24 % 	14–17 %
  //Moyen 	25–31 % 	18–24 %
  //Obèse 	32%+ 	25%+

  if (sexe == 0) {
    if (IMG>=10 && IMG<=14) {
      println("Selon votre IMG, votre taux de graisse est celui d'une femme au minimum vital.")
    } else if (IMG < 21) {
      println("Selon votre IMG, votre taux de graisse est celui d'une femme athlétique.")
    } else if (IMG < 25) {
      println("Selon votre IMG, votre taux de graisse est celui d'une femme en forme.")
    } else if (IMG < 32) {
      println("Selon votre IMG, votre taux de graisse est celui d'une femme moyenne.")
    } else {
      println("Selon votre IMG, votre taux de graisse est celui d'une femme obèse.")
    }
    }

  //Description 	Femme 	Homme
  //Minimum vital 	10–13 % 	2–5 %
  //Athlétique 	14–20 % 	6–13 %
  //En forme 	21–24 % 	14–17 %
  //Moyen 	25–31 % 	18–24 %
  //Obèse 	32%+ 	25%+

  {if (IMG>=2 && IMG<=6) {
    println("Selon votre IMG, votre taux de graisse est celui d'un homme au minimum vital.")
  } else if (IMG < 14) {
    println("Selon votre IMG, votre taux de graisse est celui d'un homme athlétique.")
  } else if (IMG < 18) {
    println("Selon votre IMG, votre taux de graisse est celui d'un homme en forme.")
  } else if (IMG < 25) {
    println("Selon votre IMG, votre taux de graisse est celui d'un homme moyen.")
  } else {
    println("Selon votre IMG, votre taux de graisse est celui d'un homme obèse.")
  }
}
}

}
