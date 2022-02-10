package com.company


/**
 * @author guuguo
 * @see <a href="https://leetcode-cn.com/problems/sqrtx/">leetcode链接</a>*/
fun mySqrt(x: Int): Int {
    var left=0
    var right=x
    var mid: Int=0
    while (left<right){
        mid=(right+left)/2
        if((mid.toLong()*mid)<=x) {
            left = mid + 1
        }
        else {
            right = mid-1
        }
    }
    return if(left.toLong()*left<=x) left else left-1
}
