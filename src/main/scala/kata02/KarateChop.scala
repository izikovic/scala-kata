package kata02

/**
 * @author y079883
 */
object KarateChop {

  def timeIt(f: => Unit) = {
    val start = System.currentTimeMillis()
    f
    val end = System.currentTimeMillis()
    println("time: %s".format((end - start)))
  }

  def functionalChop(x: Int, list: Vector[Int]): Int = {

    val half = list.size / 2

    if (list.size == 0) -1
    else if (list(half) == x) half
    else if (x < list(half)) functionalChop(x, list take half)
    else {
      val r = functionalChop(x, list drop (half + 1))
      if (r == -1) r
      else half + r + 1
    }

  }

  def iterativeChop(x: Int, list: Vector[Int]): Int = {
    if (list.size > 0) {
      val s = list.size
      var b = 0
      var e = s - 1
      var i = s / 2

      do {
        if (x == list(i)) return i
        else if (x < list(i)) {
          e = i - 1
          i = (e + b) / 2
        } else {
          b = i + 1
          i = (e + b) / 2
        }
      } while (e >= b)
    }
    -1
  }
  
  def recursiveChop(x: Int, list: Vector[Int]): Int = {
    def recursive(x: Int, b: Int, e: Int, list: Vector[Int]): Int = {
      val half = (e + b) / 2
      
      if (e < b) -1
      else if (x == list(half)) half
      else if (x < list(half)) recursive(x, b, half - 1, list)
      else recursive(x, half + 1, e, list)    
    }
    
    recursive(x, 0, list.size - 1, list)
  }
}