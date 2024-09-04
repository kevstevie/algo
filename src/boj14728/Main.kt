package boj14728

fun main() {

    val s = readln().split(" ").map { it.toInt() }
    val n = s[0]
    val t = s[1]

    val l = mutableListOf<Study>()
    val dp = IntArray(t + 1)
    var ans = 0
    repeat(n) {
        val k = readln().split(" ").map { it.toInt() }
        l.add(Study(k[0], k[1]))
    }

    for (i in l) {
        for (j in t downTo 0) {
            if (j - i.time >= 0) {
                dp[j] = dp[j].coerceAtLeast(dp[j - i.time] + i.score)
                ans = ans.coerceAtLeast(dp[j])
            }
        }
    }

    print(ans)
}

class Study(val time: Int, val score: Int)
/*
5 310
10 10
50 40
50 70
200 150
320 500
 */
