package kata02

import org.scalatest._

/**
 * @author y079883
 */
class KarateChopSuite extends FunSuite {
  import KarateChop._
  
  val chop = recursiveChop _
  val test = Vector(0)
  
  test("test functional chop 1") {
    assert(chop(3, Vector()) == -1)
  }
  test("test functional chop 2") {
    assert(chop(3, Vector(1)) == -1)
  }
  test("test functional chop 3") {
    assert(chop(1, Vector(1)) == 0)
  }
  test("test functional chop 4") {
    assert(chop(1, Vector(1, 3, 5)) == 0)
  }
  test("test functional chop 5") {
    assert(chop(3, Vector(1, 3, 5)) == 1)
  }
  test("test functional chop 6") {
    assert(chop(5, Vector(1, 3, 5)) == 2)
  }
  test("test functional chop 7") {
    assert(chop(0, Vector(1, 3, 5)) == -1)
  }
  test("test functional chop 8") {
    assert(chop(2, Vector(1, 3, 5)) == -1)
  }
  test("test functional chop 9") {
    assert(chop(4, Vector(1, 3, 5)) == -1)
  }
  test("test functional chop 10") {
    assert(chop(6, Vector(1, 3, 5)) == -1)
  }
  test("test functional chop 11") {
    assert(chop(1, Vector(1, 3, 5, 7)) == 0)
  }
  test("test functional chop 12") {
    assert(chop(3, Vector(1, 3, 5, 7)) == 1)
  }
  test("test functional chop 13") {
    assert(chop(5, Vector(1, 3, 5, 7)) == 2)
  }
  test("test functional chop 14") {
    assert(chop(7, Vector(1, 3, 5, 7)) == 3)
  }
  test("test functional chop 15") {
    assert(chop(0, Vector(1, 3, 5, 7)) == -1)
  }
  test("test functional chop 16") {
    assert(chop(2, Vector(1, 3, 5, 7)) == -1)
  }
  test("test functional chop 17") {
    assert(chop(4, Vector(1, 3, 5, 7)) == -1)
  }
  test("test functional chop 18") {
    assert(chop(6, Vector(1, 3, 5, 7)) == -1)
  }
  test("test functional chop 19") {
    assert(chop(8, Vector(1, 3, 5, 7)) == -1)
  }
  
  test("big list: first element") {
    assert(chop(0, Vector.range(0, 1000000)) == 0)
  }
  
  test("big list: last element") {
    assert(chop(1000000 - 1, Vector.range(0, 1000000)) == 1000000 - 1)
  }
}