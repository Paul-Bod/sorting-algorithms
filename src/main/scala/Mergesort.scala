import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

object Mergesort extends Sort {
  def sort(list: List[Int]): List[Int] = {
    if (list.size > 1) {
      val result = ListBuffer.empty[Int]
      val (left, right) = list.splitAt(list.size / 2)
      merge(sort(left), sort(right), result)
      result.toList
    }
    else list
  }

  @tailrec
  private def merge(left: List[Int], right: List[Int], destination: ListBuffer[Int]): Unit = {
    val leftSize = left.size
    val rightSize = right.size

    var newLeft = left
    var newRight = right

    if (leftSize > 0 || rightSize > 0) {
      if (leftSize > 0 && rightSize > 0) {
        val firstLeft = left.head
        val firstRight = right.head

        if (firstLeft <= firstRight) {
          destination += firstLeft
          newLeft = left.tail
        }
        else {
          destination += firstRight
          newRight = right.tail
        }
      }
      else if (leftSize > 0) {
        destination += left.head
        newLeft = left.tail
      }
      else if (rightSize > 0) {
        destination += right.head
        newRight = right.tail
      }

      merge(newLeft, newRight, destination)
    }
  }
}
