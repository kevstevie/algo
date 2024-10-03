package boj1806

fun main() {
    val q = readln().split(" ").map { it.toInt() }

    val n = q[0]
    val s = q[1]

    val input = readln().split(" ").map { it.toLong() }.toMutableList()
    val arr = LongArray(input.size + 1)

    for (i in 0..<input.size) {
        arr[i + 1] = input[i]
        arr[i + 1] += arr[i]
    }

    var ans = Int.MAX_VALUE

    var l = 0
    var r = 1

    while (l < r) {
        val sum = arr[r] - arr[l]
        if (sum >= s) {
            ans = ans.coerceAtMost(r - l)
            l++
        } else {
            r++
            if (r >= arr.size) {
                break
            }
        }
    }

    if (ans == Int.MAX_VALUE) {
        ans = 0
    }
    println(ans)
}
