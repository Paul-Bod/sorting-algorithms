import scala.collection.mutable.Buffer

object Bubblesort extends Sort {
  def sort(list: List[Int]): List[Int] = {
    val bufferedList = list.toBuffer
    pass(bufferedList, list.size)
    bufferedList.toList
  }

  private def pass(list: Buffer[Int], size: Int) {
    var lastSwapIndex = 0

    for (i <- 1 to size -1) {
      if (list(i-1) > list(i)) {
        lastSwapIndex = i
        swap(i-1, i, list)
      }
    }

    // all elements after lastSwapIndex are now sorted
    if (lastSwapIndex > 0) {
      pass(list, lastSwapIndex)
    }
  }
}
