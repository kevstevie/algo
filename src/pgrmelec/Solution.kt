package pgrmelec

import kotlin.math.abs

class Solution {

    lateinit var ar: IntArray
    lateinit var m: MutableMap<Int, Int>

    fun solution(n: Int, wires: Array<IntArray>): Int {
        var answer: Int = Integer.MAX_VALUE

        for (i in wires.indices) {
            ar = IntArray(n + 1) { it }
            m = HashMap()
            for (j in wires.indices) {
                if (j == i) {
                    continue
                }
                union(wires[j][0], wires[j][1])
            }
            for (j in 1..n) {
                count(j)
            }
            val ans = m.values.reduce { a, b -> abs(a - b) }
            answer = ans.coerceAtMost(answer)
        }
        return answer
    }

    fun union(a: Int, b: Int) {
        val aa = find(a)
        val bb = find(b)
        if (aa > bb) {
            ar[aa] = bb
        } else {
            ar[bb] = aa
        }
    }

    fun find(a: Int): Int {
        if (ar[a] == a) {
            return a
        }
        return find(ar[a])
    }

    fun count(a: Int) {
        val find = find(a)
        m[find] = m.getOrDefault(find, 0) + 1
    }
}

