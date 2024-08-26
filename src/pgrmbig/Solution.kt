package pgrmbig

import java.util.*

class Solution {
    fun solution(number: String, k: Int): String {
        val q = PriorityQueue<Digit>(kotlin.Comparator.comparing { it.number })
        var count = k
        loop@ for (c in number.indices) {
            while (q.isNotEmpty() && q.peek().number < number[c].toNum() && count > 0) {
                q.poll()
                count--
            }
            q.offer(Digit(number[c].toNum(), c))
        }

        while (count-- > 0) {
            q.poll()
        }

        val result = q.toMutableList()
        result.sortBy { it.digit }

        return result.map { it -> it.number }.joinToString("") { it.toString() }

    }

    class Digit(val number: Int, val digit: Int)
}

fun Char.toNum(): Int {
    return this.toString().toInt()
}
