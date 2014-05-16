import collection.mutable.ListBuffer

class InPlaceQuicksortSpec extends UnitSpec {

  "InPlaceQuicksort" should "sort a list of Integers" in {
    val list = ListBuffer(3, 2, 1, 5, 4)
    val sortedList = ListBuffer(1, 2 ,3, 4, 5)
    InPlaceQuicksort.sort(list)
    list should equal(sortedList)
  }

  it should "sort already sorted lists" in {
    val list = ListBuffer(1, 2, 3, 4, 5)
    val sortedList = ListBuffer(1, 2 ,3, 4, 5)
    InPlaceQuicksort.sort(list)
    list should equal(sortedList)
  }

  it should "sort lists with repeated elements" in {
    val list = ListBuffer(6, 4 ,2, 2, 2, 3)
    val sortedList = ListBuffer(2, 2 ,2, 3, 4, 6)
    InPlaceQuicksort.sort(list)
    list should equal(sortedList)
  }

  it should "sort a single member list" in {
    val list = ListBuffer(1)
    val sortedList = ListBuffer(1)
    InPlaceQuicksort.sort(list)
    list should equal(sortedList)
  }

  it should "sort an empty list" in {
    val list = ListBuffer.empty[Int]
    val sortedList = ListBuffer.empty[Int]
    InPlaceQuicksort.sort(list)
    list should equal(sortedList)
  }
}
