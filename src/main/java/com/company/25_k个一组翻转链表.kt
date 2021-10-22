package com.company


/**
 * @author guuguo
 *
 * @see <a href="https://leetcode-cn.com/problems/reverse-nodes-in-k-group/">leetcode链接</a>
 * On*/
fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    if (head == null) return null
    if (k == 1) return head
    ///翻转的第一个
    val pre = ListNode(0)
    ///翻转数组头结点的前一个
    pre.next = head

    ///翻转数组的最后一个
    var reverseLast: ListNode? = pre

    while (reverseLast?.next != null) {
        reverseLast = reverseKGroupLast(reverseLast, reverseLast.next, k)
        if (reverseLast == null) {
            break
        }
    }
    return pre.next
}

fun reverseKGroupLast(pre: ListNode, head: ListNode?, k: Int): ListNode? {
    if (head == null) return head
    if (k <= 1) {
        pre.next = head
        return head
    }
    reverseKGroupLast(pre, head.next, k - 1).let {
        if (it == null) {
            pre.next = head
            return null
        }
        head.next = it.next
        it.next = head
        return head
    }
}
