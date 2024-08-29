package pgrmile

import java.util.*

class Solution {
    fun solution(maps: Array<String>): IntArray {
        var answer = mutableListOf<Int>()

        val m = Array(maps.size) { IntArray(maps[0].length) }
        val v = Array(maps.size) { BooleanArray(maps[0].length) }

        for (i in maps.indices) {
            for (j in maps[i].indices) {
                m[i][j] = maps[i][j].convert()
            }
        }
        val dx = arrayOf(1, 0, -1, 0)
        val dy = arrayOf(0, 1, 0, -1)

        val q: Queue<Node> = LinkedList()
        for (i in m.indices) {
            for (j in m[0].indices) {
                if (v[i][j] || m[i][j] == 0) {
                    continue
                }
                var k = 0
                q.offer(Node(i, j))
                v[i][j] = true
                while (q.isNotEmpty()) {
                    val poll = q.poll()
                    k += m[poll.x][poll.y]
                    for (l in 0..3) {
                        val xx = poll.x + dx[l]
                        val yy = poll.y + dy[l]
                        if (xx < 0 || xx >= m.size || yy < 0 || yy >= m[0].size || v[xx][yy] || m[xx][yy] == 0) {
                            continue
                        }
                        q.offer(Node(xx, yy))
                        v[xx][yy] = true
                    }
                }
                answer.add(k)
            }
        }

        answer.sort()
        if (answer.isEmpty()) {
            return intArrayOf(-1)
        }
        return answer.toIntArray()
    }

    class Node(val x: Int, val y: Int)
}

fun Char.convert(): Int {
    if (this == 'X') {
        return 0
    }
    return this.toString().toInt()
}
