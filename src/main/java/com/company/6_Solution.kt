package com.company

import java.util.*
import kotlin.test.assertEquals

class Solution6 {
    /**
     *
    将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

    比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

    L   C   I   R
    E T O E S I I G
    E   D   H   N
    之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

    请你实现这个将字符串进行指定行数变换的函数：

    string convert(string s, int numRows);
    示例 1:

    输入: s = "LEETCODEISHIRING", numRows = 3
    输出: "LCIRETOESIIGEDHN"
    示例 2:

    输入: s = "LEETCODEISHIRING", numRows = 4
    输出: "LDREOEIIECIHNTSG"
    解释:

    L     D     R
    E   O E   I I
    E C   I H   N
    T     S     G

     * */

    fun convert(s: String, numRows: Int): String {
        if(s.isEmpty()||s.length<=numRows) return s
        val sb = StringBuffer()
        val extent = getExtent(numRows)
        for (out in 0 until numRows) {
            repeat((s.length - 1 - out) / extent + 1) {
                if (out in 1 until numRows - 1 && it != 0) sb.append(s[it * extent - out])
                sb.append(s[it * extent + out])
                if (out in 1 until numRows - 1 && it == (s.length - 1 - out) / extent && getExtent(numRows-out)  + it * extent + out < s.length) {
                    sb.append(s[getExtent(numRows-out)  + it * extent + out ])
                }
            }
        }
        return sb.toString()
    }

    fun getExtent(row: Int) = if (row == 1) 1 else (row - 2) * 2 + 2
}

fun main(args: Array<String>) {
    {
        val obj = Solution6()
        assertEquals("", obj.convert("", 3))
        assertEquals("A", obj.convert("A", 2))
        assertEquals("ABC", obj.convert("ABC", 3))
        assertEquals("LEETCODEISHIRING", obj.convert("LEETCODEISHIRING", 1))
        assertEquals("LCIRETOESIIGEDHN", obj.convert("LEETCODEISHIRING", 3))
        assertEquals("LDREOEIIECIHNTSG", obj.convert("LEETCODEISHIRING", 4))
    }.checkTime();
}