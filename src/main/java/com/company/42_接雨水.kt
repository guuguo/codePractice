package com.company


/**
 * @author guuguo
 * On*/
fun trap(height: IntArray): Int {
    if (height.size <= 2) return 0
    var start = 0
    var end = height.lastIndex

    var lastMaxStart = 0
    var lastMaxEnd = height.lastIndex
    ///计算数量
    var startCount = 0
    var endCount = 0
    var result = 0
    do {
        start++;end--

        (height[lastMaxStart] - height[start]).let {
            if (it <= 0) {
                if (start - lastMaxStart > 1) {
                    result += startCount
                }
                lastMaxStart = start
                startCount = 0
            } else {
                startCount += it
            }
        }

        if (lastMaxEnd == lastMaxStart) break

        (height[lastMaxEnd] - height[end]).let {
            if (it <= 0) {
                if (lastMaxEnd - end > 1) {
                    result += endCount
                }
                lastMaxEnd = end
                endCount = 0
            } else {
                endCount += it
            }
        }
    } while (lastMaxEnd > lastMaxStart)
    return result
}
