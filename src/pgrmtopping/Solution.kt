package pgrmtopping

class Solution {
    fun solution(topping: IntArray): Int {
        var answer: Int = 0

        val ma = IntArray(10001)
        val mb = IntArray(10001)

        var a = 0
        var b = 0

        for (i in topping) {
            if (ma[i] == 0) {
                a++
            }
            ma[i]++
        }

        for (i in topping) {
            if (mb[i] == 0) {
                b++
            }
            mb[i]++
            ma[i]--
            if (ma[i] == 0) {
                a--
            }
            if (a == b) {
                answer++
            }
        }

        return answer
    }
}
