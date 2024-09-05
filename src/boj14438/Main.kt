package boj14438

import kotlin.math.ceil
import kotlin.math.log

fun main() {
    val n = readln().toInt()
    arr = IntArray(n + 1)
    val s = readln().split(" ").map { it.toInt() }
    for (i in s.indices) {
        arr[i + 1] = s[i]
    }
    val h = ceil(log((n + 1).toDouble(), 2.0)).toInt() + 1
    seg = IntArray(1 shl h)
    init(1, 1, n)
    val m = readln().toInt()
    val sb = StringBuilder()
    repeat(m) {
        val q = readln().split(" ").map { it.toInt() }
        if (q[0] == 2) {
            val find = find(1, 1, n, q[1], q[2])
            sb.append("$find\n")
        } else {
            update(1, 1, n, q[1], q[2])
        }
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
        val l = seg[node * 2]
        val r = seg[node * 2 + 1]
        seg[node] = l.coerceAtMost(r)
    }
}

fun find(node: Int, start: Int, end: Int, left: Int, right: Int): Int {
    if (left > end || right < start) {
        return Int.MAX_VALUE
    }
    if (left <= start && end <= right) {
        return seg[node]
    }
    val l = find(node * 2, start, (start + end) / 2, left, right)
    val r = find(node * 2 + 1, (start + end) / 2 + 1, end, left, right)
    return l.coerceAtMost(r)
}

fun update(node: Int, start: Int, end: Int, idx: Int, to: Int) {
    if (idx < start || end < idx) {
        return
    }
    if (start == end) {
        arr[idx] = to
        seg[node] = to
        return
    }
    update(node * 2, start, (start + end) / 2, idx, to)
    update(node * 2 + 1, (start + end) / 2 + 1, end, idx, to)
    val l = seg[node * 2]
    val r = seg[node * 2 + 1]
    seg[node] = l.coerceAtMost(r)
}
