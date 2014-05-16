object Analysis {
  def run(list: List[Int]) {
    println("Analysing list")
    println("============================")
    new Thread ( new SortRunner("Bubblesort", list)).start
    new Thread ( new SortRunner("Mergesort", list)).start
    new Thread ( new SortRunner("SimpleQuicksort", list)).start
    new Thread ( new SortRunner("InPlaceQuicksort", list)).start
  }
}

class SortRunner(label: String, list: List[Int]) extends Runnable {
  override def run() {
    val sorter = label match {
      case "Bubblesort" => Bubblesort
      case "Mergesort" => Mergesort
      case "SimpleQuicksort" => SimpleQuicksort
      case "InPlaceQuicksort" => InPlaceQuicksort
      case _ => throw new Exception("Must specify a valid MutableSort algorithm")
    }
    val start = System.currentTimeMillis()
    sorter(list)
    val stop = System.currentTimeMillis()
    println(s"$label took ${stop - start}ms")
  }
}

