package boj15681

fun main() {
    val split = readln().split(" ").map { it.toInt() }
    val n = split[0]
    val r = split[1]
    val q = split[2]

    val arr = Array(n + 1) { mutableListOf<Int>() }
    val v = BooleanArray(n + 1)
    v[r] = true

    repeat(n - 1) {
        val input = readln().split(" ").map { it.toInt() }
        arr[input[0]].add(input[1])
        arr[input[1]].add(input[0])
    }

    val tree= Tree(Node(r, null))
    tree.init(tree.root, arr, v)
    val dp = IntArray(n + 1)
    val sb = StringBuilder()
    tree.count(tree.root, dp)
    repeat(q) {
        sb.append(dp[readln().toInt()]).append("\n")
    }

    println(sb)
}

class Tree(val root: Node) {
    fun init(cur: Node, arr: Array<MutableList<Int>>, v: BooleanArray) {
        for (i in arr[cur.value]) {
            if (!v[i]) {
                v[i] = true
                val child = Node(i, cur)
                cur.child.add(child)
                init(child, arr, v)
            }
        }
    }
    fun count(cur: Node, dp: IntArray) {
        dp[cur.value] = 1
        for (i in cur.child) {
            count(i, dp)
            dp[cur.value] += dp[i.value]
        }
    }
}

class Node(val value: Int, val parent: Node?) {
    val child = mutableListOf<Node>()
}
