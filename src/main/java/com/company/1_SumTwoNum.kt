package com.company

class Solution {
    /**
     * 使用循环嵌套的方式，结果保存到数组中
     * */
    fun twoSum1(nums: IntArray, target: Int): IntArray {
        val tempArray = IntArray(nums.size)
        nums.forEachIndexed { i, it ->
            tempArray[i] = target - it
            var j = -1
            while (++j < i) {
                if (tempArray[j] == it) {
                    return intArrayOf(j, i)
                }
            }
        }
        return intArrayOf(0, 0)
    }

    /**
     * 使用循环嵌套的方式，结果保存到 hashMap 数组中 效率高一些
     * */
    fun twoSum2(nums: IntArray, target: Int): IntArray {
        ///第一个 Int 是值 第二个是 index 索引
        val tempArray = mutableMapOf<Int, Int>()
        for((i,it) in nums.withIndex()){
            if (tempArray.containsKey(it)) {
                return intArrayOf(tempArray[it]!!, i)
            }
            tempArray[target - it] = i
        }
        return intArrayOf(0, 0)
    }
}

fun main(args: Array<String>) {
    {
        val res = Solution().twoSum2(intArrayOf(2, 7, 11, 15), 26)
        println(res[0])
        println(res[1])
    }.checkTime()
}