package pgrmfail

class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {

        val answer: MutableMap<Int, Int> = HashMap()

        for (i in 1..N) {
            answer[i] = 0
        }

        val tried = IntArray(N + 2)

        for (stage in stages) {
            answer.computeIfPresent(stage) { _, value -> value + 1 }
            tried[stage]++
        }

        for (i in (1..N + 1).reversed()) {
            tried[i - 1] = tried[i] + tried[i - 1]
        }

        val entries = answer.entries.sortedWith(compareBy({ -calc(it.value, tried[it.key]) }, { it.key }))

        val ans = mutableListOf<Int>()

        for (entry in entries) {
            ans.add(entry.key)
        }

        return ans.toIntArray()
    }

    fun calc(failed: Int, tried: Int): Double {
        if (tried == 0) {
            return 0.0
        }
        return failed / tried.toDouble()
    }

}
