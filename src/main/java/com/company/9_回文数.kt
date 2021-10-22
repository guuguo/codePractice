package com.company

import kotlin.test.assertEquals

/**
 * @author guuguo
 * @see <a href="https://leetcode-cn.com/problems/palindrome-number">leetcode链接</a>*/
fun isPalindrome(x: Int): Boolean {
    val str = x.toString()
    var i1 = 0
    var i2 = str.length - 1
    for (i in 0 until (str.length + 1) / 2) {
        if (str[i1] == str[i2]) {
            i1++
            i2--
            continue
        }
        else
            return false
    }
    return true
}
