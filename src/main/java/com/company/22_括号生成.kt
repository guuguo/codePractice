package com.company

import java.util.*


/**
 * @author guuguo
 *
 * @see <a href="https://leetcode-cn.com/problems/generate-parentheses/">leetcode链接</a>
 * On*/
fun generateParenthesis(n: Int): List<String> {
    if (n == 0) return listOf()
    if (n == 1) return listOf("()")
    val list = mutableListOf<String>()

    val sb = StringBuilder()
    sb.append('(')
    val count = n * 2
    val opSum = 1
    generate(list, opSum, sb, count - 1)
    return list
}

fun generate(list: MutableList<String>, opSum: Int, sb: StringBuilder, count: Int) {
    if (opSum < 0) return
    if (count == 1) {
        if (opSum - 1 == 0) {
            sb.append(')')
            list.add(sb.toString())
            sb.deleteCharAt(sb.length - 1);
        }
        return
    }
    ///如果不符合
    if (opSum == 0) {
        sb.append('(')
        generate(list, opSum + 1, sb, count - 1)
        sb.deleteCharAt(sb.length - 1);
        return
    }
    if (opSum > 0) {
        ///第一种情况 加’(‘
        sb.append('(')
        generate(list, opSum + 1, sb, count - 1)
        ///清除第一种情况操作
        sb.deleteCharAt(sb.length - 1);

        ///第二种情况 加 ’)‘
        sb.append(')')
        generate(list, opSum - 1, sb, count - 1)
        ///恢复
        sb.deleteCharAt(sb.length - 1);
        return
    }
    if (opSum < 0)
        return
}

