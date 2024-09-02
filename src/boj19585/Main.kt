package boj19585

fun main() {
    val split = readln().split(" ")
    val n = split[0].toInt()
    val m = split[1].toInt()
    val color = Trie()
    val sb = StringBuilder()

    repeat(n) {
        color.insert(readln())
    }

    val set = mutableSetOf<String>()
    repeat(m) {
        set.add(readln())
    }

    val k = readln().toInt()

    repeat(k) {

        sb.append(find(color, set, readln())).append("\n")
    }

    println(sb)
}

fun find(color: Trie, name: Set<String>, s: String): String {
    val find = color.findPrefix(s)
    var result = false

    for (i in find) {
        if (name.contains(s.substring(i..<s.length))) {
            result = true
        }
    }
    return if(result) "Yes" else "No"
}

class Node<T>(var key: T?, var parent: Node<T>?, var idx: Int) {
    val child = mutableMapOf<T, Node<T>>()
    var isEnd = false
}

class Trie() {
    val root = Node<Char>(null, null, -1)

    fun insert(s: String) {
        var cur = root

        for (i in s) {
            cur.child.putIfAbsent(i, Node(i, cur, cur.idx + 1))
            cur = cur.child[i]!!
        }

        cur.isEnd = true
    }

    fun findPrefix(s: String): List<Int> {
        var cur = root
        val l = mutableListOf<Int>()
        for (i in s.indices) {
            cur = cur.child[s[i]] ?: break
            if (cur.isEnd) {
                l.add(i + 1)
            }
        }
        return l
    }
}
