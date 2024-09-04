package boj2711

fun main() {
    val t = readln().toInt()
    val sb = StringBuilder()
    repeat(t) {
        val s = readln().split(" ")
        val k = s[0].toInt()
        val res = StringBuilder()
        for (i in s[1].indices) {
            if (i != k - 1) {
                res.append(s[1][i])
            }
        }
        sb.append(res).append("\n")
    }

    println(sb)
}
