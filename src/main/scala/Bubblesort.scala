import scala.collection.mutable.ListBuffer

object Bubblesort extends MutableSort {



  def sort(list: ListBuffer[Int]): Unit = {
    val size = list.size
    var swapped = false

    for (i <- 1 to size -1) {
      if (list(i-1) > list(i)) {
        swapped = true
        swap(i-1, i, list)
      }
    }

    if (swapped) {
      sort(list)
    }
  }
}
