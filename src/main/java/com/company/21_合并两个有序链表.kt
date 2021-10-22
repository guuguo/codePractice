package com.company

import java.lang.Math.abs
import java.util.*


/**
 * @author guuguo
 *
 * @see <a href="https://leetcode-cn.com/problems/merge-two-sorted-lists/">leetcode链接</a>
 * On*/
fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
    var a = l1
    var b = l2
    if (a == null) return b
    else if (b == null) return a

    var resultHead: ListNode? = null
    var resultNext: ListNode? = null
    if (a.`val` < b.`val`) {
        resultHead = a
        resultNext = a
        a = a.next
    } else {
        resultHead = b
        resultNext = b
        b = b.next
    }
    while (a != null || b != null) {
        when {
            a == null -> {
                resultNext?.next = b
                resultNext = b
                b = b?.next
            }
            b == null -> {
                resultNext?.next = a
                resultNext = a
                a = a.next
            }
            a.`val` < b.`val` -> {
                resultNext?.next = a
                resultNext = a
                a = a.next

            }
            else -> {
                resultNext?.next = b
                resultNext = b
                b = b.next
            }
        }
    }
    return resultHead
}
