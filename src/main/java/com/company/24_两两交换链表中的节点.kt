package com.company

import java.util.*
import kotlin.collections.ArrayList


/**
 * @author guuguo
 *
 * @see <a href="https://leetcode-cn.com/problems/merge-k-sorted-lists/">leetcode链接</a>
 * On*/
fun swapPairs(head: ListNode?): ListNode? {
    if (head?.next == null) return head

    val next=head.next!!
    head.next = swapPairs(next.next)
    next.next=head
    return next
}

