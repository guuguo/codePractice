package com.company

import java.lang.Math.abs


/**
 * @author guuguo
 *
 * @see <a href="https://leetcode-cn.com/problems/4sum/">leetcode链接</a>
 * On*/
///正常思考解法，四层嵌套，复杂度 n四次方？（肯定没那么高，因为判断减少了）
//fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
//    if(nums.size<4) return listOf()
//    nums.sort()
//    val result: MutableList<List<Int>> = mutableListOf()
//    fun Int.value() = nums[this]
//    var aMax = nums.size - 4
//    for (a in 0..aMax) {
//        if(a>0 && a.value()==(a-1).value()) continue
//        if (a > aMax) break
//        var bMax = nums.size - 3
//        for (b in a + 1..bMax) {
//            if(b>a + 1 && b.value()==(b-1).value()) continue
//            val sumAb = a.value() + b.value()
//            if (sumAb + (b + 1).value() + (b + 2).value() > target) aMax = b - 1
//
//            var cMax = nums.size - 2
//            for (c in b + 1..cMax) {
//                if(c>b + 1 && c.value()==(c-1).value()) continue
//                val sumAbc = sumAb + c.value()
//                if (sumAbc + (c + 1).value() > target) bMax = c - 1
//
//                for (d in c + 1 until nums.size) {
//                    if(d>c + 1 && d.value()==(d-1).value()) continue
//                    val sum = sumAbc + d.value()
//                    if (sum == target) {
//                        result.add(listOf(a.value(), b.value(), c.value(), d.value()))
//                        cMax = target
//                        break
//                    } else if (sum > target) {
//                        cMax = target - 1
//                        break
//                    }
//                }
//            }
//        }
//    }
//    return result
//}
fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    if (nums.size < 4) return listOf()
    nums.sort()
    val result: MutableList<List<Int>> = mutableListOf()
    fun Int.value() = nums[this]
    for (a in 0..(nums.size - 4)) {
        if (a.value() * 4 > target) break
        if (a > 0 && a.value() == (a - 1).value()) continue
        for (b in a + 1..nums.size - 3) {
            if (a.value() + b.value() * 3 > target) break
            if (b > a + 1 && b.value() == (b - 1).value()) continue

            var c = b + 1
            var d = nums.size - 1

            val sumAb=a.value()+b.value()
            while (c < d) {
                if (c > b + 1 && c.value() == (c - 1).value()) {
                    c++; continue
                }
                if (d < nums.size - 1 && d.value() == (d + 1).value()) {
                    d--;continue
                }
                val sum=sumAb + c.value() + d.value()
                when {
                    sum > target -> d--
                    sum < target -> c++
                    else -> {
                        result.add(listOf(a.value(), b.value(), c.value(), d.value()))
                        c++
                        d--
                    }
                }
            }
        }
    }
    return result
}