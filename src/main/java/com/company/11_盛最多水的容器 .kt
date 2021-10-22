package com.company

import kotlin.math.min

/**
 * @author guuguo
 * @see <a href="https://leetcode-cn.com/problems/container-with-most-water/">leetcode链接</a>
 * On*/
fun maxArea(height: IntArray): Int {
    var lastHeight = 0
    val checkedRightList= mutableListOf<Int>()
    val checkedLeftList= mutableListOf<Int>()
    for (i in height.size - 1 downTo 0) {
        if (height[i] > lastHeight) {
            lastHeight = height[i]
            checkedRightList.add(i)
        }
    }
     lastHeight = 0
    for (i in height.indices) {
        if (height[i] > lastHeight) {
            lastHeight = height[i]
            checkedLeftList.add(i)
        }
    }
    var maxArea = 0
    ///一个个遍历，计算方框面积
    for (checkedLeftIndex in checkedLeftList) {
        ///最后一个开始的
        for (checkedIndex in checkedRightList) {
            ///如果已经是前面的方框了  放弃
            if (checkedIndex <= checkedLeftIndex) break
            ((checkedIndex - checkedLeftIndex) * min(height[checkedLeftIndex], height[checkedIndex])).let {
                if (it > maxArea) maxArea = it
            }
        }
    }
    return maxArea
}
