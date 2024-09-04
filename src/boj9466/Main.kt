package boj9466

fun main() {
    val t = readln().toInt()
    val sb = StringBuilder()
    repeat(t) {
        val n = readln().toInt()
        arr = IntArray(n + 1)
        val input = readln().split(" ").map { it.toInt() }
        ans = n
        for (i in 1..n) {
            arr[i] = input[i - 1]
        }
        team = BooleanArray(n + 1)
        v = BooleanArray(n + 1)
        for (i in 1..n) {
            if (team[i]) continue
            dfs(i)
        }
        sb.append(ans).append("\n")
    }
    println(sb)
}

lateinit var arr: IntArray
lateinit var team: BooleanArray
lateinit var v: BooleanArray
var ans: Int = 0
fun dfs(i: Int) {
    val next = arr[i]
    if (v[i]) {
        team[i] = true
        ans--
    } else {
        v[i] = true
    }

    if (!team[next]) {
        dfs(next)
    }
    v[i] = false
    team[i] = true
}
