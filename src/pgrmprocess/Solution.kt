package pgrmprocess

import java.util.LinkedList
import java.util.Queue

class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        var answer = 0
        val parr = IntArray(10)
        var pmax = 0
        val q:Queue<Node> = LinkedList()

        for (i in priorities.indices) {
            parr[priorities[i]]++
            pmax = pmax.coerceAtLeast(priorities[i])
            q.offer(Node(priorities[i], i))
        }

        while (q.isNotEmpty()) {
            val now = q.poll()
            if (pmax == now.pr) {
                answer++
                parr[now.pr]--
                if (parr[now.pr] == 0) {
                    for (i in (1..now.pr).reversed()) {
                        if (parr[i] != 0) {
                            pmax = i
                            break
                        }
                    }
                }
                if (now.loc == location) {
                    return answer
                }
            } else {
                q.offer(now)
            }
        }

        return answer
    }

    class Node(val pr:Int, val loc:Int)
}
