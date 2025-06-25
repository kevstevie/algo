package pgrmdecode

fun main() {
    val ans = Solution().solution(10, arrayOf(
        intArrayOf(1,2,3,4,5),
        intArrayOf(6, 7, 8, 9, 10),
        intArrayOf(3, 7, 8, 9, 10),
        intArrayOf(2, 5, 7, 9, 10),
        intArrayOf(3, 4, 5, 6, 7)
    ),
        intArrayOf(2, 3, 4, 3, 3)
    )

    println(ans)
}

class Solution {
    fun solution(n: Int, q: Array<IntArray>, ans: IntArray): Int {
        var answer: Int = 0

        val list = mutableListOf<IntArray>()

        init(n, list, 0, 1, IntArray(5))

        var filtered = list.toList()

        for (i in q.indices) {
            filtered = filtered.filter { filter(it, q[i], ans[i]) }
        }

        return filtered.size
    }

    private fun filter(it: IntArray, target: IntArray, ans: Int): Boolean {
        var res = 0
        for (i in it) {
            for (j in target) {
                if ( i == j) {
                    res++
                }
            }
        }
        return res == ans
    }

    private fun init(n: Int, list: MutableList<IntArray>, cnt: Int, idx: Int, memo: IntArray) {
        if (cnt == 5) {
            list.add(memo.copyOf())
            return
        }
        if (idx > n) {
            return
        }
        memo[cnt] = idx
        init(n, list, cnt + 1, idx + 1, memo)
        init(n, list, cnt, idx + 1, memo)
    }
}
