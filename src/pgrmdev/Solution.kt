package pgrmdev

import java.util.*

class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = mutableListOf<Int>()

        var q: Queue<Node> = LinkedList()

        for (i: Int in progresses.indices) {
            q.add(Node(progresses[i], speeds[i]))
        }

        while (q.isNotEmpty()) {
            for (node in q) {
                node.go()
            }
            var i = 0;
            while (q.isNotEmpty() && q.peek().pr >= 100) {
                i++
                q.poll()
            }
            if (i != 0) {
                answer.add(i);
            }
        }

        return answer.toIntArray()
    }

    class Node(var pr: Int, var speed: Int) {
        fun go() {
            this.pr += this.speed
        }
    }
}
