package boj1987

import java.util.Stack

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val arr = Array(n) { IntArray(m) }

    for (i in 0..<n) {
        val col = readln()

        for (j in col.indices) {
            arr[i][j] = col[j] - 'A' + 1
        }
    }

    val st = Stack<Node>()
    st.push(Node(0, 0, 1 shl arr[0][0], 1))

    val dx = arrayOf(1, 0, -1, 0)
    val dy = arrayOf(0, 1, 0, -1)

    var ans = 0

    while (st.isNotEmpty()) {
        val cur = st.pop()
        ans = cur.dis.coerceAtLeast(ans)

        for (i in 0..3) {
            val xx = cur.x + dx[i]
            val yy = cur.y + dy[i]

            if (xx < 0 || xx >= n || yy < 0 || yy >= m) {
                continue
            }
            if ((1 shl arr[xx][yy]) and cur.v != 0) {
                continue
            }
            st.push(Node(xx, yy, cur.v or (1 shl arr[xx][yy]), cur.dis + 1))
        }
    }

    println(ans)
}

class Node(
    val x: Int,
    val y: Int,
    val v: Int,
    val dis: Int
)
