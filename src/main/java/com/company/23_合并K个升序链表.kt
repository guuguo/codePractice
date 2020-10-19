package com.company

import java.util.*
import kotlin.collections.ArrayList


/**
 * @author guuguo
 *
 * @see <a href="https://leetcode-cn.com/problems/merge-k-sorted-lists/">leetcode链接</a>
 * On*/
fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    if(lists.isEmpty()) return null
    var lastLength = lists.size
    var length = (lastLength-1) / 2
    while (lastLength > 1) {
        for (i in 0..length) {
            if (i * 2 + 1 >= lastLength) {
                lists[i] = lists[i * 2]
            } else {
                lists[i] = mergeKListsMutable(lists[i * 2], lists[i * 2 + 1])
            }
        }
        lastLength = length+1
        length /= 2
    }
    return lists[0]
}

fun mergeKListsMutable(list1: ListNode?, list2: ListNode?): ListNode? {
    val head = ListNode(0)
    when {
        list1?.`val` == null -> head.next = list2
        list2?.`val` == null -> head.next = list1
        list1.`val` < list2.`val` -> {
            head.next = list1
            head.next!!.next = mergeKListsMutable(list1.next, list2)
        }
        else -> {
            head.next = list2
            head.next!!.next = mergeKListsMutable(list1, list2.next)
        }
    }
    return head.next
}

//fun mergeKLists(lists: Array<ListNode?>): ListNode? {
//    return mergeKListsMutable(lists.filterNotNull().toMutableList())
//}
//
//fun mergeKListsMutable(lists: MutableList<ListNode>): ListNode? {
//    if (lists.isEmpty()) return null
//    var min: ListNode? = null
//    var index = 0
//    lists.forEachIndexed { i, it ->
//        if (min == null) {
//            min = it
//            index = i
//        } else if (it.`val` < min!!.`val`) {
//            min = it
//            index = i
//        }
//    }
//    if (min == null) return null
//    if (min?.next == null) {
//        lists.removeAt(index)
//    } else {
//        lists[index] = min!!.next!!
//    }
//    min?.next = mergeKListsMutable(lists)
//    return min
//}