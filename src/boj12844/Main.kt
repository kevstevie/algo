package boj12844

import kotlin.math.ceil
import kotlin.math.log

fun main() {
    val n = readln().toInt()
    arr = IntArray(n + 1)
    val s = readln().split(" ").map { it.toInt() }
    for (i in 1..n) {
        arr[i] = s[i - 1]
    }
    val h = ceil(log((n + 1).toDouble(), 2.0)).toInt() + 1
    seg = IntArray(1 shl h)
    lazy = IntArray(1 shl h)

    init(1, 1, n)

    val m = readln().toInt()
    val sb = StringBuilder()
    repeat(m) {
        val q = readln().split(" ").map { it.toInt() }
        if (q[0] == 2) {
            sb.append(find(1, 1, n, q[1] + 1, q[2] + 1)).append("\n")
        } else {
            updateRange(1, 1, n, q[1] + 1, q[2] + 1, q[3])
        }
    }

    println(sb)
}

lateinit var arr: IntArray
lateinit var seg: IntArray
lateinit var lazy: IntArray

fun updateLazy(node: Int, start: Int, end: Int) {
    if (lazy[node] != 0) {
        if ((end - start + 1) % 2 == 1) {
            seg[node] = seg[node] xor lazy[node]
        }
        if (start != end) {
            lazy[node * 2] = lazy[node * 2] xor lazy[node]
            lazy[node * 2 + 1] = lazy[node * 2 + 1] xor lazy[node]
        }
        lazy[node] = 0
    }
}

fun updateRange(node: Int, start: Int, end: Int, left: Int, right: Int, to: Int) {
    updateLazy(node, start, end)
    if (left > end || right < start) {
        return
    }
    if (left <= start && end <= right) {
        if ((end - start + 1) % 2 == 1) {
            seg[node] = seg[node] xor to
        }
        if (start != end) {
            lazy[node * 2] = lazy[node * 2] xor to
            lazy[node * 2 + 1] = lazy[node * 2 + 1] xor to
        }
        return
    }
    updateRange(node * 2, start, (start + end) / 2, left, right, to)
    updateRange(node * 2 + 1, (start + end) / 2 + 1, end, left, right, to)
    seg[node] = seg[node * 2] xor seg[node * 2 + 1]
}


fun init(node: Int, start: Int, end: Int) {
    if (start == end) {
        seg[node] = arr[start]
    } else {
        init(node * 2, start, (start + end) / 2)
        init(node * 2 + 1, (start + end) / 2 + 1, end)
        seg[node] = seg[node * 2] xor seg[node * 2 + 1]
    }
}

fun find(node: Int, start: Int, end: Int, left: Int, right: Int): Int {
    updateLazy(node, start, end)
    if (start > right || end < left) {
        return 0
    }
    if (left <= start && end <= right) {
        return seg[node]
    }
    val l = find(node * 2, start, (start + end) / 2, left, right)
    val r = find(node * 2 + 1, (start + end) / 2 + 1, end, left, right)
    return l xor r
}
