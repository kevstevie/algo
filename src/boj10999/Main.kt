package boj10999

import kotlin.math.ceil
import kotlin.math.log

fun main() {
    val s = readln().split(" ").map { it.toInt() }
    val n = s[0]
    val m = s[1] + s[2]

    val h = ceil(log((n + 1).toDouble(), 2.0)).toInt() + 1
    arr = LongArray(n + 1)
    seg = LongArray(1 shl h)
    lazy = LongArray(1 shl h)
    for (i in 1..n) {
        val j = readln().toLong()
        arr[i] = j
    }

    init(1, 1, n)

    val sb = StringBuilder()
    repeat(m) {
        val q = readln().split(" ")
        if (q[0] == "1") {
            updateRange(1, 1, n, q[1].toInt(), q[2].toInt(), q[3].toLong())
        } else {
            sb.append(find(1, 1, n, q[1].toInt(), q[2].toInt())).append("\n")
        }
    }
    println(sb)

}

lateinit var arr: LongArray
lateinit var seg: LongArray
lateinit var lazy: LongArray

fun init(node: Int, start: Int, end: Int) {
    if (start == end) {
        seg[node] = arr[start]
    } else {
        init(node * 2, start, (start + end) / 2)
        init(node * 2 + 1, (start + end) / 2 + 1, end)
        seg[node] = seg[node * 2] + seg[node * 2 + 1]
    }
}

fun update(node: Int, start: Int, end: Int, left: Int, right: Int) {
    if (lazy[node] != 0L) {
        seg[node] += (end - start + 1) * lazy[node]
        if (start != end) {
            lazy[node * 2] += lazy[node]
            lazy[node * 2 + 1] += lazy[node]
        }
        lazy[node] = 0
    }
}

fun updateRange(node: Int, start: Int, end: Int, left: Int, right: Int, to: Long) {
    update(node, start, end, left, right)
    if (left > end || right < start) {
        return
    }
    if (left <= start && end <= right) {
        seg[node] += (end - start + 1) * to
        if (start != end) {
            lazy[node * 2] += to
            lazy[node * 2 + 1] += to
        }
        return
    }
    updateRange(node * 2, start, (start + end) / 2, left, right, to)
    updateRange(node * 2 + 1, (start + end) / 2 + 1, end, left, right, to)
    seg[node] = seg[node * 2] + seg[node * 2 + 1]

}

fun find(node: Int, start: Int, end: Int, left: Int, right: Int): Long {
    update(node, start, end, left, right)
    if (left > end || right < start) {
        return 0
    }
    if (left <= start && end <= right) {
        return seg[node]
    }
    val l = find(node * 2, start, (start + end) / 2, left, right)
    val r = find(node * 2 + 1, (start + end) / 2 + 1, end, left, right)
    return l + r
}
