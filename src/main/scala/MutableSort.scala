import scala.collection.mutable.ListBuffer

trait MutableSort {
  def sort(list: ListBuffer[Int]): Unit

  def apply(list: ListBuffer[Int]) {
    sort(list)
  }

  def swap(leftIndex: Int, rightIndex: Int, list: ListBuffer[Int]) = {
    val leftItem = list(leftIndex)
    val rightItem = list(rightIndex)
    list.update(leftIndex, rightItem)
    list.update(rightIndex, leftItem)
  }
}
