package com.company

import java.lang.StringBuilder
import kotlin.math.min


/**
 * @author guuguo
 * On*/

val table = Array(10) { i ->
    Array(10) { j -> i * j }
}

fun multiply(num1: String, num2: String): String {
    if (num1 == "0" || num2 == "0") return "0"
    if (num1 == "1") return num2
    if (num2 == "1") return num1
    val short: String
    val long: String
    if (num1.length < num2.length) {
        short = num1
        long = num2
    } else {
        short = num2
        long = num1
    }
    val sbArray = Array(short.length) {
        IntArray(long.length + 1)
    }
    var mode = 0
    for (i in short.lastIndex downTo 0) {
        mode = 0
        val sb = sbArray[short.lastIndex - i]
        val numi = short[i] - '0'
        if (numi == 0) {
            continue
        }


        for (j in long.lastIndex downTo 0) {
            val numj = long[j] - '0'
            var result = table[numi][numj]
            result += mode
            sb[long.lastIndex-j] =  (result % 10)
            mode = result / 10
        }
        sb[sb.lastIndex] =  mode
    }

    val resultSb = StringBuilder()

    var count = 0
    mode = 0
    for (i in 0 until sbArray.last().size + sbArray.lastIndex) {
        count = 0
        for (j in 0..min(i, sbArray.lastIndex)) {
            count += sbArray[j].getOrElse(i - j) { 0 }
        }
        count += mode
        mode = count / 10
        resultSb.append(count % 10)
    }
    if (mode != 0) resultSb.append(mode)

    return resultSb.reverse().toString().removePrefix("0")
}
