import scala.collection.mutable.ListBuffer

class BubblesortSpec extends UnitSpec {
  "Bubblesort" should "sort a list of Integers" in {
    val list = List(6, 4 ,5, 2, 1, 3)
    val sortedList = List(1, 2 ,3, 4, 5, 6)
    Bubblesort(list) should equal(sortedList)
  }

  it should "sort already sorted lists" in {
    val list = List(1, 2, 3, 4, 5, 6)
    val sortedList = List(1, 2 ,3, 4, 5, 6)
    Bubblesort(list) should equal(sortedList)
  }

  it should "sort lists with repeated elements" in {
    val list = List(6, 4 ,2, 2, 2, 3)
    val sortedList = List(2, 2 ,2, 3, 4, 6)
    Bubblesort(list) should equal(sortedList)
  }

  it should "sort a single member list" in {
    val list = List(1)
    val sortedList = List(1)
    Bubblesort(list) should equal(sortedList)
  }

  it should "sort an empty list" in {
    val list = List.empty
    val sortedList = List.empty
    Bubblesort(list) should equal(sortedList)
  }
}
