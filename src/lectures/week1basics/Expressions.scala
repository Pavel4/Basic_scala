package lectures.week1basics

object Expressions extends  App {

  val aCondition = true

  val ifExpressionValue = if (aCondition) "True Condition" else "False Condition"
  println(ifExpressionValue) // выведет True Condition

  println(if(aCondition) "True Condition" else "False Condition") // выведет True Condition

  val someVal = print("It is just a value")
  print(someVal)               // сначала отработает первый принт, потом второй

  val aCodeBlock = {
    val someVal = 1
    val y = 2

    if (someVal + y > 1) true else false
  }

  println(aCodeBlock) // выводит true

  val aCodeBlock2 = {
    val someVal = 1
    val y = 2

    if (someVal + y > 1) true else false

    "String to return"
  }


  println(aCodeBlock2) // выводит "String to return"
}
