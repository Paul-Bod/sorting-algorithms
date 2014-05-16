import scala.collection.mutable.ListBuffer

object Bubblesort extends MutableSort {
  def sort(list: ListBuffer[Int]): Unit = {
    pass(list, list.size)
  }

  private def pass(list: ListBuffer[Int], size: Int) {
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
