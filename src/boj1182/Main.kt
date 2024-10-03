package boj1182

fun main() {
    val q = readln().split(" ").map { it.toInt() }

    val s = q[1]

    val arr = readln().split(" ").map { it.toInt() }

    backtrack(s, 0, arr, 0, 0)
    println(ans)
}
var ans = 0
fun backtrack(target: Int, sum: Int, arr: List<Int>, idx: Int, size: Int) {
    if (sum == target && size >= 1 && idx == arr.size) {
        ans++
    }
    if (idx >= arr.size) {
        return
    }
    backtrack(target, sum + arr[idx], arr, idx + 1, size + 1)
    backtrack(target, sum, arr, idx + 1, size)
}

/*
2^5 - 1 = 31
5 0
0 0 0 0 0
 */

