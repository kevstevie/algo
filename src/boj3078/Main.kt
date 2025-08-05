package boj3078

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }

    val cnt = IntArray(21)
    val arr = IntArray(n) { readln().length }

    for (i in 0..k) {
        cnt[arr[i]]++
    }

    var ans: Long = cnt[arr[0]] - 1L

    for (i in 1..<n) {
        cnt[arr[i - 1]]--

        if (i + k < n) {
            cnt[arr[i + k]]++
        }

        ans += cnt[arr[i]] - 1
    }

    println(ans)
}
