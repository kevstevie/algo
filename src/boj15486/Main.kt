package boj15486

fun main() {
    val n = readln().toInt()

    val d = IntArray(n)
    val v = IntArray(n)

    //0 0 0 0 50
    for (i in 0..<n) {
        val q = readln().split(" ").map { it.toInt() }

        d[i] = q[0]
        v[i] = q[1]
    }

    val arr = IntArray(n + 1)

    for (i in 0..<n) {
        if(d[i] + i <= n) {
            val k = d[i]
            val h = v[i]
            arr[d[i] + i] = arr[d[i] +i].coerceAtLeast(arr[i] + v[i])
        }
        arr[i + 1] = arr[i + 1].coerceAtLeast(arr[i])
    }

    println(arr.max())
}
