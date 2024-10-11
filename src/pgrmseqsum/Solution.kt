package pgrmseqsum

class Solution {
    fun solution(sequence: IntArray, k: Int): IntArray {
        val answer = mutableListOf<IntArray>()

        val arr = IntArray(sequence.size + 1)

        for (i in sequence.indices) {
            arr[i + 1] = sequence[i] + arr[i]
        }

        var l = 0
        var r = 1

        while (r < arr.size) {
            val sum = arr[r] - arr[l]
            if (sum == k) {
                answer.add(intArrayOf(l, r - 1, r - l))
            }
            if (sum < k) {
                r++
            } else {
                l++
            }
        }

        val sorted = answer.sortedBy { it[2] }

        return intArrayOf(sorted[0][0], sorted[0][1])
    }
}
