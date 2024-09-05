package boj2042

fun main() {
    val s = readln().split(" ").map { it.toInt() }
    val n = s[0]
    val m = s[1]
    val k = s[2]
    arr = LongArray(n + 1)
    tree = LongArray(4 * n)
    for (i in 1..n) {
        arr[i] = readln().toLong()
    }
    init(1, n, 1)

    val sb = StringBuilder()
    repeat(m + k) {
        val query = readln().split(" ")
        if (query[0] == "2") {
            sb.append(find(1, 1, n, query[1].toInt(), query[2].toInt())).append("\n")
        } else {
            val diff = query[2].toLong() - arr[query[1].toInt()]
            arr[query[1].toInt()] = query[2].toLong()
            update(1, 1, n, query[1].toInt(), diff)
        }
    }

    println(sb)
}

lateinit var arr: LongArray
lateinit var tree: LongArray

fun init(start: Int, end: Int, node: Int) {
    if (start == end) {
        tree[node] = arr[start]
        return
    }
    init(start, (start + end) / 2, node * 2)
    init((start + end) / 2 + 1, end, node * 2 + 1)
    tree[node] = tree[node * 2] + tree[node * 2 + 1]
}

fun find(node: Int, start: Int, end: Int, left: Int, right: Int): Long {
    if (left > end || start > right) {
        return 0
    }
    if (left <= start && end <= right) {
        return tree[node]
    }
    val lsum = find(node * 2, start, (start + end) / 2, left, right)
    val rsum = find(node * 2 + 1, (start + end) / 2 + 1, end, left, right)

    return lsum + rsum
}

fun update(node: Int, start: Int, end: Int, idx: Int, diff: Long) {
    if (idx < start || idx > end) {
        return
    }
    tree[node] += diff
    if (start != end) {
        update(node * 2, start, (start + end) / 2, idx, diff)
        update(node * 2 + 1, (start + end) / 2 + 1, end, idx, diff)
    }
}
