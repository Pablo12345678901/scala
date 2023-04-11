import scala.io.StdIn.readLine
import scala.io.StdIn.readDouble
import scala.io.StdIn.readInt
import scala.io.StdIn.readChar

object Motdepasse {
  def main(args: Array[String]): Unit = {
/*
Vous allez devoir écrire un programme qui génère un mot de passe selon les règles suivantes :
    L'utilisateur doit entrer le nombre de caractères du mot de passe (e.g. 8)
    - Le mot de passe doit contenir au moins 8 caractères.
    - Le mot de passe contient deux chiffres.
    - Le mot de passe contient un caractère spécial (e.g. # ou @)
    Le reste du mot de passe est composé de lettres majuscule et minuscule.
    Les lettres, les deux chiffres et le caractère spécial doivent être choisis aléatoirement
    Les deux chiffres et le caractère spécial doivent être insérés aléatoirement dans le mot
    de passe
    Indications
    Vous pouvez créer plusieurs tableaux qui contiennent les lettres minuscules et majuscules,
    les chiffres et les caractères spéciaux.
    Pour tirer aléatoirement une lettre, un chiffre ou un caractère spécial, vous pouvez tirer
    au hasard un nombre entier qui correspondra à l'index de la lettre/chiffre/caractère spécial
    choisi dans le tableau des lettres/chiffres/caractères spéciaux.
    Pour placer aléatoirement un chiffre ou un caractère spécial, vous pouvez tirer au hasard un
    nombre entier qui correspondra à l'index de la cellule du tableau du mot de passe où il sera
    inséré.
    Attention: quand vous insérez aléatoirement un caractère dans le tableau du mot de passe, il
    faut vous assurer à chaque fois que la cellule est bien vide (qu'il n'y a pas déjà un caractère
    qui y a été inséré)
 */


    // CHOIX NB TOTAL DE CARACTERE MDP

// /*

   println("Choisissez le nombre de caractères que contiendra votre mot de passe. Attention, il doit" +
      " être au minimum de 8. >")
    var nombrecaracteremdp = readInt()
    while (nombrecaracteremdp<8)
    {println("Choisissez le nombre de caractères que contiendra votre mot de passe. Attention, il doit" +
        " être au minimum de 8. >")
    nombrecaracteremdp = readInt()}

// */

    // TABLEAU D = Mot de passe initial

// /*

    var tableauD = Array.fill(nombrecaracteremdp)('-')

    println(tableauD.mkString)

// */



    // TABLEAU A = 2 chiffres aleatoires

    // /*

    val tableauA = Array('0','1','2','3','4','5','6','7','8','9')
var nombredenombre = 0
    var nombre = '0'

    val x = (nombrecaracteremdp*math.random).toInt
    println(x)

 while (nombredenombre < x)
   {nombre = tableauA((tableauA.size * math.random).toInt)
     val i = (tableauD.size*math.random()).toInt
     if (tableauD(i)=='-')
       {tableauD(i)= nombre
         nombredenombre +=1
       }

   }
    println(tableauD.mkString)

    // */



    // TABLEAU B = 1 caractère spécial
// /*
    val tableauB = Array('(','_')
    var nombredecaracterespecial = 0
    var caracterespecial = '.'

    val y = ((nombrecaracteremdp-x)*math.random).toInt
    println(y)

    while (nombredecaracterespecial < y)
    {caracterespecial = tableauB((tableauB.size * math.random).toInt)
      val i = (tableauD.size*math.random()).toInt
      if (tableauD(i)=='-')
      {tableauD(i)= caracterespecial
        nombredecaracterespecial +=1
      }

    }
    println(tableauD.mkString)

// */



    // TABLEAU C = alphabet en minuscule et majuscule

// /*

    val tableauC = Array('A','a','B','b','C','c','D','d','E','e','F','f','G','g','H','h','I','i','J','j','K','k','L','l','M','m','N','n','O','o','P','p','Q','q','R','r','S','s','T','t','U','u','V','v','W','w','X','x','Y','y','Z','z')
    // println(tableauC)

    var lettre = 'a'
    for (i <-0 to (tableauD.size)-1)
    {if (tableauD(i)=='-')
      {lettre = tableauC((tableauC.size * math.random).toInt)
        tableauD(i)=lettre}
    }
  println(tableauD.mkString)

// */



    // FIN

  }
}
