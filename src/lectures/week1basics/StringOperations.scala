package lectures.week1basics

object StringOperations extends App {
  val aString: String = "Hello, world!"

  println(aString.length) // выводит 13
  println(aString.charAt(1)) // выводит e
  println(aString.substring(0, 2)) // выводит He
  println(aString.split(" ").toList) // выводит List(Hello,, world!)
  println(aString.startsWith("He")) // выводит true
  println(aString.replace("!", ".")) // выводит Hello, world.
  println(aString.toLowerCase) // выводит hello, world!
  println(aString.toUpperCase) // выводит HELLO, WORLD!
  println("abcd".reverse) // выводит dcba
  println("abcd".take(2)) // выводит ab

  val aString2 = "Scala course"

  println(aString2.toUpperCase.substring(0, 5))
  println(aString2.take(5).toUpperCase)
  println(aString2.substring(0, 5).toUpperCase)

  val aString3 = 42.toString
  val aNumber = "42".toInt

  println('1' +: "42" :+ '3') // выводит 1423
  println('a' +: "bc" :+ 'd') // abcd
  println("a" ++ "bc" :++ "d") // abcd

  val name = "John"
  val surname = "Smith"

  println(s"Hello, ${name + surname}") // выводит Hello, JohnSmith

  val item = "Laptop"
  val price = 999.999

  val info = s"Info: \n Name: $item \t Price : $price%.2f"
  val rawInfo = raw"Info: \n Name: $item \t Price : $price%.2f"

  println(info)
  println(rawInfo)
}
