package com.company

import java.lang.Math.abs


/**
 * @author guuguo
 *
 * @see <a href="https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/">leetcode链接</a>
 * On*/
fun letterCombinations(digits: String): List<String> {
    val result = mutableListOf<String>()
    val sb = StringBuffer()
    if (digits.isEmpty()) return listOf()

    fun back(digits: String, index: Int) {
        if (digits.length == sb.length) {
            result.add(sb.toString())
            return
        }
        val s = map[digits[index] - '2']
        s.forEach {
            sb.append(it)
            back(digits, index + 1)
            sb.deleteCharAt(index)
        }
    }
    back(digits, 0)
    return result
}
val map = arrayOf(
        "abc",
        "def",
        "ghi",
        "jkl",
        "mno",
        "pqrs",
        "tuv",
        "wxyz")
