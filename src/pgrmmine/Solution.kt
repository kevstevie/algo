package pgrmmine

class Solution {

    fun solution(picks: IntArray, minerals: Array<String>): Int {
        var answer: Int = 0

        val sum = picks.reduce { a, b -> a + b }
        val range = sum * 5
        val r = range.coerceAtMost(minerals.size) - 1

        var arr = IntArray(3)
        var l = mutableListOf<Count>()

        val map = minerals.map {
            when (it) {
                "diamond" -> {
                    0
                }

                "iron" -> {
                    1
                }

                else -> {
                    2
                }
            }
        }

        for (i in 0..r) {
            arr[map[i]]++
            if (i % 5 == 4 || i == r) {
                l.add(Count(arr[0], arr[1], arr[2], i / 5))
                arr = IntArray(3)
            }
        }
        val ll = IntArray(l.size) { -1 }
        l.sortWith(compareBy(
            { -it.diamond },
            { -it.iron },
            { -it.stone }
        ))

        loop@ for (i in 0..2) {
            var idx = 0
            while (picks[i] != 0) {
                if (ll[l[idx].idx] != -1) {
                    idx++
                    if (idx >= l.size) {
                        continue@loop
                    }
                    continue
                }
                ll[l[idx].idx] = i
                picks[i]--
                idx++
                if (idx >= l.size) {
                    continue@loop
                }
            }
        }

        for (i in 0..r) {
            answer += fatigue(ll[i / 5], map[i])
        }

        return answer
    }

    fun fatigue(a: Int, b: Int): Int {
        if (a - b == 2) {
            return 25
        }
        if (a - b == 1) {
            return 5
        }
        return 1
    }

    class Count(val diamond: Int, val iron: Int, val stone: Int, val idx: Int)
}
