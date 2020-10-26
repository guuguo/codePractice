package com.company


/**
 * 二分法
 * @author guuguo
 * On*/
fun searchInsert(nums: IntArray, target: Int): Int {
    if (nums.isEmpty()) return 0
    if (target <= nums[0]) return 0
    if (target > nums.last()) return nums.size
    return searchInsert(nums, 0, nums.lastIndex, target)
}

fun searchInsert(nums: IntArray, start: Int, end: Int, target: Int): Int {
    if (end - start <= 1) {
        return when {
            target > nums[end] -> end + 1
            target > nums[start] -> end
            else -> start
        }
    }
    val middle = start + (end - start) / 2
    return when {
        target == nums[middle] -> middle
        target > nums[middle] -> searchInsert(nums, middle, end, target)
        else -> searchInsert(nums, start, middle, target)
    }
}
