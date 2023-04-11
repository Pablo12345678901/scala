object test {
  def main(args: Array[String]): Unit = {
    def norme2D(v: Array[Int]): Double = {
      if (v.size == 2) {
        return math.sqrt(v(0)*v(0) + v(1)*v(1))
      } else return -1
    }
    var bb = norme2D(Array(4,4))
    println(bb)
  }

}
