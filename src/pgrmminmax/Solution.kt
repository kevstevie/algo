package pgrmminmax

class Solution {
    fun solution(s: String): String {
        val sorted = s.split(" ").map { it.toLong() }
            .sorted()


        return "${sorted[0]} ${sorted[sorted.size - 1]}"
    }
}
