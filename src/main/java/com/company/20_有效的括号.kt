package com.company

import java.lang.Math.abs
import java.util.*


/**
 * @author guuguo
 *
 * @see <a href="https://leetcode-cn.com/problems/valid-parentheses/">leetcode链接</a>
 * On*/
fun isValid(s: String): Boolean {
    if (s.isEmpty()) return true
    val stack = Stack<Char>()
    val map = hashMapOf('(' to 1, ')' to -1, '[' to 2, ']' to -2, '{' to 3, '}' to -3)
    s.forEach {
        val num2 = map[it]!!
        if (stack.isEmpty()) {
            if (num2 < 0) return false
            stack.push(it)
        } else {
            val num1 = map[stack.peek()]!!
            when {
                num1 + num2 == 0 -> stack.pop()
                else -> {
                    if (num2 < 0) return false
                    stack.push(it)
                }
            }
        }
    }
    return stack.isEmpty()
}
