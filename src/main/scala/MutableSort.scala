import scala.collection.mutable.ListBuffer

trait MutableSort {
  def swap(leftIndex: Int, rightIndex: Int, list: ListBuffer[Int]) = {
    val leftItem = list(leftIndex)
    val rightItem = list(rightIndex)
    list.update(leftIndex, rightItem)
    list.update(rightIndex, leftItem)
  }
}
