package com.company

/**
 * @author guuguo
 *
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

 

示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
[-1, 0, 1],
[-1, -1, 2]
]

 * @see <a href="https://leetcode-cn.com/problems/3sum/">leetcode链接</a>
 * On*/
fun threeSum(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    ///排序
    nums.sort()
    for (i in nums.indices) {
        if (nums[i] > 0) break
        else if (i > 0 && nums[i] == nums[i - 1]) continue
        var downToFrom = nums.size - 1
        for (j in i + 1 until nums.size - 1) {
            if (nums[j] + nums[i] + nums[j + 1] > 0) break
            else if (j - i > 1 && nums[j] == nums[j - 1]) continue
            for (k in (j + 1..downToFrom).reversed()) {
                if (k  <nums.size-1 && nums[k] == nums[k + 1]) continue
                val add = nums[i] + nums[j] + nums[k]
                if (add < 0) {
                    downToFrom = k
                    break
                } else if (add == 0) {
                    result.add(listOf(nums[i], nums[j], nums[k]))
                    downToFrom = k
                    break
                }
            }
        }
    }
    return result
}

