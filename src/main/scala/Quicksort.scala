object Quicksort {
  def sort(list: List[Int]): List[Int] = {
    if (list.size > 1) {
      val less = List[Int]()
      val equal = List[Int]()
      val greater = List[Int]()
      val pivot = list.head

      for (item <- list) {
        if (item < pivot) less ++ List(item)
        if (item == pivot) equal ++ List(item)
        if (item > pivot) greater ++ List(item)
      }
      sort(less) ++ equal ++ greater
    }
    else list
  }
}
