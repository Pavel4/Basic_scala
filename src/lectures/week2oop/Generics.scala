package lectures.week2oop

object Generics extends App {
  class MyList[A]

  val listOfStrings = new MyList[String]
  val listOfDoubles = new MyList[Double]
  val listOfInts = new MyList[Int]

  def randomItem[A](items: List[A]): A = {
    val randomIndex = util.Random.nextInt(items.length)
    items(randomIndex)
  }

  println(randomItem(List("a", "bc", "def")))
  println(randomItem(List(1.5, 2.75, 3.8)))


  class Fruit

  class Apple extends Fruit

  class Banana extends Fruit

  class InvariantList[A]

  val invariantFruitList: InvariantList[Fruit] = new InvariantList[Fruit]

  class ContravariantList[-A]

  val contravariantList: ContravariantList[Apple] = new ContravariantList[Fruit]

  class CovariantList[+A]

  val fruitList: CovariantList[Fruit] = new CovariantList[Apple]

  class Food2[T <: Fruit](fruit: T) // Верхнее ограничение типов

  class Food3[T >: Fruit](fruit: T)  // Нижнее ограничение типов. Теперь в качестве типа T нам подходят только супертипы типа Fruit.
}
