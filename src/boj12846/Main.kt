package boj12846

import kotlin.math.ceil
import kotlin.math.log

fun main() {
    val n = readln().toInt()
    arr = IntArray(n + 1)
    val s = readln().split(" ").map { it.toInt() }
    arr[0] = Int.MAX_VALUE
    for (i in 1..n) {
        arr[i] = s[i - 1]
    }
    val h = ceil(log((n+1).toDouble(), 2.0)).toInt() + 1
    seg = IntArray(1 shl h)

    init(1, 1, n)

    println(getMax(n, 1, n))
}

lateinit var arr: IntArray
lateinit var seg: IntArray

fun init(node: Int, start: Int, end: Int) {
    if (start == end) {
        seg[node] = start
    } else {
        init(node * 2, start, (start + end) / 2)
        init(node * 2 + 1, (start + end) / 2 + 1, end)
        val l = seg[node * 2]
        val r = seg[node * 2 + 1]
        if (arr[l] <= arr[r] ) {
            seg[node] = l
        } else {
            seg[node] = r
        }
    }
}

fun find(node: Int, start: Int, end: Int, left: Int, right:Int): Int {
    if (right < start || end < left) {
        return 0
    }

    if (left<= start && end <= right) {
        return seg[node]
    }

    val l = find(node * 2, start, (start + end) / 2, left, right)
    val r = find(node * 2 + 1, (start + end) / 2 + 1, end, left, right)
    if (arr[l] <= arr[r]) {
        return l
    }
    return r
}

fun getMax(n: Int, left: Int, right: Int): Long {
    val k = find(1, 1, n, left, right)
    var ans = arr[k] * (right - left + 1).toLong()

    if (left <= k - 1) {
        val l = getMax(n, left, k - 1)
        ans = ans.coerceAtLeast(l)
    }
    if (right >= k + 1) {
        val r = getMax(n, k + 1, right)
        ans = ans.coerceAtLeast(r)
    }

    return ans
}

/*
1 ~ 5

1 -> 1~0, 2~5

l ~ k-1
k+1 ~ r
2~5
5 -> 2~4, 6~5
 */
