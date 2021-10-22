package com.company

import java.util.*
import kotlin.math.max


/**
 * @author guuguo
 *
 * @see <a href="https://leetcode-cn.com/problems/longest-valid-parentheses/">leetcode链接</a>
 * On*/

//fun longestValidParentheses(s: String): Int {
//    if (s.isEmpty()) return 0
//    return longestValidParentheses(s)
//}
//
/////递归判断最长  时间复杂度n^2
//fun longestValidParentheses(s: String, start: Int): Int {
//    if (start >= s.length) return 0
//    var count = 0
//    var maxValid = 0
//    var sum = 0
//    var lastZeroIndex = start-1
//    for (i in start until s.length) {
//        count++
//        if (s[i] == '(') sum += 1
//        else if (s[i] == ')') {
//            sum += -1
//        }
//        when {
//            sum == 0 -> {
//                maxValid = count - sum
//                lastZeroIndex = i
//            }
//            sum < 0 -> return max(maxValid, longestValidParentheses(s, i + 1))
//            i == s.length - 1 -> {
//                return max(maxValid, longestValidParentheses(s, lastZeroIndex + 2))
//            }
//        }
//    }
//    return maxValid
//}


/////动态规划方式
//fun longestValidParentheses(s: String): Int {
//    if (s.length<2) return 0
//    val array = IntArray(s.length) { 0 }
//    if (s[0] == '(' && s[1] == ')')
//        array[1] = 2
//    var max = array[1]
//    for (i in 2 until s.length) {
//        if (s[i] == '(') continue
//        getLongestValidParentheses(array, s, i).let {
//            if (max < it) max = it
//        }
//    }
//    return max
//}
//
//fun getLongestValidParentheses(array: IntArray, s: String, index: Int): Int {
//    if (s[index - 1] == '(' && s[index] == ')') {
//        array[index] = array[index - 2] + 2
//    } else if (s[index - 1] == ')' && s[index] == ')') {
//        val last = index - array[index - 1] - 1
//        if (last >= 0 && s[last] == '(') array[index] = array[index - 1] + 2 + (if (last - 1 < 0) 0 else array[last - 1])
//    }
//    return array[index]
//}


///栈方式
fun longestValidParentheses(s: String): Int {
    if (s.length < 2) return 0
    val stack = Stack<Int>()
    stack.push(-1)
    var max = 0
    for (i in s.indices) {
        if (s[i] == '(') {
            stack.push(i)
        } else if (s[i] == ')') {
            stack.pop()
            if (stack.isEmpty()) {
                stack.push(i)
                continue
            }
            max = max(max, i - stack.peek())
        }
    }
    return max
}


