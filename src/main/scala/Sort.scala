trait Sort {
  def sort(list: List[Int]): List[Int]

  def apply(list: List[Int]): List[Int] = {
    sort(list)
  }
}
