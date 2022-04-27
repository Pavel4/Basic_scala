import java.net.MalformedURLException
//import scala.sys.process.processInternal.{IOException, URL}
// Основы

5 + 10

"Hello".intersect("World")

"Bonjour".sorted // Вернет строку "Bjnooru"

BigInt.probablePrime(10, scala.util.Random)

val x = 5
val s = if (x > 0) 1 else -1

var y = 1
val z = y = 3

println(1.to(10))
1.to(10)


// Управляющие структуры и функции

var r = 1
for (i <- 1 to 10) {
  r = r * i
}

println(r)

var sum = 0
for (ch <- "Hello") sum += ch

for (i <- 1 to 3; j <- 1 to 3 if i != j) print(f"${10 * i + j}%3d")
// Выведет 12 13 21 23 31 32

for (i <- 1 to 3; from = 4 - i; j <- from to 3) print(f"${10 * i + j}%3d")
// Выведет 13 22 23 31 32 33

for (c <- "Hello"; i <- 0 to 1) yield (c + i).toChar
// Вернет "HIeflmlmop"
for (i <- 0 to 1; c <- "Hello") yield (c + i).toChar
// Вернет Vector('H', 'e', 'l', 'l', 'o', 'I', 'f', 'm', 'm', 'p')

def fac(n: Int) = {
  var r = 1
  for (i <- 1 to n) r = r * i
  r
}

def fac2(n: Int): Int = if (n <= 0) 1 else n * fac(n - 1)

def sum(args: Int*) = {
  var result = 0
  for (arg <- args) result += arg
  result
}

val s = sum(1 to 5: _*) // Интерпретировать 1 to 5
// как последовательность аргументов

// Процедура

def box(s: String) { // Смотрите внимательнее: здесь нет =
  val border = "-" * (s.length + 2)
  print(f"$border%n|$s|%n$border%n")
}

def box2(s: String): Unit = { // Явну укажем процедуре возвращаемый тип
  ???
}


val words = "Hello"
// Вычисляется немедленно, в момент определения words

lazy val words = "Hello".toUpperCase()
// Вычисляется при первом обращении к words

def words = "Hello"
// Вычисляется всякий раз, когда происходит обращение к words

if (x >= 0) {
  scala.math.sqrt(x)
} else throw new IllegalArgumentException("x should not be negative")

/*
val url = new URL("http://horstmann.com/fred-tiny.gif")
def process(url: URL) = ???
try {
  process(url)
} catch {
  case _: MalformedURLException => println(s"Bad URL: $url")
  case ex: IOException => ex.printStackTrace()
}

val in = new URL("http://horstmann.com/fred.gif").openStream()
try {
  process(in)
} finally {
  in.close()
}

try { ... } catch { ... } finally { ... }

*/

// Массивы,ассоциативныемассивы и кортежи

val nums = new Array[Int](10)
// Массив с десятью целыми числами, инициализированными нулями
val a = new Array[String](10)
// Массив с десятью элементами, инициализированными значением null
val s = Array("Hello", "World")
// Массив типа Array[String] с длиной 2 – тип выводится компилятором
// Заметьте: при наличии начальных значений слово new не используется
s(0) = "Goodbye"
// Массив Array("Goodbye", "World")
// Для доступа к элементам используйте () вместо []

import scala.collection.mutable.ArrayBuffer

val b = ArrayBuffer[Int]()
// Или new ArrayBuffer[Int]
// Пустой буфер, подготовленный для хранения целых чисел
b += 1
// ArrayBuffer(1)
// Добавление элемента в конец с помощью +=
b += (1, 2, 3, 5)
// ArrayBuffer(1, 1, 2, 3, 5)
// Добавление в конец нескольких элементов, заключенных в скобки
b ++= Array(8, 13, 21)
// ArrayBuffer(1, 1, 2, 3, 5, 8, 13, 21)
// С помощью оператора ++= можно добавить в конец любую коллекцию
b.trimEnd(5)
// ArrayBuffer(1, 1, 2)
// Удаление последних пяти элементов
b.insert(2, 6)
// ArrayBuffer(1, 1, 6, 2)
// Вставка элемента в позицию с индексом 2
//b.insert(2, 7, 8, 9)
// ArrayBuffer(1, 1, 7, 8, 9, 6, 2)
// Можно вставить любое количество элементов
//b.remove(2)
// ArrayBuffer(1, 1, 8, 9, 6, 2)
//b.remove(2, 3)
// ArrayBuffer(1, 1, 2)
// Второй параметр определяет количество удаляемых элементов
/*
for (i <- 0 until a.length)
  println(s"$i: ${a(i)}")

for (i <- a.indices)
  println(s"$i: ${a(i)}")

for (elem <- a)
  println(elem)

val a = Array(2, 3, 5, 7, 11)
val result = for (elem <- a) yield 2 * elem
*/

// результат: Array(4, 6, 10, 14, 22)

//Примечание. Ту же задачу можно решить иначе:
val a = Array(1, 7, 2, 9)
a.filter(_ % 2 == 0).map(2 * _)

Array(1, 7, 2, 9).sum

ArrayBuffer("Mary", "had", "a", "little", "lamb").max
// "little"

val b = ArrayBuffer(1, 7, 2, 9)
// val bSorted = b.sorted(_ < _)
// b не изменился; bSorted - это ArrayBuffer(1, 2, 7, 9)

val bDescending = b.sortWith(_ > _) // ArrayBuffer(9, 7, 2, 1)

val a = Array(1, 7, 2, 9)
scala.util.Sorting.quickSort(a)
// a – теперь Array(1, 2, 7, 9)

a.mkString(" and ")
// "1 and 2 and 7 and 9"
a.mkString("<", ",", ">")
// "<1,2,7,9>"

// стр. 64 Описание методов для Array и ArrayBuffer

// Многомерные массивы

val matrix = Array.ofDim[Double](3, 4) // Три строки, четыре столбца
// matrix(row)(column) = 42


// Ассоциативныемассивы и кортежи

val scores = Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)
val scores = new scala.collection.mutable.HashMap[String, Int]
val scores = scala.collection.mutable.Map("Alice" -> 10, "Bob" -> 3, "Cindy" -> 8)

val bobsScore = scores("Bob") // Подобно scores.get("Bob") в Java
val bobsScore = if (scores.contains("Bob")) scores("Bob") else 0 // Проверка наличия ключа

val bobsScore = scores.getOrElse("Bob", 0)
// Если ассоциативный массив содержит ключ "Bob",
// вернет значение; иначе вернет 0

scores("Bob") = 10
// Изменит значение существующего ключа "Bob" (предполагается, что
// scores – изменяемый ассоциативный массив)
scores("Fred") = 7
// Добавит новую пару ключ/значение в scores (предполагается, что
// scores – изменяемый ассоциативный массив)

scores += ("Bobik" -> 11, "Fredik" -> 8)

scores -= "Alice"

val newScores = scores + ("Bob" -> 10, "Fred" -> 7)
// Новый ассоциативный массив

scores.keySet // Множество, такое как Set("Bob", "Cindy", "Fred", "Alice")
//for (v <- scores.values) println(v) // Выведет 10 8 7 10,
// возможно в другом порядке

// for ((k, v) <- map) yield (v, k)


// Кортеж

val t = (1, 3.14, "Fred")
val second = t._2 // Присвоит переменной second значение 3.14

val (first, second, third) = t // Присвоит переменной first значение 1,
// second – 3.14, third – "Fred"

val (first, second, _) = t

"New York".partition(_.isUpper) // Вернет пару ("NY", "ew ork")

val symbols = Array("<", "-", ">")
val counts = Array(2, 10, 2)
val pairs = symbols.zip(counts)

for ((s, n) <- pairs) Console.print(s * n) // Выведет <<---------- >>

//keys.zip(values).toMap  // Можно упаковать пары в мап

// Классы и объекты

class Counter {
  private var value = 0 // Поля должны инициализироваться

  def increment() {
    value += 1
  } // Методы по умолчанию общедоступные

  def current() = value
}

val myCounter = new Counter // Или new Counter()
myCounter.increment()
println(myCounter.current)

myCounter.current // OK
myCounter.current() // Тоже OK

class Person {
  var age = 0
}

val fred = new Person
println(fred.age) // Вызовет метод fred.age()
fred.age = 21 // Вызовет метод fred.age_=(21)

println(fred.age)

class Person {
  private var privateAge = 0 // Сделать приватным и переименовать

  def age = privateAge

  def age_=(newValue: Int) {
    if (newValue > privateAge) privateAge = newValue;
    // Нельзя сделать моложе
  }
} // переопределение методов чтения и записи

val fred = new Person
fred.age = 30
fred.age = 21
println(fred.age) // 30

//Итак, на выбор имеются четыре варианта реализации свойств:
//1) var foo: Scala синтезирует методы чтения и записи;
//2) val foo: Scala синтезирует только метод чтения;
//3) вы определяете методы foo и foo_=;
//4) вы определяете метод foo.

class Counter {
  private var value = 0

  //private[this] var value = 0 // Обращение someObject.value недопустимо
  def increment() {
    value += 1
  }

  def isLess(other: Counter) = value < other.value
  // имеет доступ к приватному полю другого объекта
}
// стр.86 Методы генерируемые разными доступами

class Person {
  private var name = ""
  private var age = 0

  def this(name: String) { // Дополнительный конструктор
    this() // Вызов главного конструктора
    this.name = name
  }

  def this(name: String, age: Int) { // Другой дополнительный конструктор
    this(name) // Вызов предыдущего дополнительного конструктора
    this.age = age
  }
}

val p1 = new Person // Главный конструктор
val p2 = new Person("Fred") // Первый дополнительный конструктор
val p3 = new Person("Fred", 42) // Второй дополнительный конструктор
/*
class Person(val name: String, val age: Int) {
  // Параметры главного конструктора в (...)
  ...
}
*/

// class Person(val name: String = "", val age: Int = 0)
// Указываем значения по умолчанию, тогда не нужны доп конструкторы


// Объекты

object Accounts {
  private var lastNumber = 0

  def newUniqueNumber() = {
    lastNumber += 1;
    lastNumber
  }
}

// Объект-компаньон
class Account {
  val id = Account.newUniqueNumber()
  private var balance = 0.0

  def deposit(amount: Double) {
    balance += amount
  }

}

object Account { // Объект-компаньон
  private var lastNumber = 0

  private def newUniqueNumber() = {
    lastNumber += 1;
    lastNumber
  }
}

// Пакеты и импортирование

// import java.awt._    _ - импорт всех членов пакета

/* Импортирование возможно в любом месте и
   работает внутри блока

class Manager {
import scala.collection.mutable._
val subordinates = new ArrayBuffer[Employee]
...
}
 */

// import java.awt.{Color, Font}     - импорт указанных членов

// import java.util.{HashMap => JavaHashMap}   - переименование импортируемых членов

//  Неявный импорт

import java.lang._
import scala._
import Predef._


// Наследование

class Employee extends Person {
  var salary = 0.0

}

/*
// Переопределение метода

public class Person {
  ...
  override def toString = s"${getClass.getName}[name=$name]"
}

// Обращение к суперклассу через super

public class Employee extends Person {
  ...
  override def toString = s"${super.toString}[salary=$salary]"
}

// Проверка типов
if (p.isInstanceOf[Employee]) {
val s = p.asInstanceOf[Employee] // s имеет тип Employee
...
}


// Переопределение полей

abstract class Person { // Абстрактные классы рассматриваются в разделе 8.8
def id: Int // Каждый имеет идентификационный номер,
// который вычисляется некоторым способом
...
}
class Student(override val id: Int) extends Person
// Идентификационный номер студента просто передается конструктору

// стр. 121 Переопределение объявлений val, def, var

  // Анонимные подклассы

val alien = new Person("Fred") {
def greeting = "Greetings, Earthling! My name is Fred."
}
  // Абстрактные классы

abstract class Person(val name: String) {
def id: Int // Метод без тела - это абстрактный метод
}
 // Абстрактные поля

abstract class Person {
  val id: Int
    // Нет начального значения - абстрактное поле с абстрактным методом чтения
  var name: String
    // Другое абстрактное поле с абстрактными методами чтения/записи
}


 */


// Трейты

trait Logger {
  def log(msg: String): Unit // Абстрактный метод
}

class ConsoleLogger extends Logger { // extends, не implements
  def log(msg: String): Unit = {
    println(msg)
  } // override не нужно
}

//  Наследуем несколько трейтов
class ConsoleLogger2 extends Logger with Cloneable with Serializable {
  override def log(msg: String): Unit = ???
}

/*
abstract class SavingsAccount extends Account with Logger {
def withdraw(amount: Double) {
if (amount > balance) log("Insufficient funds")
else ...
}
...
}

trait ConsoleLogger extends Logger {
def log(msg: String) { println(msg) }
}

val acct = new SavingsAccount with ConsoleLogger

val acct2 = new SavingsAccount with FileLogger
10.5.

// Опережающее определение

val acct = new { // Блок опережающего определения после new
val filename = "myapp.log"
} with SavingsAccount with FileLogger

class SavingsAccount extends { // Опережающее определение после extends
val filename = "savings.log"
} with Account with FileLogger {
... // Реализация SavingsAccount
}


// Сможет подмешиваться только в подклассы указанного типа Type

trait LoggedException extends Logged {
this: Exception =>
def log() { log(getMessage()) }
}
 */


