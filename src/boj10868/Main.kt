package boj10868

import kotlin.math.ceil
import kotlin.math.log

fun main() {
    val s = readln().split(" ").map { it.toInt() }

    val n = s[0]
    val m = s[1]

    arr = IntArray(n + 1)
    val h = ceil(log((n + 1).toDouble(), 2.0)).toInt() + 1
    seg = IntArray(1 shl h)

    for (i in 1..n) {
        arr[i] = readln().toInt()
    }

    init(1, 1, n)
    val sb = StringBuilder()
    repeat(m) {
        val q = readln().split(" ").map { it.toInt() }
        sb.append(find(1, 1, n, q[0], q[1])).append("\n")
    }

    println(sb)
}

lateinit var arr: IntArray
lateinit var seg: IntArray

fun init(node: Int, start: Int, end: Int) {
    if (start == end) {
        seg[node] = arr[start]
    } else {
        init(node * 2, start, (start + end) / 2)
        init(node * 2 + 1, (start + end) / 2 + 1, end)
        seg[node] = seg[node * 2].coerceAtMost(seg[node * 2 + 1])
    }
}

fun find(node: Int, start: Int, end: Int, left: Int, right:Int): Int {
    if (right < start || end < left) {
        return Int.MAX_VALUE
    }

    if (left<= start && end <= right) {
        return seg[node]
    }

    val l = find(node * 2, start, (start + end) / 2, left, right)
    val r = find(node * 2 + 1, (start + end) / 2 + 1, end, left, right)
    return l.coerceAtMost(r)
}
