package pgrmmaze

import java.util.LinkedList
import java.util.Queue

class Solution {
    fun solution(maps: Array<String>): Int {
        var answer: Int = -1
        val arr = Array(maps.size) { CharArray(maps[0].length) }
        val q: Queue<Node> = LinkedList()
        var v = Array(maps.size) { BooleanArray(maps[0].length)}

        for (i in maps.indices) {
            for (j in maps[i].indices) {
                arr[i][j] = maps[i][j]
                if (arr[i][j] == 'S') {
                    q.offer(Node(i, j, 0, 'S'))
                    v[i][j] = true
                }
            }
        }
        val dx = intArrayOf(0, 1, 0, -1)
        val dy = intArrayOf(1, 0, -1, 0)


        while (q.isNotEmpty()) {
            val now = q.poll()
            if (now.value == 'L') {
                q.clear()
                q.offer(Node(now.x, now.y, now.dis, 'L'))
                v = Array(maps.size) { BooleanArray(maps[0].length)}
                break
            }
            for (i in 0..3) {
                val xx = now.x + dx[i]
                val yy = now.y + dy[i]

                if (xx >= arr.size || xx < 0 || yy >= arr[0].size || yy < 0 || v[xx][yy] || arr[xx][yy].blocked()) {
                    continue
                }
                q.offer(Node(xx, yy, now.dis + 1, arr[xx][yy]))
                v[xx][yy] = true
            }
        }

        while (q.isNotEmpty()) {
            val now = q.poll()
            if (now.value == 'E') {
                answer = now.dis
                break
            }
            for (i in 0..3) {
                val xx = now.x + dx[i]
                val yy = now.y + dy[i]

                if (xx >= arr.size || xx < 0 || yy >= arr[0].size || yy < 0 || v[xx][yy] || arr[xx][yy].blocked()) {
                    continue
                }
                q.offer(Node(xx, yy, now.dis + 1, arr[xx][yy]))
                v[xx][yy] = true
            }
        }

        return answer
    }

    class Node(val x:Int, val y:Int, val dis:Int, val value: Char)
}

fun Char.blocked(): Boolean {
    return this == 'X'
}
