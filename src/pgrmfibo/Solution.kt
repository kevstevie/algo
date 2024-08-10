package pgrmfibo

class Solution {
    fun solution(n: Int): Int {
        val d = 1234567
        val arr = IntArray(n + 1) { 1 }

        for (i in 3..n) {
            arr[i] = (arr[i - 1] % d + arr[i - 2] % d) % d
        }


        return arr[n]
    }
}
