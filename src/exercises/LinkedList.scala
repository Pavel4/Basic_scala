package exercises

object LinkedList extends App {
  abstract class LogList {
    def last: String

    def previous: LogList

    def isEmpty: Boolean

    def all: String

    def add(msg: String): LogList
  }

  class Log(head: String, tail: LogList) extends LogList {
    override def add(msg: String): LogList = new Log(msg, this)

    override def previous: LogList = tail

    override def last: String = head

    override def isEmpty: Boolean = false

    override def all: String = {
      def loop(head: String, tail: LogList, accumulator: String = ""): String = {
        if (tail.isEmpty) accumulator + head
        else loop(tail.last, tail.previous, accumulator + head + " ")
      }

      loop(this.head, this.tail)
    }
  }

  object Empty extends LogList {
    override def add(msg: String): LogList = new Log(msg, Empty)

    override def previous: LogList = throw new NoSuchElementException

    override def last: String = throw new NoSuchElementException

    override def all: String = ""

    override def isEmpty: Boolean = true
  }


  val log = new Log("m0", new Log("m1", new Log("m2", new Log("m3", Empty))))
  print(log.all)
}

