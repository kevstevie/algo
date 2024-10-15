package pgrmhw

import java.util.*


class Solution {
    fun solution(plans: Array<Array<String>>): Array<String> {
        val q: PriorityQueue<Hw> = PriorityQueue(Comparator.comparing { it.start })
        val answer = mutableListOf<String>()
        val st: Stack<Hw> = Stack()

        for (i in plans) {
            q.offer(Hw(i[0], i[1].conv(), i[2].toInt()))
        }

        var job = q.poll()
        var now = job.start

        while (q.isNotEmpty()) {

            if (now.after(job.time) <= q.peek().start) {
                answer.add(job.name)
                now = now.after(job.time)
                job.time = 0
            } else {
                val minus = now.calc(q.peek().start)
                job.time -= minus
                st.push(job)
                now = now.after(minus)
                job = q.poll()
            }
            if (job.time == 0) {
                if (q.peek().start == now) {
                    job = q.poll()
                } else if (st.isNotEmpty()) {
                    job = st.pop()
                } else {
                    job = q.poll()
                    now = job.start
                }
            }
        }

        answer.add(job.name)

        while (st.isNotEmpty()) {
            answer.add(st.pop().name)
        }

        return answer.toTypedArray()
    }
}

class Hw(val name: String, val start: Int, var time: Int)

fun String.conv(): Int {
    val s = this[0].toString() + this[1] + this[3] + this[4]

    return s.toInt()
}

fun Int.after(time: Int): Int {
    val plus = this % 100 + time

    val h = plus / 60
    val m = plus % 60

    return this / 100 * 100 + h * 100 + m
}

fun Int.calc(start: Int): Int {
    val h = start / 100 - this / 100
    val m = start % 100 - this % 100

    return h * 60 + m
}
