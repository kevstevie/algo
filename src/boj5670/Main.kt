package boj5670

import java.text.DecimalFormat
import kotlin.math.round

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    while (true) {
        val n = readLine() ?: break
        val N = n.toInt()
        val trie = Trie()
        val l = mutableListOf<String>()
        repeat(N) {
            val input = readLine()
            trie.insert(input)
            l.add(input)
        }
        var result = 0L
        for (i in l) {
            result += trie.find(i)
        }
        val ans = round(result / N.toDouble() * 100.0) / 100.0
        sb.append(DecimalFormat(".00").format(ans)).append("\n")
    }

    println(sb)
}

class Trie() {
    val root = Node<Char>(null, null)

    fun insert(s: String) {
        var cur = root
        val list = s.toList()

        for (i in list) {
            cur.child.putIfAbsent(i, Node(i, cur))
            cur = cur.child[i]!!
        }

        cur.isEnd = true
    }

    fun find(s: String): Long {
        val list = s.toList()
        var result = 0L
        var cur = root

        for (i in list) {
            if (cur.child.size == 1 && !cur.isEnd && cur != root) {
                cur = cur.child[i]!!
                continue
            }
            cur = cur.child[i]!!
            result++
        }
        return result
    }
}

class Node<T>(key: T?, parent: Node<T>?) {
    val child = mutableMapOf<T, Node<T>>()
    var isEnd = false
}
