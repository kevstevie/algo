package boj11562

import kotlin.math.min

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val INF = 250 * 250 + 1

    val arr = Array(n + 1) { IntArray(n + 1) { INF } }

    for (i in 0..n) {
        arr[i][i] = 0
    }

    repeat(m) {
        val (s, e, c) = readln().split(" ").map { it.toInt() }

        if (c == 0) {
            arr[s][e] = 0
            arr[e][s] = 1
        } else {
            arr[s][e] = 0
            arr[e][s] = 0
        }
    }

    for (i in 1..n) {
        for (j in 1..n) {
            for (k in 1..n) {
                if (arr[j][i] == INF || arr[i][k] == INF) {
                    continue
                }

                arr[j][k] = min(arr[j][k], arr[j][i] + arr[i][k])
            }
        }
    }

    val k = readln().toInt()
    val ans = StringBuilder()

    repeat(k) {
        val (s, e) = readln().split(" ").map { it.toInt() }

        ans.append(arr[s][e]).append(System.lineSeparator())
    }


    println(ans)
}
