package com.company

class AddTwoNum {
    /**
     * 递归计算next
     * */
    fun addTwoNumbers1(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null && l2 == null) return null
        val sum = (l1?.`val` ?: 0) + (l2?.`val` ?: 0)
        val resNode = ListNode(sum % 10)
        ///不为空的时候下一个节点内容—+上sum/10
        if (sum >= 10)
            (l1?.next ?: l2?.next)?.let { it.`val`++ } ?: apply {
                (l1 ?: l2)?.next = ListNode(1)
            }
        resNode.next = addTwoNumbers1(l1?.next, l2?.next)
        return resNode
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString(): String {
        return "->${`val`}" + (next?.toString()?:"")
    }
}

fun main(args: Array<String>) {
    {
        val node1=ListNode(2).apply { next = ListNode(4).apply { next = ListNode(3) } }
        val node2=ListNode(5).apply { next = ListNode(6).apply { next = ListNode(4) } }
        val res = AddTwoNum().addTwoNumbers1(node1,node2)
        println(node1)
        println(node2)
        println(res)
    }.checkTime()
}