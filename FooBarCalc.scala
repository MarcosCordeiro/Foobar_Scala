object FooBarCalc {
  def main(args: Array[String]) {
    if(args.size>0){
      val arg : Option[Int] = Some(args(0).toInt)
      println(verifyFoobar(arg.getOrElse(0)))
    }
  }

  def verifyFoobar(number: Int): String = {
    val isFoo = new Foobar(3, (number % 3))
    val isBar = new Foobar(7, (number % 7))
    val isFooBar = new Foobar(21, (number % 21))
    for (results <- List(isFooBar, isBar, isFoo)) {
      if (matchFoobar(results) != null)
        return matchFoobar(results)
    }
    return number.toString()
  }
  def matchFoobar(foobar: Foobar): String = foobar match {
    case Foobar(3, 0) => "foo"
    case Foobar(7, 0) => "bar"
    case Foobar(21, 0) => "foobar"
    case _ => null
  }
  case class Foobar(number: Int, result: Int)
}