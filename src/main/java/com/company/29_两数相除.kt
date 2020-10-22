package com.company


/**
 * @author guuguo
 *
 * @see <a href="https://leetcode-cn.com/problems/divide-two-integers/">leetcode链接</a>
 * On*/
//fun divide(dividend: Int, divisor: Int): Int {
//    if (dividend == 0) return 0
//    if (divisor == 1) return dividend
//    if (divisor == -1) {
//        if (0 - dividend == dividend) return Int.MAX_VALUE
//        else 0 - dividend
//    }
//    var res = 0
//    ///符号相等的 结果就是正的
//    val minus = !(dividend < 0 && divisor < 0 || (dividend > 0 && divisor > 0))
//    var dif = if (dividend > 0) 0 - dividend else dividend
//    val abDivisor = if (divisor > 0) 0 - divisor else divisor
//
//    while (dif <= abDivisor) {
//        dif -= abDivisor
//        res++
//    }
//    return if (minus) 0 - res else res
//}
fun divide(dividend: Int, divisor: Int): Int {
    if (dividend == 0) return 0
    if (divisor == 1) return dividend
    if (divisor == -1) {
        return if (0 - dividend == dividend) Int.MAX_VALUE
        else 0 - dividend
    }

    val resCount = div(if (dividend > 0) 0 - dividend else dividend, if (divisor > 0) 0 - divisor else divisor).first
    return if (dividend > 0 && divisor > 0 || (dividend < 0 && divisor < 0)) resCount else 0 - resCount
}

///只支持负的（因为Int的最大值的负数可以表示，但是Int最小值正的不能表示）
fun div(dividend: Int, divisor: Int): Pair<Int, Int> {
    if (divisor > 0) return 0 to dividend
    if (dividend > divisor) return 0 to dividend
    if (dividend == divisor) return 1 to 0

    val (count, remind) = div(dividend, divisor shl 1)
    return if (remind < divisor) {
        (count shl 1) + 1 to remind - divisor
    } else {
        (count shl 1) to remind
    }
}