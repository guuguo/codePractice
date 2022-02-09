package com.company


/**
 * @author guuguo
 * @see <a href="https://leetcode-cn.com/problems/minimum-path-sum/">leetcode链接</a>*/
fun isNumber(s: String): Boolean {
    ///当前阶段  0 是初始(可以有+，-)  1是小数或者整数 2是有值之后的小数或整数  3是没值小数点后整数 6是有值小数点后整数  4是e后初始(可以有+，-) 5是e后没值整数 7是e后有值整数
    var currentState=0
    s.forEach {c->
        when (currentState) {
            0 -> {
                currentState = when {
                    c == '+' || c == '-' -> 1
                    c - '0' in 0..9 -> 2
                    c == '.' -> 3
                    else ->  return false
                }
            }
            1 -> {
                currentState = when {
                    c - '0' in 0..9 -> 2
                    c == '.' -> 3
                    else ->  return false
                }
            }
            2 -> {
                currentState = when {
                    c == 'e' || c == 'E' -> 4
                    c - '0' in 0..9 -> 2
                    c == '.' -> 6
                    else ->  return false
                }
            }
            3 -> {
                currentState = when {
                    c - '0' in 0..9 -> 6
                    else ->  return false
                }
            }
            6 -> {
                currentState = when {
                    c == 'e' || c == 'E' -> 4
                    c - '0' in 0..9 -> 6
                    else ->  return false
                }
            }
            4 -> {
                currentState = when {
                    c == '+' || c == '-' -> 5
                    c - '0' in 0..9 -> 7
                    else ->  return false
                }
            }

            5 -> {
                currentState = when {
                    c - '0' in 0..9 -> 7
                    else ->  return false
                }
            }
            7 -> {
                currentState = when {
                    c - '0' in 0..9 -> 7
                    else ->  return false
                }
            }
        }
    }

    return currentState==2||currentState==6||currentState==7
}