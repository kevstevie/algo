package pgrmhanoi

class Solution {
    fun solution(n: Int): Array<IntArray> {
        answer.clear()
        if (n == 1) {
            return Array(1) { intArrayOf(1, 3) }
        }
        moveTo(1, 3, 2, n)
        return answer.toTypedArray()
    }

    val answer = mutableListOf(IntArray(2))

    fun moveTo(start: Int, end: Int, mid: Int, n: Int) {
        if (n == 1) {
            answer.add(intArrayOf(start, end))
        } else {
            moveTo(start, mid, end, n - 1)
            moveTo(start, end, mid, 1)
            moveTo(mid, end, start, n - 1)
        }
    }
}
