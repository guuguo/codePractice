package com.company

import kotlin.math.min

/**
 * @author guuguo
 *
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/integer-to-roman
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @see <a href="https://leetcode-cn.com/problems/integer-to-roman/">leetcode链接</a>
 * On*/
fun intToRoman(num: Int): String {
    var ss = num
    val sb = StringBuilder()

    fun appendIt(temp: Int, charArray: CharArray) {
        when (temp) {
            9 -> sb.append(charArray[2], charArray[0]);
            8 -> sb.append(charArray[1], charArray[2], charArray[2], charArray[2] );
            7 -> sb.append(charArray[1], charArray[2], charArray[2]);
            6 -> sb.append(charArray[1], charArray[2]);
            5 -> sb.append(charArray[1])
            4 -> sb.append(charArray[2], charArray[1]);
            3 -> sb.append(charArray[2], charArray[2], charArray[2]);
            2 -> sb.append(charArray[2], charArray[2]);
            1 -> sb.append(charArray[2])
        }
    }
    if (ss >= 1000) {
        repeat(ss / 1000) { sb.append('M') }
        ss %= 1000
    }
    if (ss >= 100) {
        appendIt(ss / 100, charArrayOf('M', 'D', 'C'))
        ss %= 100
    }
    if (ss >= 10) {
        appendIt(ss / 10, charArrayOf('C', 'L', 'X'))
        ss %= 10
    }
    appendIt(ss, charArrayOf('X', 'V', 'I'))
    return sb.toString()
}

