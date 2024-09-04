package boj2342

import kotlin.math.abs

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    val len = input.size

    val dp = Array(len) { Array(5) { IntArray(5) { -1 } } }

    dp[0][0][0] = 0

    for (i in 1..<len) {
        val target = input[i - 1]
        for (j in 0..4) {
            for (k in 0..4) {
                if (dp[i - 1][k][j] != -1) {
                    if (dp[i][target][j] == -1) {
                        dp[i][target][j] = 5000000
                    }
                    dp[i][target][j] = dp[i][target][j].coerceAtMost(dp[i - 1][k][j] + move(k, target))
                }
                if (dp[i - 1][j][k] != -1) {
                    if (dp[i][j][target] == -1) {
                        dp[i][j][target] = 5000000
                    }
                    dp[i][j][target] = dp[i][j][target].coerceAtMost(dp[i - 1][j][k] + move(k, target))
                }
            }
        }
    }
    var ans = Int.MAX_VALUE

    for (i in 0..4) {
        for (j in 0..4) {
            if (dp[len-1][i][j] != -1) {
                ans = ans.coerceAtMost(dp[len - 1][i][j])

            }
        }
    }

    println(ans)
}

fun move(a: Int, b: Int): Int {
    if (a == b) {
        return 1
    }
    if (a == 0) {
        return 2
    }
    if (abs(a - b) == 2) {
        return 4
    }
    return 3
}

/*
1 1 1 1 1 0

1 2 2 4 0

1 3 2 2 2 1 0
*/
