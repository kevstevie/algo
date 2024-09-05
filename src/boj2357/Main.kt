package boj2357

import kotlin.math.ceil
import kotlin.math.log

fun main() {
    val s = readln().split(" ").map { it.toInt() }
    val n = s[0]
    val m = s[1]
    arr = IntArray(n + 1)
    for (i in 1..n) {
        arr[i] = readln().toInt()
    }

    val h = ceil(log((n + 1).toDouble(), 2.0)).toInt() + 1
    treemin = IntArray(1 shl (h + 1))
    treemax = IntArray(1 shl (h + 1))
    initmax(1, 1, n)
    initmin(1, 1, n)
    val sb = StringBuilder()
    repeat(m) {
        val query = readln().split(" ").map { it.toInt() }
        val node1 = findmin(1, 1, n, query[0], query[1])
        val node2 = findmax(1, 1, n, query[0], query[1])
        sb.append("$node1 $node2").append("\n")
    }

    println(sb)
}

lateinit var arr: IntArray
lateinit var treemin: IntArray
lateinit var treemax: IntArray

class Node(val min: Int, val max: Int)

fun initmin(node: Int, start: Int, end: Int) {
    if (start == end) {
        treemin[node] = arr[start]
    } else {
        initmin(node * 2, start, (start + end) / 2)
        initmin(node * 2 + 1, (start + end) / 2 + 1, end)
        val l = treemin[node * 2]
        val r = treemin[node * 2 + 1]
        treemin[node] = l.coerceAtMost(r)
    }
}

fun initmax(node: Int, start: Int, end: Int) {
    if (start == end) {
        treemax[node] = arr[start]
    } else {
        initmax(node * 2, start, (start + end) / 2)
        initmax(node * 2 + 1, (start + end) / 2 + 1, end)
        val l = treemax[node * 2]
        val r = treemax[node * 2 + 1]
        treemax[node] = l.coerceAtLeast(r)
    }
}

fun findmin(node: Int, start: Int, end: Int, left: Int, right: Int): Int {
    if (left > end || right < start) {
        return Int.MAX_VALUE
    }
    if (left <= start && end <= right) {
        return treemin[node]
    }
    return findmin(node * 2, start, (start + end) / 2, left, right).coerceAtMost(
        findmin(node * 2 + 1, (start + end) / 2 + 1, end, left, right)
    )
}

fun findmax(node: Int, start: Int, end: Int, left: Int, right: Int): Int {
    if (left > end || right < start) {
        return 0
    }
    if (left <= start && end <= right) {
        return treemax[node]
    }
    return findmax(node * 2, start, (start + end) / 2, left, right).coerceAtLeast(
        findmax(node * 2 + 1, (start + end) / 2 + 1, end, left, right)
    )
}
