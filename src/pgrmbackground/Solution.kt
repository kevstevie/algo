package pgrmbackground

class Solution {
    fun solution(wallpaper: Array<String>): IntArray {

        var minx = Integer.MAX_VALUE
        var miny = Integer.MAX_VALUE
        var maxx = Integer.MIN_VALUE
        var maxy = Integer.MIN_VALUE

        for (i: Int in wallpaper.indices) {
            val s = wallpaper[i];
            val chars = s.toCharArray()
            for (j: Int in chars.indices) {
                val ch = chars[j];
                if (ch.exist()) {
                    minx = minx.coerceAtMost(i);
                    miny = miny.coerceAtMost(j);
                    maxx = maxx.coerceAtLeast(i + 1);
                    maxy = maxy.coerceAtLeast(j + 1);
                }
            }
        }
        return intArrayOf(minx, miny, maxx, maxy)
    }

    fun Char.exist() = this == '#'
}
