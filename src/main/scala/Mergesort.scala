import scala.collection.mutable.ListBuffer

object Mergesort extends Sort {
  def sort(list: List[Int]): List[Int] = {
    if (list.size > 1) {
      val (left, right) = list.splitAt(list.size / 2)
      merge(sort(left), sort(right), ListBuffer.empty[Int])
    }
    else list
  }

  private def merge(left: List[Int], right: List[Int], destination: ListBuffer[Int]): List[Int] = {
    val leftSize = left.size
    val rightSize = right.size

    if (leftSize > 0 && rightSize > 0) {
      val firstLeft = left.head
      val firstRight = right.head

      if (firstLeft <= firstRight) {
        destination += firstLeft
        merge(left.tail, right, destination)
      }
      else {
        destination += firstRight
        merge(left, right.tail, destination)
      }
    }
    else if (leftSize > 0) {
      destination += left.head
      merge(left.tail, right, destination)
    }
    else if (rightSize > 0) {
      destination += right.head
      merge(left, right.tail, destination)
    }

    destination.toList
  }
}
