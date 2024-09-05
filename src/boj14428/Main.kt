package boj14428

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
    seg = Array(1 shl h) { Node(0, 0) }
    init(1, 1, n)
    val m = readln().toInt()
    val sb = StringBuilder()
    repeat(m) {
        val q = readln().split(" ").map { it.toInt() }
        if (q[0] == 2) {
            val find = find(1, 1, n, q[1], q[2])
            sb.append("${find.idx}\n")
        } else {
            update(1, 1, n, q[1], q[2])
        }
    }

    println(sb)
}

lateinit var arr: IntArray
lateinit var seg: Array<Node>

class Node(val idx: Int, val v: Int)

fun init(node: Int, start: Int, end: Int) {
    if (start == end) {
        seg[node] = Node(start, arr[start])
    } else {
        init(node * 2, start, (start + end) / 2)
        init(node * 2 + 1, (start + end) / 2 + 1, end)
        val l = seg[node * 2]
        val r = seg[node * 2 + 1]
        if (l.v <= r.v) {
            seg[node] = Node(l.idx, l.v)
        } else {
            seg[node] = Node(r.idx, r.v)
        }
    }
}

fun find(node: Int, start: Int, end: Int, left: Int, right: Int): Node {
    if (left > end || right < start) {
        return Node(-1, -1)
    }
    if (left <= start && end <= right) {
        return seg[node]
    }
    val l = find(node * 2, start, (start + end) / 2, left, right)
    val r = find(node * 2 + 1, (start + end) / 2 + 1, end, left, right)
    if (l.v == -1) {
        return r
    }
    if (r.v == -1) {
        return l
    }
    if (l.v <= r.v) {
        return l
    } else {
        return r
    }
}

fun update(node: Int, start: Int, end: Int, idx: Int, to: Int) {
    if (idx < start || end < idx) {
        return
    }
    if (start == end) {
        arr[idx] = to
        seg[node] = Node(idx, to)
        return
    }
    update(node * 2, start, (start + end) / 2, idx, to)
    update(node * 2 + 1, (start + end) / 2 + 1, end, idx, to)
    val l = seg[node * 2]
    val r = seg[node * 2 + 1]
    if (l.v <= r.v) {
        seg[node] = l
    } else {
        seg[node] = r
    }
}
