package boj9250

import java.lang.System.lineSeparator
import java.util.LinkedList
import java.util.Queue

fun main() {
    val n = readln().toInt()
    val root = TrieNode()

    repeat(n) {
        val str = readln()
        root.add(str)
    }

    root.buildFailureLink()

    val m = readln().toInt()

    val ans = StringBuilder()

    repeat(m) {
        if (root.find(readln())) {
            ans.append("YES")
        } else {
            ans.append("NO")
        }
        ans.append(lineSeparator())
    }

    println(ans)
}

class TrieNode {
    val children = mutableMapOf<Char, TrieNode>()
    var failureLink: TrieNode? = null
    var isEnd = false

    fun add(s: String) {
        var current = this
        for (c in s) {
            current = current.children.getOrPut(c) { TrieNode() }
        }
        current.isEnd = true
    }

    fun buildFailureLink() {
        val q: Queue<TrieNode> = LinkedList()

        for ((ch, child) in children) {
            q.offer(child)
            child.failureLink = this
        }

        while (q.isNotEmpty()) {
            val current = q.poll()

            for ((ch, child) in current.children) {
                var lastFailLink = current.failureLink

                while (lastFailLink != null && lastFailLink!!.children[ch] == null) {
                    lastFailLink = lastFailLink!!.failureLink
                }

                child.failureLink = lastFailLink?.children?.get(ch) ?: this

                if (child.failureLink!!.isEnd) {
                    child.isEnd = true
                }

                q.offer(child)
            }
        }
    }

    fun find(s: String): Boolean {
        var current = this

        for (c in s) {
            while (current != this && current.children[c] == null) {
                current = current.failureLink ?: this
            }
            current = current.children[c] ?: this

            if (current.isEnd) {
                return true
            }
        }
        return false
    }
}
