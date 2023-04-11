import java.lang.Boolean
import io.StdIn

object MorpionSolutionDuCours {
  def main(args: Array[String]): Unit = {
    var matrix = Array.ofDim[String](3,3)
    var tab = Array.fill(10)(0)
    var gagne = false

    println("Bienvenue dans Morpion 3000")

    afficher(matrix)

    var joueur = quiCommence()
    println("Le joueur " + joueur + " commence la partie.")

    while(gagne == false){
      println("Coup du joueur : " + joueur)
      val x = StdIn.readLine("Coordonnée x: ").toInt
      val y = StdIn.readLine("Coordonnée y: ").toInt

      matrix = action(joueur,x,y,matrix)
      afficher(matrix)
      gagne = verif(matrix)
      joueur = aQuiLeTour(joueur)
    }
    println("Fin de Partie")
    afficher(matrix)
  }

  def afficher(mat:Array[Array[String]]): Unit={
    for{i <- 0 until 3}{ //ligne
      for{j <- 0 until 3}{ //colone
        print("|" + mat(i)(j) + "|")
      }
      println()
    }
  }

  def aQuiLeTour(joueur:String):String={
    if(joueur == "X"){
      return "O"
    }
    else {
      return "X"
    }
  }

  def quiCommence():String={

    val random = new scala.util.Random
    val jrs = Array("X","O")
    return jrs(random.nextInt(2))
  }

  def action(joueur:String,i:Int,j:Int,mat:Array[Array[String]]):Array[Array[String]]={
    if(mat(i)(j) == null){
      mat(i)(j)=  joueur
      return mat
    }
    else {
      return mat
    }
  }

  def verif(mat:Array[Array[String]]): Boolean ={
    val gagneligne =  Array(Array("XXX"),Array("OOO"))

    for (x <- mat){
      if(x.mkString.contains(gagneligne(0).mkString) || x.mkString.contains(gagneligne(1).mkString)){
        return true
      }
    }

    for (x <- mat.transpose){
      if(x.mkString.contains(gagneligne(0).mkString) || x.mkString.contains(gagneligne(1).mkString)){
        return true
      }
    }

    for{i <- 0 until 3}{
      for{j <- 0 until 3}{
        if(mat(i)(j) == null){
          return false
        }
      }

    }
    return false
  }
}