package boj11505

import kotlin.math.ceil
import kotlin.math.log

fun main() {
    val s = readln().split(" ").map { it.toInt() }
    val n = s[0]
    val m = s[1]
    val k = s[2]
    arr = LongArray(n + 1)
    for (i in 1..n) {
        arr[i] = readln().toLong()
    }
    val h = ceil(log((n + 1).toDouble(), 2.0)).toInt()
    seg = LongArray(1 shl (h + 1))
    init(1, 1, n)

    val sb = StringBuilder()
    repeat(m + k) {
        val split = readln().split(" ")
        if (split[0] == "2") {
            sb.append(find(1, 1, n, split[1].toInt(), split[2].toInt())).append("\n")
        } else {
            arr[split[1].toInt()] = split[2].toLong()
            update(1, 1, n, split[1].toInt(), split[2].toLong())
        }
    }

    println(sb)
}

val d = 1_000_000_007

lateinit var arr: LongArray
lateinit var seg: LongArray

fun init(node: Int, start: Int, end: Int) {
    if (start == end) {
        seg[node] = arr[start]
    } else {
        init(node * 2, start, (start + end) / 2)
        init(node * 2 + 1, (start + end) / 2 + 1, end)
        seg[node] = (seg[node * 2] % d * seg[node * 2 + 1] % d) % d
    }
}

fun find(node: Int, start: Int, end: Int, left: Int, right: Int): Long {
    if (left > end || right < start) {
        return 1
    }
    if (left <= start && end <= right) {
        return seg[node]
    }
    val lply = find(node * 2, start, (start + end) / 2, left, right)
    val rply = find(node * 2 + 1, (start + end) / 2 + 1, end, left, right)
    return (lply % d * rply % d) % d
}

fun update(node: Int, start: Int, end: Int, idx: Int, to: Long) {
    if (idx < start || idx > end) {
        return
    }
    if (start == end) {
        arr[idx] = to
        seg[node] = to
        return
    }
    update(node * 2, start, (start + end) / 2, idx, to)
    update(node * 2 + 1, (start + end) / 2 + 1, end, idx, to)
    seg[node] = (seg[node * 2] % d * seg[node * 2 + 1] % d) % d
}

/*
5 1 1
1
2
3
4
5
2 1 3
2 4 5
 */
