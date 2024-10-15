package pgrmemo


class Solution {
    fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
        val answer = mutableListOf<IntArray>()

        val dis = intArrayOf(10, 20, 30, 40)

        val sel = IntArray(emoticons.size)

        recur(0, sel, users, dis, emoticons, answer)

        val sorted = answer.sortedWith(compareBy({ -it[0] }, { -it[1] }))
        return sorted.first()
    }

    fun recur(
        idx: Int,
        sel: IntArray,
        users: Array<IntArray>,
        dis: IntArray,
        emoticons: IntArray,
        answer: MutableList<IntArray>
    ) {
        if (idx >= sel.size) {
            calc(users, sel, dis, emoticons, answer)
            return
        }
        for (i in 0..3) {
            recur(idx + 1, sel, users, dis, emoticons, answer)
            sel[idx] = i
            recur(idx + 1, sel, users, dis, emoticons, answer)
        }
    }

    private fun calc(
        users: Array<IntArray>,
        sel: IntArray,
        dis: IntArray,
        emoticons: IntArray,
        answer: MutableList<IntArray>
    ) {
        var c = 0
        var ma = 0
        for (i in users) {
            var sum = 0
            for (j in sel.indices) {
                val disc = sel[j]
                if (dis[disc] >= i[0]) {
                    sum += emoticons[j] * (100 - dis[disc]) / 100
                }
            }
            if (sum >= i[1]) {
                c++
            } else {
                ma += sum
            }
        }
        answer.add(intArrayOf(c, ma))
    }
}
