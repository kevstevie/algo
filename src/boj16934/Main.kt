package boj16934

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val trie = Trie()
    val sb = StringBuilder()
    repeat(n) {
        val s = readLine()
        sb.append(trie.insert(s)).append("\n")
    }

    println(sb)
}

class Node<T>(var key: T?, var parent: Node<T>?) {
    val child = mutableMapOf<T, Node<T>>()
    var isEnd = false
    var count = 1
}

class Trie() {
    val root = Node<Char>(null, null)

    fun insert(s: String): String {
        var result: String = ""
        val list = s.toList()
        var cur = root

        for (i in list.indices) {
            if (cur.child[list[i]] == null && result == "") {
                result = s.substring(0, i + 1)
            }
            cur.child.putIfAbsent(list[i], Node(list[i], cur))
            cur = cur.child[list[i]]!!
        }
        cur.isEnd = true

        if (result == "") {
            if (cur.count >= 2) {
                result = "$s${cur.count}"
            } else {
                result = s
            }
        }
        cur.count++

        return result
    }
}
