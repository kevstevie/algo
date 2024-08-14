package pgrmdict

class Solution {

    val l = listOf("A", "E", "I", "O", "U")
    val answer = mutableListOf<String>()

    fun solution(word: String): Int {

        recur("")

        answer.sort()
        return answer.indexOf(word)
    }

    fun recur(s: String) {
        if (s.length == 6) {
            return
        }
        answer.add(s)
        for (s1 in l) {
            recur(s.plus(s1))
        }
    }
}
