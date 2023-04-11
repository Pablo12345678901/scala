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

    /*
    La tableau message représente le résultat
    Vous devez adapter sa déclaration pour l'exercice
    */
    var message = Array("") // A ADAPTER

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