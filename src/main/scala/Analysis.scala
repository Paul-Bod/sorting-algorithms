object Analysis extends App {
  val list = List(1, 9 ,4, 6, 7)
  val listTwo = List(1)
  val listThree = List.empty
  println(SimpleQuicksort.sort(list))
  println(SimpleQuicksort.sort(listTwo))
  println(SimpleQuicksort.sort(listThree))
}