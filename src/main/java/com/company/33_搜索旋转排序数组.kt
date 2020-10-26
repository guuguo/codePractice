package com.company

import kotlin.math.max


/**
 * 二分法
 * @author guuguo
 * On*/
fun search(nums: IntArray, target: Int): Int {
    if (nums.isEmpty()) return -1
    if (target == nums[0]) return 0
    if (target == nums.last()) return nums.size-1
    return searchUnknow(nums, 0, nums.size - 1, target)
}

fun searchUnknow(nums: IntArray, start: Int, end: Int, target: Int): Int {
    if (end-start<=1) return -1
    val middle = (end - start) / 2 + start
    if (target == nums[middle]) return middle

    return if (nums[start] > nums[middle]) {
        if (target >= nums[middle] && target < nums[end]) searchOrder(nums, middle, end, target)
        else searchUnknow(nums, start, middle, target)
    } else if (nums[middle] > nums[end]) {
        if (target > nums[start] && target <= nums[middle]) searchOrder(nums, start, middle, target)
        else searchUnknow(nums, middle, end, target)
    } else {
        max(searchUnknow(nums, start, middle, target), searchUnknow(nums, middle, end, target))
    }
}

fun searchOrder(nums: IntArray, start: Int, end: Int, target: Int): Int {
    if (end-start<=1) return -1
    val middle = (end - start) / 2 + start

    return when {
        target > nums[middle] -> searchOrder(nums, middle, end, target)
        target == nums[middle] -> middle
        else -> searchOrder(nums, start, middle, target)
    }
}