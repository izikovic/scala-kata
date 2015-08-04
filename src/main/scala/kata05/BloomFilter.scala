package kata05

import scala.collection.immutable.BitSet

/**
 * @author y079883
 */

class Spellchecker(dictionary: List[Word]) {

  class BloomFilter(hashNumber: Int, bitmapSize: Int) {
    require(hashNumber > 0)

    lazy val bitSet: BitSet = createBitSet(dictionary)

    def hash(word: Word): List[Int] = {
      import java.security.MessageDigest
      val bytes = MessageDigest.getInstance("MD5").digest(word.getBytes)

      val hashes =
        for {
          i <- 0 to bytes.length by (bytes.length / hashNumber + 1)
        } yield normalize(bytes(i))

      val hashList = hashes.toList
      assert(hashList.size == hashNumber)

      hashList
    }

    def normalize(n: Byte): Int = {
      (n - Byte.MaxValue) * (bitmapSize) / (Byte.MaxValue - Byte.MinValue)
    }

    def createWordBitSet(w: Word): BitSet = {
      val hashes = hash(w)
      BitSet((hashes map Math.abs): _*)
    }

    def createBitSet(words: List[Word]): BitSet = {
      def recursiveBitSet(words: List[Word], agg: BitSet): BitSet = words match {
        case Nil => agg
        case w :: ws => recursiveBitSet(ws, createWordBitSet(w) ++ agg)
      }
      recursiveBitSet(words, BitSet())
    }

    def contains(w: Word): Boolean = {
      (bitSet & createWordBitSet(w)) == createWordBitSet(w)
    }
  }

  val filter = new BloomFilter(NumberOfHashes, BitSetSize)

  def contains(w: Word) = filter.contains(w)

}