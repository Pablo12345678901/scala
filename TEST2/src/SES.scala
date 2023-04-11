import scala.io.StdIn.readLine

object signe {
  def main(args: Array[String]): Unit = {import scala.io.StdIn.readLine

    object signe {
      def main(args: Array[String]): Unit = {import scala.io.StdIn.readLine
        val a = readLine("Quelle est la valeur du premier entier ? > ").toInt
        val b = readLine("Quelle est la valeur du second entier ? > ").toInt

        if ((a>=0) && (b>=0)) println("Le résultat est positif")
        if ((a<0) && (b<0)) println("Le résultat est négatif")
        if ((a>=0) && (b <0) && (math.abs(a)) < math.abs(b)) println("Le résultat est négatif")
        if ((a>=0) && (b <0) && (math.abs(a)) >= math.abs(b)) println("Le résultat est positif")
        if ((a<0) && (b >=0) && (math.abs(a)) <= math.abs(b)) println("Le résultat est positif")
        if ((a<0) && (b >=0) && (math.abs(a)) > math.abs(b)) println("Le résultat est négatif")
        println("Vérification: " + (a+b))
      }
    }
  }
}