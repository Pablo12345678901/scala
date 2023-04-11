import scala.io.StdIn._

object exercice1 {
  def code(mot: String): String = {
    /*
    - VOTRE CODE DOIT COMMENCER JUSTE APRES CE COMMENTAIRE -
    N'effacez ou ne modifiez rien au-dessus de ce commentaire
    */

    /*
    Copiez/collez juste sous ce commentaire la déclaration des deux tableaux qui vous a été fournie dans l'énoncé
    Vous devez utiliser ces variables pour résoudre l'exercice
    Vous ne pouvez pas modifier leur déclaration
    */
    val morse = Array(".-", "-...", "-.-.", "-..", ".","..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..")
    val alphabet = Array('A', 'B', 'C', 'D', 'E', 'F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z')
    /*
    La tableau message représente le résultat
    Vous devez adapter sa déclaration pour l'exercice
    */
    var motencaracteres = mot.toCharArray
    var message = new Array[String](motencaracteres.size) // A ADAPTER

    for (i <- 0 until motencaracteres.size)
{var change = false
  while (!change)
    for (j <- 0 until alphabet.size) if (alphabet(j)==(motencaracteres(i))) {message(i)=morse(j)
    change = true}}

    /*
    - VOTRE CODE DOIT SE TERMINER JUSTE AVANT CE COMMENTAIRE
    N'effacez ou ne modifiez rien après ce commentaire
     */
    return message.mkString(" ")
  }

  def main(args: Array[String]): Unit = {
    /*
    Pour l'examen, vous ne DEVEZ PAS écrire votre code ici
    */
    var mot = readLine("Mot ? > ")
    print("code :" + code(mot))
  }
}