package com.company

import java.util.*
import kotlin.test.assertEquals

class LongestPalindrome {
    /**
     *
    给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

    示例 1：

    输入: "babad"
    输出: "bab"
    注意: "aba" 也是一个有效答案。
    示例 2：

    输入: "cbbd"
    输出: "bb"

     * */
    fun LongestPalindrome(s: String): String {
        if(s.isEmpty()) return ""
        var bigPair: Pair<Int, Int> = 0 to 0
        repeat(s.length) {
            val currentPair = if (it + 1 == s.length || s[it] != s[it + 1]) {
                getMaxStr(it, it, s)
            } else {
                getBigPair(getMaxStr(it, it, s), getMaxStr(it, it + 1, s))
            }
            bigPair = getBigPair(currentPair, bigPair)
        }
        return s.substring(bigPair.first, bigPair.second+1)
    }

    fun getBigPair(p1: Pair<Int, Int>, p2: Pair<Int, Int>) = if (p2.second - p2.first >= p1.second - p1.first) p2 else p1
    fun getMaxStr(center1: Int, center2: Int, s: String): Pair<Int, Int> {
        var offset = 1;
        while (center1 - offset >= 0 && center2 + offset < s.length && s[center1 - offset] == s[center2 + offset]) {
            offset++;
        }
        return center1 - offset + 1 to center2 + offset - 1
    }

    fun LongestPalindrome2(s: String): String {
        val lastBigStr = StringBuilder();
        val currentStr = mutableListOf<Char>()
        fun checkRes() {
            if (currentStr.size > lastBigStr.length) {
                lastBigStr.clear()
                lastBigStr.append(currentStr.joinToString(""))
            }
        }

        var same = false
        s.forEachIndexed { i, it ->
            ///偶数子串
            if ((currentStr.size == 1 && it == s[i - 1])) {
                same = true
                currentStr.add(it)
            } else if (same && it == s[i - currentStr.size] && it == s[i - currentStr.size]) {
                same = true
                currentStr.add(0, it)
            } else if ((i - currentStr.size - 1 >= 0 && it == s[i - currentStr.size - 1])) {
                same = false
                currentStr.add(it)
                currentStr.add(0, it)
                ///奇数子串
            } else {
                same = false
                checkRes()
                currentStr.clear()
                currentStr.add(it)
            }
        }
        checkRes()
        return lastBigStr.toString()

    }


}

fun main(args: Array<String>) {
    {
        val obj = LongestPalindrome()
        assertEquals("bab", obj.LongestPalindrome("babad"))
        assertEquals("bb", obj.LongestPalindrome("cbbd"))
        assertEquals("basdsab", obj.LongestPalindrome("basdsab"))
        assertEquals("cc", obj.LongestPalindrome("abccde"))
        assertEquals("ccc", obj.LongestPalindrome("ccc"))
        assertEquals("a", obj.LongestPalindrome("abcde"))
        assertEquals("anana", obj.LongestPalindrome("bananas"))
        assertEquals("", obj.LongestPalindrome(""))
    }.checkTime();
//    {
//        val obj = LongestPalindrome()
//        assertEquals("bab", obj.LongestPalindrome2("babad"))
//        assertEquals("bb", obj.LongestPalindrome2("cbbd"))
//        assertEquals("basdsab", obj.LongestPalindrome2("basdsab"))
//        assertEquals("cc", obj.LongestPalindrome2("abccde"))
//        assertEquals("ccc", obj.LongestPalindrome2("ccc"))
//        assertEquals("a", obj.LongestPalindrome2("abcde"))
//        assertEquals("anana", obj.LongestPalindrome2("bananas"))
//
//    }.checkTime()
}