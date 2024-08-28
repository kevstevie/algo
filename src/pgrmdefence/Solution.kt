package pgrmdefence

import java.util.*

class Solution {
    fun solution(n: Int, k: Int, enemy: IntArray): Int {
        var answer: Int = 0
        val q: PriorityQueue<Int> = PriorityQueue(reverseOrder())
        var life = n
        var count = k

        for (i in enemy) {
            life -= i
            q.offer(i)
            if (life < 0) {
                if (q.isNotEmpty() && count > 0) {
                    val poll = q.poll()
                    life += poll
                    count--
                }
            }
            if (life < 0) {
                break
            }
            answer++
        }
        return answer

    }
}
