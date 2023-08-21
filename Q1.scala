class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")

  private val gcdValue: Int = gcd(n.abs, d.abs)
  val numer: Int = n / gcdValue
  val denom: Int = d / gcdValue

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  def neg: Rational = new Rational(-numer, denom)

  override def toString: String = s"$numer / $denom"
}

object RationalDemo {
  def main(args: Array[String]): Unit = {
    val x = new Rational(3, 4)
    println("x = " + x)

    val negX = x.neg
    println("-x = " + negX)
  }
}
