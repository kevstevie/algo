package pgrmbb

import java.util.*

class Solution {
    fun solution(numbers: IntArray): IntArray {
        val answer = IntArray(numbers.size) { -1 }

        val st = Stack<Int>()

        for (i in numbers.indices.reversed()) {
            if (st.isEmpty()) {
                st.push(numbers[i])
                answer[i] = -1
            } else {
                while (true) {
                    if (st.isEmpty()) {
                        st.push(numbers[i])
                        break
                    }
                    val peek = st.peek()
                    if (peek > numbers[i]) {
                        st.push(numbers[i])
                        answer[i] = peek
                        break
                    } else {
                        st.pop()
                    }
                }
            }
        }

        return answer
    }
}
