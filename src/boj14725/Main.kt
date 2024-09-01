package boj14725

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val trie = Trie()
    repeat(n) {
        val split = readLine().split(" ")
        trie.insert(split.subList(1, split.size))
    }

    println(trie.dfs())
}

class Node(var key: String?, var parent: Node?, var deep: Int) {
    val child = mutableMapOf<String, Node>()
    var isEnd = false
}

class Trie() {
    val root = Node(null, null, -1)

    fun insert(list: List<String>) {
        var cur = root

        for (i in list) {
            cur.child.putIfAbsent(i, Node(i, cur, cur.deep + 1))
            cur = cur.child[i]!!
        }
        cur.isEnd = true
    }

    fun dfs(): StringBuilder {
        val sb = StringBuilder()

        val keys = root.child.values.toMutableList()
        keys.sortWith(compareBy<Node> { it.key }.reversed())

        val st: Stack<Node> = Stack()

        for (i in keys) {
            st.push(i)
        }

        while(st.isNotEmpty()) {
            val pop = st.pop()
            repeat(pop.deep) {sb.append("--")}
            sb.append(pop.key).append("\n")
            val childs = pop.child.values.toMutableList()
            childs.sortWith(compareBy<Node>({it.key}).reversed())
            for (i in childs) {
                st.push(i)
            }
        }

        return sb
    }
}
