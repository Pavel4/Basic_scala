package lectures.week2oop

object ClassesOOP extends App {
  class Student(id: Int, val name: String) {
    def getId(name: String, id: Int): String =
      s"${this.name} has ID ${this.id} and $name has ID $id"

    def getId: String = s"here is $name's ID $id"
  }

  val student = new Student(1, "Sam")
  println(student.getId("Pam", 2))
  println(student.getId)

  class Instructor(val id: Int, name: String, surname: String) {
    def fullName: String = {
      def firstUpperCase(word: String): String = {
        word.substring(0, 1).toUpperCase() + word.substring(1)
      }

      firstUpperCase(Instructor.this.name) + " " + firstUpperCase(Instructor.this.surname)
    }
  }


  class Course(courseID: Int, title: String, var releaseYear: String, instructor: Instructor) {
    def getID: String = {
      courseID.toString + instructor.id
    }

    def isTaughtBy(instructor: Instructor): Boolean = {
      if (instructor.id == Course.this.instructor.id) true else false
    }

    def copyCourse(newReleaseYear: String): Course = {
      Course.this.releaseYear = newReleaseYear
      Course.this
    }
  }

  val Instructor = new Instructor(1, "Petya", "Pupkin")
  println(Instructor.fullName)

  val Course = new Course(24, "Math", "2000", Instructor)
  println(Course.getID)
  println(Course.isTaughtBy(Instructor))
  println((Course.copyCourse("2015")))
}

