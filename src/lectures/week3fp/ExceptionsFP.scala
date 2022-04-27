package lectures.week3fp

object ExceptionsFP extends App {

  import scala.util.Try

  def unsafeMethod(): String = throw new RuntimeException("Sorry, not your day")

  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure) // Failure(java.lang.RuntimeException: Sorry, not your day)

  val anotherPotentialFailure = Try {
    // код, содержащий исключения
  }

  println(potentialFailure.isSuccess) // false Проверяем, содержил ли метод исключения

  def unsafeMethod2(): String = throw new RuntimeException("Sorry, not your day")

  def myMethod(): String = "My method is valid"

  val executeWithTry = Try(unsafeMethod2()).orElse(Try(myMethod()))

  println(executeWithTry) // Success(My method is valid)


  import scala.util.{Try, Failure, Success}


  def methodWhichFails(): Try[String] = Failure(new RuntimeException("Ooops..."))

  def methodWhichSucceeds(): Try[String] = Success("Everything is OK")

  val tryMethods = methodWhichFails() orElse methodWhichSucceeds()

  println(tryMethods) // Success(Everything is OK)



}
