package com.company


/**
 * @author guuguo
 * @see <a href="https://leetcode-cn.com/problems/climbing-stairs/">leetcode链接</a>*/
fun climbStairs(n: Int): Int {
    if(n==1) return 1
    if(n==2) return 2
    var pre=2
    var prePre=1
    var current: Int
    for(i in 3..n)
    {
        current=prePre+pre
        prePre=pre
        pre=current
    }
    return pre
}