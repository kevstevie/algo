package boj5052

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val sb = StringBuilder()
    loop@ for (i in 1..n) {
        val trie = Trie()
        val m = readLine().toInt()
        val l = mutableListOf<String>()
        for (j in 1..m) {
            val number = readLine()
            l.add(number)
            trie.insert(number.toList())
        }
        if (trie.find()) {
            sb.append("NO").append(System.lineSeparator())
            continue@loop
        }
        sb.append("YES").append(System.lineSeparator())
    }

    println(sb)
}

class Node(var key: Char?, var parent: Node?) {
    val c = mutableMapOf<Char, Node>()
    var isEnd = false
}

class Trie() {
    val root = Node(null, null)

    fun insert(keys: List<Char>) {
        var cur = root
        for (i in keys) {
            cur.c.putIfAbsent(i, Node(i, cur))
            cur = cur.c[i]!!
        }
        cur.isEnd = true
    }

    fun find(): Boolean {
        val s: Stack<Node> = Stack()

        s.push(root)
        while (s.isNotEmpty()) {
            val pop = s.pop()
            if (pop.isEnd && pop.c.isNotEmpty()) {
                return true
            }
            for (i in pop.c.values) {
                s.push(i)
            }
        }
        return false
    }
}
