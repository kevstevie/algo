package boj2352

fun main() {
    val n = readln().toInt()

    val arr = readln().split(" ").map { it.toInt() }

    val lis = mutableListOf<Int>().apply { add(arr[0]) }
    var idx = 0

    for (i in 1..<n) {
        if (lis[idx] < arr[i]) {
            lis.add(arr[i])
            idx++
        } else {
            val dx = lis.bsearch(arr[i])
            lis[dx] = arr[i]
        }
    }

    println(lis.size)
}

fun List<Int>.bsearch(a: Int): Int {
    var s = 0
    var e = this.size - 1
    var ans = 0

    while (s <= e) {
        val mid = (s + e) / 2

        if (this[mid] >= a) {
            e = mid - 1
            ans = mid
        } else {
            s = mid + 1
        }
    }
    return ans
}
