import collection.mutable.ListBuffer

object InPlaceQuicksort {
  private def partition(list: ListBuffer[Int], leftIndex: Int, rightIndex: Int, pivotIndex: Int) = {
    val pivotValue = list(pivotIndex)
    var storeIndex = leftIndex

    // temporarily move the pivot to the end of the section so its out of the way
    swap(pivotIndex, rightIndex, list)

    for (i <- leftIndex to rightIndex-1) {
      if (list(i) <= pivotValue) {
        swap(i, storeIndex, list)
        storeIndex += 1
      }
    }

    // move pivot to its final location
    swap(storeIndex, rightIndex, list)

    storeIndex
  }

  private def swap(leftIndex: Int, rightIndex: Int, list: ListBuffer[Int]) = {
    val leftItem = list(leftIndex)
    val rightItem = list(rightIndex)
    list.update(leftIndex, rightItem)
    list.update(rightIndex, leftItem)
  }

  private def quicksort(list: ListBuffer[Int], leftIndex: Int, rightIndex: Int): Unit = {
    if (leftIndex < rightIndex) {
      val pivotIndex = leftIndex
      val pivotNewIndex = partition(list, leftIndex, rightIndex, pivotIndex)

      quicksort(list, leftIndex, pivotNewIndex - 1)

      quicksort(list, pivotNewIndex + 1, rightIndex)
    }
  }

  def sort(list: ListBuffer[Int]) = {
    val leftIndex = 0
    val rightIndex = list.size - 1
    quicksort(list, leftIndex, rightIndex)
  }
}
