package com.company

/**
 * @author guuguo
 * @see <a href="https://leetcode-cn.com/problems/regular-expression-matching/">leetcode链接</a>*/
fun isMatch(s: String, p: String): Boolean {
    fun isMatchIt(sIndex: Int, pIndex: Int): Boolean {
        ///都为空了  相等
        return if (sIndex >= s.length && pIndex >= p.length) true
        ///p 为空 s不为空 不相等
        else if (pIndex >= p.length) false
        else {
            val s1 = s.getOrNull(sIndex)
            val p1 = p[pIndex]
            val p2 = p.getOrNull(pIndex + 1)
            return if (s1 == null && p2 != '*') false
            ///不相等，且不是高级通配符
            else if (s1 != p1 && p1 != '.' && p2 != '*') false
            else if (s1 != p1 && p1 != '.' && p2 == '*') {
                isMatchIt(sIndex, pIndex + 2)
            } else if (p2 != '*') {
                isMatchIt(sIndex + 1, pIndex + 1)
            } else {
                ///匹配上 abc 配 a#b#  b 配 a#b#  b配b#
                (sIndex < s.length && isMatchIt(sIndex + 1, pIndex))||isMatchIt(sIndex, pIndex + 2)|| isMatchIt(sIndex + 1, pIndex + 2)
            }
        }

    }
    return isMatchIt(0, 0)

}
