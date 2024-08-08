package pgrmgym

class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = 0
        val arr = IntArray(n + 2) { 0 }
        for (i in lost) {
            arr[i]--
        }
        for (i in reserve) {
            arr[i]++
        }

        for (i in 1..n) {
            if (arr[i] == -1) {
                if (arr[i - 1] == 1) {
                    arr[i]++
                    arr[i - 1]--
                } else if (arr[i + 1] == 1){
                    arr[i]++
                    arr[i + 1]--
                }
            }
        }

        for (i in 1..n) {
            if (arr[i] >= 0) {
                answer++
            }
        }
        return answer
    }
}
