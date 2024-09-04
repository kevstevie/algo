package boj1943


fun main() = with(System.`in`.bufferedReader()) {

    val sb = StringBuilder()
    while (true) {
        val n = readLine()?.toInt() ?: break
        val l = mutableListOf<Coin>()
        var sum = 0
        repeat(n) {
            val map = readLine().split(" ").map { it.toInt() }
            l.add(Coin(map[0], map[1]))
            sum += map[0] * map[1]

        }
        if (sum % 2 != 0) {
            sb.append(0).append("\n")
            continue
        }
        val dp = BooleanArray(sum / 2 + 1)
        dp[0] = true
        for (i in l) {
            for (j in sum / 2 downTo i.am) {
                if (dp[j - i.am]) {
                    for (k in 0..<i.c) {
                        if (j + i.am * k <= sum / 2) {
                            dp[j + i.am * k] = true
                        }
                    }
                }
            }
        }
        if (dp[sum / 2]) {
            sb.append(1)
        } else {
            sb.append(0)
        }
        sb.append("\n")
    }

    println(sb)
}

class Coin(val am: Int, val c: Int)
/*
2
200 2
800 1
2
200 3
1000 1
2
2 2
8 1
 */
