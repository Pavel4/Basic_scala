package lectures.week3fp

object Collections extends App {

  // Set

  val emptySet: Set[Int] = Set()
  val aSet = Set(10, 20, 30, 40)
  val anotherSet = Set(30, 40, 50, 60)

  println(aSet.isEmpty)
  println(emptySet.isEmpty)

  println(aSet.head)
  println(aSet.tail)

  println(aSet.min)
  println(aSet.max)

  println(aSet.intersect(anotherSet))
  println(aSet.&(anotherSet))

  println(aSet.++(anotherSet))
  println(aSet ++ anotherSet)

  // Sequence

  val aSequence = Seq(1, 3, 2, 4)

  println(aSequence)

  println(aSequence.length)

  println(aSequence ++ Seq(6, 7, 5))

  println(aSequence.reverse)

  println(aSequence.sorted)

  println(aSequence(1))

  println(aSequence.search(3))

  // Map

  val aMap: Map[String, Int] = Map()

  val colors: Map[String, String] =
    Map(("black", "#000000"), "blue" -> "#0d1ad1", ("Blue", "#161f96")).withDefaultValue("na")

  println(colors)
  println(colors.contains("black"))
  println(colors("black"))

  println(colors("red"))

  val color: (String, String) = "green" -> "#339616"
  val newColors: Map[String, String] = colors + color

  println(newColors)

  println(colors.toList)
  println(List(("White", "#ffffff")).toMap)

  // Array

  val anArray: Array[String] = Array("h", "e", "l", "l", "o", ".")

  anArray(5) = "!"

  println(anArray.mkString("-"))

  val twoElements: Array[Boolean] = Array.ofDim[Boolean](2)
  twoElements.foreach(println)

  val numbersSeq: Seq[String] = anArray
  println(numbersSeq)

  // Tuple

  val aTuple: (Int, String) = (100, "Scala")
  val sameTuple: (Int, String) = Tuple2(100, "Scala")

  println(aTuple)

  println(aTuple._1)
  println(aTuple._2)

  val copy: (Int, String) = aTuple.copy(_2 = "Python")

  println(aTuple.swap)

  // Range

  val aRange: Seq[Int] = 1 until 3
  aRange.foreach(print)

  (1 to 3).foreach(x => print("Hello"))

  val aRangeToVector: Vector[Int] = (1 to 5).toVector
  println(aRangeToVector)

  // foreach - тот же map, но на вход ему подается функция, которая возвращает Unit

  val list = List(1, 2, 3)
  list.foreach(print)

  for {
    n <- list
  } print(n)

  // map flatMap filter

  val fruits = List("apple", "banana")

  val mapResult = fruits.map(_.toUpperCase)
  val flatResult = fruits.flatMap(_.toUpperCase)

  println(mapResult) // List(APPLE, BANANA)
  println(flatResult) // List(A, P, P, L, E, B, A, N, A, N, A)

  val s = "Hello"
  val newStr: String = s.flatMap(c => (c + "."))
  println(newStr) // H.e.l.l.o.

  println(s.map(c => (c + "."))) // ArraySeq(H., e., l., l., o.)

  val list1 = List(1, 2)
  val list2 = List("a", "b")

  val FilterCombination = list1.filter(_ > 1).flatMap(n => list2.map(c => c + n))
  println(FilterCombination)

  val progLanguages = List("java", "scala", "python")
  val lngAbbrev = List("JA", "SCA", "PY")

  val out = progLanguages.flatMap(lng => lngAbbrev.filter(abrv => lng.startsWith(abrv.toLowerCase)).map(abrv => (abrv, lng)))

  val sampleTuple = new Tuple2(2, "Hello, World")
  println(sampleTuple.copy(_2 = "Scala").swap._1 + 5)
}
