package pgrmdevidestring

class Solution {
    fun solution(s: String): Int {
        var answer: Int = 0

        var flag = false
        var x = ' '
        var a = 0
        var b = 0

        for (c in s) {
            if (!flag) {
                x = c
                a = 1
                flag = true
                continue
            }
            if (x != c) {
                b++
            } else {
                a++
            }
            if (a == b) {
                flag = false
                a = 0
                b = 0
                answer++
            }
        }
        if (flag) {
            answer++
        }
        return answer
    }
}
