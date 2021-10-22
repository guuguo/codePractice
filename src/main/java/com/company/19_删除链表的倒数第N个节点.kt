package com.company

import java.lang.Math.abs


/**
 * @author guuguo
 *
 * @see <a href="https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/">leetcode链接</a>
 * On*/
fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    if (head == null) return null;
    fun listLength(innerHead: ListNode): Int {
        val length= if (innerHead.next == null) 1
        else listLength(innerHead.next!!) + 1
        if(length==n+1){
            innerHead.next=innerHead.next!!.next
        }
        return length
    }
    val length=listLength(head)
    return if(length==n) head.next
    else head
}

