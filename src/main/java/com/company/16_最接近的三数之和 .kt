package com.company

import java.lang.Math.abs


/**
 * @author guuguo
 *
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

 

示例：

输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 

提示：

3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4

 * @see <a href="https://leetcode-cn.com/problems/3sum-closest">leetcode链接</a>
 * On*/
fun threeSumClosest(nums: IntArray, target: Int): Int {
    nums.sort()
    var closestSum = nums[0] + nums[1] + nums[2]
    for (i in nums.indices) {
        var checkEnd = nums.size - 1
        for (j in (i + 1) until nums.size) {
            val start = j + 1
            if (start > checkEnd) break
            val k = checkNums(nums[i] + nums[j] - target, start, checkEnd, nums)
            val sum = nums[i] + nums[j] + nums[k]
            if (abs(sum - target) < abs(closestSum - target)) {
                closestSum = sum
            }
            checkEnd = k
        }
    }

    return closestSum
}

/**[sum]  a+b-target*/
private fun checkNums(sum: Int, start: Int, end: Int, nums: IntArray): Int {
    if (start == end) return start
    val k = (start + end) / 2
    val kOff = abs(sum + nums[k])
    var nextK = end
    for (nk in k + 1 until end) {
        if (nums[nk] != nums[k]) {
            nextK = nk
            break
        }
    }
    var beforeK = start
    for (bk in k-1 downTo  start) {
        if (nums[bk] != nums[k]) {
            beforeK = bk
            break
        }
    }
    if (kOff == 0) return k
    if (kOff > abs(sum + nums[nextK])) return checkNums(sum, nextK, end, nums)
    if (k == start) return k
    if (kOff > abs(sum + nums[beforeK])) return checkNums(sum, start, beforeK, nums)
    return k
}

