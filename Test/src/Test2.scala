import scala.io.StdIn
object xxx {
var prixBillet = StdIn.readLine("Prix du Billet ?").toInt

if(prixBillet >= 40 ){
  print("L'âge possible de la personne est entre 25 et 60 ans")
}else{

  if(prixBillet < 26){
    print("L'âge possible de la personne est entre 0 et 18 ans")
  }else {

    if(prixBillet < 29){
      print("L'âge possible de la personne est supérieur à 60 ans")
    }else{
      print("L'âge possible de la personne est entre 18 et 25 ans")

    }
  }
}
}