package pgrmidrecom

class Solution {
    fun solution(new_id: String): String {
        var answer: String = ""

        val step1 = new_id.lowercase()

        val sb = StringBuilder()
        val regex = Regex("""[0-9a-z._-]""")
        for (c in step1) {
            if (regex.matches(c.toString())) {
                sb.append(c.toString())
            }
        }

        val step2 = sb.toString()
        sb.clear()

        var flag = false
        for (c in step2) {
            if (c == '.') {
                flag = true
                continue
            }
            if (flag) {
                sb.append('.').append(c)
                flag = false
            } else {
                sb.append(c)
            }
        }

        val step3 = sb.toString()
        sb.clear()

        for (c in step3.indices) {
            if (c == 0 && step3[c] == '.') {
                continue
            }
            if (c == step3.length - 1 && step3[c] == '.') {
                continue
            }
            sb.append(step3[c])
        }

        val step4 = sb.toString()
        sb.clear()

        var step5: String
        if (step4.isEmpty()) {
            step5 = "a"
        } else {
            step5 = step4
        }

        var step6: String
        if (step5.length >= 16) {
            step6 = step5.substring(0, 15)
            if (step6[14] == '.') {
                step6 = step6.substring(0, 14)
            }
        } else {
            step6 = step5
        }

        if (step6.length < 3) {
            val aa = step6[step6.length - 1]
            while (step6.length < 3) {
                step6 += aa
            }
        }


        return step6
    }
}
