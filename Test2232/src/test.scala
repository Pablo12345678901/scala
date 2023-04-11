import scala.io.StdIn

object test {
  def main(args: Array[String]): Unit = {
    val matrice = Array.tabulate(10,10)((i,j) => i * j)
    for(x <- matrice)
      for(y <- x) println(y)
  }

}
