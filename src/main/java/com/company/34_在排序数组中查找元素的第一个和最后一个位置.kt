package com.company


/**
 * 二分法
 * @author guuguo
 * On*/
fun searchRange(nums: IntArray, target: Int): IntArray {
    if (nums.isEmpty()) return intArrayOf(-1, -1)
    return searchRange(nums, 0, nums.lastIndex, target)
}

fun searchRange(nums: IntArray, start: Int, end: Int, target: Int): IntArray {
    if (end - start <= 1) {
        return when (target) {
            nums[start] -> {
                if (nums[end] == target)
                    intArrayOf(start, end)
                else {
                    intArrayOf(start, start)
                }
            }
            nums[end] -> {
                intArrayOf(end, end)
            }
            else -> intArrayOf(-1, -1)
        }
    }
    val middle = (end - start) / 2 + start

    return if (nums[middle] == target) {
        intArrayOf(searchMin(nums, start, middle, target), searchMax(nums, middle, end, target))
    } else if (nums[middle] < target && nums[end] >= target) {
        searchRange(nums, middle, end, target)
    } else if (nums[start] <= target && nums[middle] > target) {
        searchRange(nums, start, middle, target)
    } else intArrayOf(-1, -1)
}

fun searchMin(nums: IntArray, start: Int, end: Int, target: Int): Int {
    if (end - start <= 1) {
        return if (nums[start] == target) start
        else end
    }
    val middle = (end - start) / 2 + start
    return if (nums[middle] < target) {
        searchMin(nums, middle + 1, end, target)
    } else {
        searchMin(nums, start, middle, target)
    }
}

fun searchMax(nums: IntArray, start: Int, end: Int, target: Int): Int {
    if (end - start <= 1) {
        return if (nums[end] == target) end
        else start
    }
    val middle = (end - start) / 2 + start
    return if (nums[middle] > target) {
        searchMax(nums, start, middle - 1, target)
    } else {
        searchMax(nums, middle, end, target)
    }
}