package pgrmcode

val list = ('a'..'z').toMutableList()

class Solution {
    fun solution(s: String, skip: String, index: Int): String {
        val answer = StringBuilder()
        for (c in skip) {
            list.remove(c)
        }

        for (c in s) {
            val idx = list.indexOf(c) + index
            answer.append(list[idx % list.size])

        }
        return answer.toString()
    }
}
