package pgrmseesaw

class Solution {
    fun solution(weights: IntArray): Long {
        var answer: Long = 0

        val arr = LongArray(1001)

        for (i in weights) {
            arr[i]++
        }

        for (i in 100..1000) {
            answer += arr[i] * (arr[i] - 1) / 2

            if (i % 3 == 0) {
                answer += arr[i * 2 / 3] * arr[i]
            }
            if (i % 2 == 0) {
                answer += arr[i / 2] * arr[i]
            }
            if (i % 4 == 0) {
                answer += arr[i * 3 / 4] * arr[i]
            }
        }

        return answer
    }
}
