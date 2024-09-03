package boj20303

fun main() {
    val split = readln().split(" ").map { it.toInt() }
    val n = split[0]
    val m = split[1]
    val k = split[2]

    val candy = IntArray(n + 1)
    val parent = IntArray(n + 1) { it }
    val split1 = readln().split(" ").map { it.toInt() }
    for (i in split1.indices) {
        candy[i + 1] = split1[i]
    }

    repeat(m) {
        val input = readln().split(" ").map { it.toInt() }
        union(input[0], input[1], parent)
    }

    val person = IntArray(n + 1) { 1 }

    for (i in 1..n) {
        if (i == parent[i]) {
            continue
        }
        val root = find(i, parent)
        candy[root] += candy[i]
        person[root] += person[i]
    }
    val dp = IntArray(k)

    var ans = 0
    for (i in 1..n) {
        if (parent[i] != i) continue
        for (j in (1..<k).reversed()) {
            if (j - person[i] >= 0) {
                dp[j] = dp[j].coerceAtLeast(dp[j - person[i]] + candy[i])
                ans = ans.coerceAtLeast(dp[j])
            }
        }
    }

    println(ans)
}

fun union(a: Int, b: Int, u: IntArray) {
    val aa = find(a, u)
    val bb = find(b, u)

    if (aa < bb) {
        u[bb] = aa
    } else {
        u[aa] = bb
    }
}

fun find(a: Int, u: IntArray): Int {
    if (a != u[a]) {
        u[a] = find(u[a], u)
    }
    return u[a]
}
