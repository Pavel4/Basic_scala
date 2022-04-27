package lectures.week3fp

import scala.annotation.tailrec

object FunctionsFP extends App {
  val product = new Function2[Int, Int, Int] {
    override def apply(x: Int, y: Int): Int = x * y
  }

  val product1 = (x: Int, y: Int) => x * y

  val sln = (s: String) => s.length

  val sln1: String => Int = s => s.length

  println(product(3, 4)) // выводит 12
  println(product1(3, 4)) // выводит 12

  @tailrec
  def nTimes(f: Int => Int, x: Int, n: Int): Int = {
    if (n <= 0) x
    else nTimes(f, f(x), n - 1)

  }

  val increment = (x: Int) => x + 1

  println(nTimes(increment, 0, 3)) // выведет 3


  def add(x: Int, y: Int) = x + y // Обычная функция

  println(add(1, 2)) // 3

  def add1(x: Int)(y: Int) = x + y // Каррированная функция

  println(add1(1)(2))

  def add2(x: Int) = (y: Int) => x + y // Каррированная функция

  println(add2(1)(2)) // 3

  def curryingNTimes(f: Int => Int, n: Int): Int => Int = {
    if (n <= 0) (x: Int) => x // лямбда-функция, что просто берет и возвращает значение
    else (x: Int) => curryingNTimes(f, n - 1)(f(x))
  }

  println(curryingNTimes(increment, 3)(0))

  def someFunc1: Int => ((Int) => Int) = (x: Int) => (y: Int) => x + y // Абсолютно отбитый язык. Ниже 4 одинаковыйх ф-ции

  def someFunc2 = (x: Int) => (y: Int) => x + y

  def someFunc3: Int => (Int => Int) = (x: Int) => (y: Int) => x + y

  def someFunc4: Int => (Int => Int) = (x) => (y) => x + y

  def someFunc: Int => Function1[Int, Int] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }


  val res = someFunc(1)

  println(res)
  println(res(4))
  println(someFunc(3)(4))
}
