package com.company

import java.util.*


/**
 * @author guuguo
 * @see <a href="https://leetcode-cn.com/problems/rotate-list/">leetcode链接</a>*/
fun rotateRight(head: ListNode?, k: Int): ListNode? {
    if(k==0) return head
    if(head==null) return head;
    val stack= Stack<ListNode>()
    var new =head
    var count=0
    while (new!=null){
        stack.push(new)
        new=new.next
        count++
    }
    val rk=k%count
    if(rk==0) return head

    stack.peek().next=head
    var result:ListNode?=null
    repeat(rk){
        result= stack.pop()
    }
    stack.peek().next=null
    return result
}