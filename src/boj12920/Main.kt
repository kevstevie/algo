package boj12920

fun main() {
    val s = readln().split(" ").map { it.toInt() }
    val n = s[0]
    val m = s[1]

    val l = mutableListOf<Stuff>()

    repeat(n) {
        val q = readln().split(" ").map { it.toInt() }
        add(l, q[0], q[1], q[2], 1)
    }

    val dp = IntArray(m + 1)
    var ans = 0
    for (i in l) {
        for (j in dp.indices.reversed()) {
            if (j - i.w >= 0) {
                dp[j] = dp[j].coerceAtLeast(dp[j - i.w] + i.v)
                ans = ans.coerceAtLeast(dp[j])
            }
        }
    }
    println(ans)
}

fun add(l: MutableList<Stuff>, w: Int, v: Int, c: Int, sub: Int) {
    if (c == 0) {
        return
    }
    if (sub >= c) {
        l.add(Stuff(w * c, v * c))
        return
    }
    l.add(Stuff(w * sub, v * sub))
    val next = sub * 2
    add(l, w, v, c - sub, next)
}

class Stuff(val w: Int, val v: Int)
