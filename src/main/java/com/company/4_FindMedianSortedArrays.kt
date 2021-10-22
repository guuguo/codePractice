package com.company

import kotlin.test.assertEquals

class FindMedianSortedArrays {
    /**
     *
    给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

    请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

    你可以假设 nums1 和 nums2 不会同时为空。

    示例 1:

    nums1 = [1, 3]
    nums2 = [2]

    则中位数是 2.0
    示例 2:

    nums1 = [1, 2]
    nums2 = [3, 4]

    则中位数是 (2 + 3)/2 = 2.5

     * */
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val length = Math.max(nums1.size, nums2.size)
        var a1 = 0
        var a2 = nums1.size - 1

        var b1 = 0
        var b2 = nums2.size - 1
        repeat(length) {
            if (b2 - b1 + a2 - a1 <= 0) {
                if (b2 < b1 && a2 == a1) {
                    return nums1[a1].toDouble();
                } else if (b2 < b1) {
                    return (nums1[a1] + nums1[a2]) / 2.0
                } else if (a2 < a1 && b2 == b1) {
                    return nums2[b1].toDouble()
                } else if (a2 < a1) {
                    return (nums2[b1] + nums2[b2]) / 2.0
                } else if (a2 == a1 && b2 == b1) {
                    return (nums2[b1] + nums1[a1]) / 2.0
                }

            }
            ///一条空了另一条来
            if (a1 > a2) {
                b1++;b2--
            } else if (b1 > b2) {
                a1++;a2--
            } else {
                ///都不为空的时候
                ///小的不要
                if (nums1[a1] < nums2[b1]) {
                    a1 += 1
                } else {
                    b1 += 1
                }
                ///大的不要
                if (nums1[a2] > nums2[b2]) {
                    a2 -= 1
                } else {
                    b2 -= 1
                }
            }
        }
        return 0.0
    }

    fun findMedianSortedArrays2(nums1: IntArray, nums2: IntArray): Double {
        val length = Math.max(nums1.size, nums2.size)
        var a1 = 0
        var a2 = nums1.size - 1

        var b1 = 0
        var b2 = nums2.size - 1
        repeat(length) {
            if (b2 - b1 + a2 - a1 <= 0) {
                if (b2 < b1 && a2 == a1) {
                    return nums1[a1].toDouble();
                } else if (b2 < b1) {
                    return (nums1[a1] + nums1[a2]) / 2.0
                } else if (a2 < a1 && b2 == b1) {
                    return nums2[b1].toDouble()
                } else if (a2 < a1) {
                    return (nums2[b1] + nums2[b2]) / 2.0
                } else if (a2 == a1 && b2 == b1) {
                    return (nums2[b1] + nums1[a1]) / 2.0
                }

            }
            ///一条空了另一条来
            if (a1 > a2) {
                b1++;b2--
            } else if (b1 > b2) {
                a1++;a2--
            } else {
                ///都不为空的时候
                ///小的不要
                if (nums1[a1] < nums2[b1]) {
                    a1 += 1
                } else {
                    b1 += 1
                }
                ///大的不要
                if (nums1[a2] > nums2[b2]) {
                    a2 -= 1
                } else {
                    b2 -= 1
                }
            }
        }
        return 0.0
    }
}

fun main(args: Array<String>) {
    {
        val obj = FindMedianSortedArrays()
        assertEquals(2.0, obj.findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2)))
        assertEquals(2.5, obj.findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)))
        assertEquals(3.5, obj.findMedianSortedArrays(intArrayOf(1, 3, 5, 7), intArrayOf(3, 4)))
        assertEquals(3.0, obj.findMedianSortedArrays(intArrayOf(1, 3, 5, 7), intArrayOf(3)))
        assertEquals(4.0, obj.findMedianSortedArrays(intArrayOf(1, 3, 5, 7), intArrayOf()))
        assertEquals(3.0, obj.findMedianSortedArrays(intArrayOf(1, 3, 5, 7), intArrayOf(3)))
        assertEquals(3.0, obj.findMedianSortedArrays(intArrayOf(), intArrayOf(1, 2, 3, 4, 5)))
        assertEquals(6.0, obj.findMedianSortedArrays(intArrayOf(4, 5, 6, 8, 9), intArrayOf()))
    }.checkTime()
}