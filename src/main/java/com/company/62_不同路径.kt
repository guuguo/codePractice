package com.company

import java.util.*


/**
 * @author guuguo
 * @see <a href="https://leetcode-cn.com/problems/unique-paths/">leetcode链接</a>*/
fun uniquePaths(m: Int, n: Int): Int {
    if(m==1 || n==1) return 1
    return uniquePaths(m-1,n) +uniquePaths(m,n-1)
}