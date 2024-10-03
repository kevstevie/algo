package boj1157


fun main() {
    val s = readln().uppercase()
    val map = mutableMapOf<Char, Int>()

    for (c in s) {
        map[c] = map.getOrDefault(c, 0) + 1
    }

    val entry = map.entries.sortedBy { -it.value }

    if (entry.size == 1) {
        println(entry.first().key)
        return
    }
    if (entry[0].value == entry[1].value) {
        println("?")
    } else {
        println(entry.first().key)
    }
}
