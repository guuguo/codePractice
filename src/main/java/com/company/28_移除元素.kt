package com.company


/**
 * @author guuguo
 *
 * @see <a href="https://leetcode-cn.com/problems/remove-element/">leetcode链接</a>
 * On*/
fun removeElement(nums: IntArray, `val`: Int): Int {
    var end = nums.size - 1
    var i = 0
    var length = nums.size
    while (end >= i) {
        if (nums[i] == `val`) {
            length--
            nums[i] = nums[end]
            end--
        } else {
            i++
        }
    }
    return length
}
