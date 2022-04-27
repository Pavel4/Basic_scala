package lectures.week1basics

object Recursion extends App {

  var i = 0
  while (i < 3) {
    println("hello")
    i += 1
  }

  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else n * factorial(n - 1)
  }

  println(factorial(3)) // выводит 6

  def factorial2(n: Int): Int = {
    if (n <= 0) 1
    else {
      println(s"Имеем число $n, для которого считаем факториал ${n-1}")
      var res = n * factorial2(n-1)
      println(s"Вычислили факториал $n")

      res
    }
  }

  factorial2(3)


  def factorialWithTailRecursion(n: Int): Int = {
    def loop(x: Int, accumulator: Int): Int = {
      if (x <= 1) accumulator
      else loop(x-1, x*accumulator)
    }

    loop(n, 1)
  }



  import scala.annotation.tailrec


  def factorialWithTailRecursion2(n: Int): Int = {
    @tailrec
    def loop(x: Int, accumulator: Int = 1): Int = {
      if (x <= 1) accumulator
      else loop(x-1, x*accumulator)
    }

    loop(n)
  }


  // import scala.annotation.tailrec

  def powerOfTwo(n: Int): BigInt = {
    @tailrec
    def loop(x: Int, accumulator: BigInt = 1): BigInt = {
      if (x <= 0) accumulator
      else loop(x-1, accumulator * 2)
    }

    loop(n)
  }

  println(powerOfTwo(5))

//  def mainIncrease(args: Array[String]): Unit = {
//    val x = fArgs(0) + fArgs(1) * fArgs(2)
//    val n = x.toString.length
//    def loop(x: Int, n: Int): Unit = {
//      print(x + " ")
//      if (n <= 1) print("is the result")
//      else loop(x, n - 1)
//    }
//
//    loop(x, n)
//  }
//


//  val lst = input.split("\\s+").toList
//  val n = lst.length - 1
//
//  def loop(lst: List[String], n: Int): Unit = {
//    if (n <= 0) print(lst(n))
//    else {
//      print(lst(n) + " ")
//      loop(lst, n - 1)
//    }
//  }
//
//  loop(lst, n)

}
