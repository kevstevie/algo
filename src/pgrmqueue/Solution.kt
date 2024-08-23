package pgrmqueue

import java.util.LinkedList
import java.util.Queue

class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        var answer = 0

        var sum1 = 0L
        var sum2 = 0L

        val q1:Queue<Int> = LinkedList()
        val q2:Queue<Int> = LinkedList()

        for (i in queue1) {
            q1.offer(i)
            sum1 += i
        }
        for (i in queue2) {
            q2.offer(i)
            sum2 += i
        }

        while (answer <= queue1.size * 3) {
            if (sum1 == sum2) {
                return answer
            }
            answer++
            if (sum1 > sum2) {
                if (q1.isEmpty()) {
                    break
                }
                val poll = q1.poll()
                sum1 -= poll
                sum2 += poll
                q2.offer(poll)
            } else {
                if (q2.isEmpty()) {
                    break
                }
                val poll = q2.poll()
                sum1 += poll
                sum2 -= poll
                q1.offer(poll)
            }
        }

        return -1
    }
}
