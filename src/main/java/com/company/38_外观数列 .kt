package com.company

import java.lang.StringBuilder


/**
 * @author guuguo
 * On*/
fun countAndSay(n: Int): String {
    if (n == 1) return "1"
    var str = "1"
    for (i in 1 until n) {
        val sb = StringBuilder()
        var count = 0
        var lastChar = '0'
        str.forEach {
            if (it != lastChar && lastChar != '0') {
                sb.append(count.toString())
                sb.append(lastChar)
                lastChar = it
                lastChar = it
                count = 1
            } else {
            count++
            }
        }
        if (lastChar != '0') {
            sb.append(count.toString())
            sb.append(lastChar)
        }
        str = sb.toString()
    }
    return str
}