import scala.collection.mutable.Buffer

trait MutableSort {
  def sort(list: List[Int]): List[Int]

  def apply(list: List[Int]): List[Int] = {
    sort(list)
  }

  def swap(leftIndex: Int, rightIndex: Int, list: Buffer[Int]) = {
    val leftItem = list(leftIndex)
    val rightItem = list(rightIndex)
    list.update(leftIndex, rightItem)
    list.update(rightIndex, leftItem)
  }
}
