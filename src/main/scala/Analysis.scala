import java.util.concurrent.TimeoutException
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}
import ExecutionContext.Implicits.global

object Analysis {
  def run(list: List[Int], timeout: Option[Int] = None) {
    println("Analysing list")
    println("============================")
    new Thread ( new SortRunner("Bubblesort", list, timeout)).start
    new Thread ( new SortRunner("Mergesort", list, timeout)).start
    new Thread ( new SortRunner("SimpleQuicksort", list, timeout)).start
    new Thread ( new SortRunner("InPlaceQuicksort", list, timeout)).start
  }
}

class SortRunner(label: String, list: List[Int], timeout: Option[Int]) extends Runnable {
  override def run() {
    val sorter = label match {
      case "Bubblesort" => Bubblesort
      case "Mergesort" => Mergesort
      case "SimpleQuicksort" => SimpleQuicksort
      case "InPlaceQuicksort" => InPlaceQuicksort
      case _ => throw new Exception("Must specify a valid MutableSort algorithm")
    }

    try {
      val start = System.currentTimeMillis()

      timeout match {
        case Some(x) => Await.result(Future {
          sorter(list)
        }, Duration.create(x, "s"))
        case None => sorter(list)
      }

      val stop = System.currentTimeMillis()
      println(s"$label took ${stop - start}ms")
    }
    catch {
      case e: TimeoutException => println(s"$label timed out after 10 seconds")
    }
  }
}

