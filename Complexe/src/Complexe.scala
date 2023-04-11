object Complexe {
  def main(args: Array[String]): Unit = {
    class nombreComplexe (var reelle: Double, var imaginaire : Double){
      def affiche(): Unit = {
        println("Partie réelle : "+reelle+" et partie imaginaire : "+imaginaire)
      }
      def +(nombreComplexe1 : nombreComplexe): nombreComplexe ={
        return new nombreComplexe(reelle+nombreComplexe1.reelle,imaginaire+nombreComplexe1.imaginaire)
      }
      def *(nombreComplexe1 : nombreComplexe) : nombreComplexe ={
        return new nombreComplexe((reelle*nombreComplexe1.reelle)-(imaginaire*nombreComplexe1.imaginaire),(reelle*nombreComplexe1.imaginaire)+(imaginaire*nombreComplexe1.reelle))
      }
      def module() : Double ={
        return math.sqrt(math.pow(reelle, 2)+math.pow(imaginaire, 2))
      }
    }
    var nbtest1 = new nombreComplexe(11,23)
    var nbtest2 = new nombreComplexe(3,4)
    var sommenbtest1et2 = nbtest1 + nbtest2
    var produitnbtest1et2 = nbtest1 * nbtest2
    //var modulenbtest1 = nbtest1.module
    println("La somme des nombres complexe nbtest1 et nbtest2 est : ")
    sommenbtest1et2.affiche
    println("Le produit des nombres complexe nbtest1 et nbtest2 est : ")
    produitnbtest1et2.affiche
    println("Le module du nbtest1 est : "+nbtest1.module+".")
  }
}
