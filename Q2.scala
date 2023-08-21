class rational(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")

  private val gcdValue: Int = gcd(n.abs, d.abs)
  val numer: Int = n / gcdValue
  val denom: Int = d / gcdValue

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  def neg: rational = new rational(-numer, denom)

  def sub(that: rational): rational =
    new rational(numer * that.denom - that.numer * denom, denom * that.denom)

  override def toString: String = s"$numer / $denom"
}

object rationalDemo {
  def main(args: Array[String]): Unit = {
    val x = new rational(3, 4)
    val y = new rational(5, 8)
    val z = new rational(2, 7)

    val result = x.sub(y).sub(z)
    println("Result: " + result)
  }
}
