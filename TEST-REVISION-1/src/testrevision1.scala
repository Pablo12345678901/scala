import scala.io.StdIn.readLine
import scala.io.StdIn.readChar

object testrevision1 {

  class Point(var xc: Int, var yc: Int) {
    def deplace(dx: Int, dy: Int): Unit = {
      xc = xc + dx
      yc = yc + dy
      println("Point x location : " + xc)
      println("Point y location : " + yc)
    }
  }

    def main(args: Array[String]): Unit = {

      // DEBUT CODE TEST
      var banzai = new Point(2, 3)
      banzai.xc = 25
      println(banzai.xc)
      banzai.deplace(35,-100)

      // FIN CODE TEST

    }
  }
