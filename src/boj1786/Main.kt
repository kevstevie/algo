package boj1786

fun main() {
    val T = readln()
    val P = readln()

    val f = fail(P)

    val ans = kmp(T, P, f)

    println(ans.size)
    println(ans.joinToString(" "))
}

fun fail(s: String): IntArray {
    val arr = IntArray(s.length)
    var m = 0
    var begin = 1

    while (begin + m < s.length) {
        if (s[begin + m] == s[m]) {
            m++
            arr[begin + m - 1] = m
        } else {
            if (m == 0) {
                begin++
            } else {
                begin += m - arr[m - 1]
                m = arr[m - 1]
            }
        }
    }

    return arr
}

fun kmp(s1: String, s2: String, fail: IntArray): List<Int> {
    var m = 0
    var begin = 0
    val res = mutableListOf<Int>()

    while (begin + m < s1.length) {
        if (s1[begin + m] == s2[m]) {
            m++
            if (m >= s2.length) {
                res.add(begin + 1)
                begin += m - fail[m - 1]
                m = fail[m - 1]
            }
        } else {
            if (m == 0) {
                begin++
            } else {
                begin += m - fail[m - 1]
                m = fail[m - 1]
            }
        }
    }

    return res
}
