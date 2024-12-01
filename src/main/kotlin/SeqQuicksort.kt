import Utils.swap

class SeqQuicksort<T: Comparable<T>> : Quicksort<T> {
  override fun sort(a: Array<T>): Array<T> = a.copyOf().also { it.step(0, it.size - 1) }

  private fun Array<T>.step(leftIndex: Int, rightIndex: Int) {
    if (leftIndex < rightIndex) {
      val pi = partition(leftIndex, rightIndex)
      step(leftIndex, pi - 1)
      step(pi + 1, rightIndex)
    }
  }

  private fun Array<T>.partition(leftIndex: Int, rightIndex: Int): Int {
    val pivot = this[rightIndex]
    var i = leftIndex - 1

    for (j in leftIndex until rightIndex) {
      if (this[j] <= pivot) {
        i++
        swap(i, j)
      }
    }
    swap(i + 1, rightIndex)

    return i + 1
  }
}