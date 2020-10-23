package com.company


/**
 * @author guuguo
 *
 * @see <a href="https://leetcode-cn.com/problems/next-permutation/">leetcode链接</a>
 * On*/
fun nextPermutation(nums: IntArray): Unit {
    if (nums.isEmpty() || nums.size == 1) return
    var changeIndex: Int = -1
    for (i in (nums.size - 2) downTo 0) {
        if (nums[i] < nums[i + 1]) {
            changeIndex = i
            break
        }
    }
    if (changeIndex == -1) {
        reverse(nums, 0)
        return
    }

    //reverse  reverse后最大的是最后一个
    var nearlyIndex = -1
    reverse(nums, changeIndex + 1)

    for (i in changeIndex + 1 until nums.size) {
        if (nums[i] > nums[changeIndex]) {
            nearlyIndex = i
            break
        }
    }

    swap(nums, changeIndex, nearlyIndex)
}

fun reverse(nums: IntArray, start: Int) {
    for (i in 0 until (nums.size - start + 1) / 2) {
        val ia = i + start
        val ib = nums.size - i - 1
        swap(nums, ia, ib)
    }
}

fun swap(nums: IntArray, i: Int, j: Int) {
    nums[i] = nums[j].also { nums[j] = nums[i] }
}