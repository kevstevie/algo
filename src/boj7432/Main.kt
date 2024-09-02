package boj7432

import java.util.*

fun main() {
    val n = readln().toInt()
    val trie = Trie()
    repeat(n) {
        val input = readln().split("\\")
        trie.insert(input)
    }

    println(trie.dfs())
}

class Trie() {
    val root = Node<String>(null, null, -1)

    fun insert(list: List<String>) {
        var cur = root

        for (i in list) {
            cur.child.putIfAbsent(i, Node(i, cur, cur.level + 1))
            cur = cur.child[i]!!
        }

        cur.isEnd = true
    }

    fun dfs(): StringBuilder {
        val st: Stack<Node<String>> = Stack()

        val sorted = root.child.values.sortedWith(compareBy<Node<String>> { it.key }.reversed())

        sorted.forEach { st.push(it) }
        val sb = StringBuilder()
        while (st.isNotEmpty()) {
            val pop = st.pop()
            sb.append(" ".repeat(pop.level)).append("${pop.key}").append("\n")

            val sort = pop.child.values.sortedWith(compareBy<Node<String>> { it.key }.reversed())
            sort.forEach {st.push(it)}
        }

        return sb
    }

}

class Node<T>(var key: T?, var parent: Node<T>?, var level: Int) {
    val child = mutableMapOf<T, Node<T>>()
    var isEnd = false
}
