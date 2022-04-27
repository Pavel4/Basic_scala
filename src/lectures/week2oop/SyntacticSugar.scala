package lectures.week2oop

import scala.language.postfixOps

object SyntacticSugar extends App {
  class Person(val name: String, occupation: String) {
    def worksAs(jobName: String): String = s"$name is a $jobName"

    def isDeveloper = this worksAs("Scala Developer")

    def speaksEnglish: Boolean = true

    def &(person: Person): String = s"${this.name} and ${person.name} are colleagues"

    def unary_! : String = s"$name is not real"

    def apply(): String = s"$name works as a $occupation"
  }


  val bob = new Person("Bob", "Developer")

  println(bob.apply())
  println(bob()) // используется наболее часто

  println(bob isDeveloper)
}
