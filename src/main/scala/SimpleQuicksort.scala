import collection.mutable.ListBuffer

object SimpleQuicksort {
  def sort(list: List[Int]): List[Int] = {
    if (list.size > 1) {
      val less = ListBuffer[Int]()
      val equal = ListBuffer[Int]()
      val greater = ListBuffer[Int]()
      val pivot = list.head

      for (item <- list) {
        if (item < pivot) {
          less.append(item)
        }
        if (item == pivot) {
          equal.append(item)
        }
        if (item > pivot) {
          greater.append(item)
        }
      }
      sort(less.toList) ++ equal ++ sort(greater.toList)
    }
    else list
  }
}
