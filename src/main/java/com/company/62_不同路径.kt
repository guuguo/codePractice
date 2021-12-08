package com.company

import java.util.*


/**
 * @author guuguo
 * @see <a href="https://leetcode-cn.com/problems/unique-paths/">leetcode链接</a>*/
fun uniquePaths(m: Int, n: Int): Int {
    if(!::array.isInitialized || array.size<m || array[0].size<n){
        array= Array(m){IntArray(n){0}}
        array[0][0]=1
    }
    return uniquePaths2(m,n)
}
fun uniquePaths2(m: Int, n: Int): Int {
    if (m == 1 || n == 1) return 1
    if (array[m - 1][n - 1] != 0) return array[m - 1][n - 1]
    array[m - 1][n - 1] = uniquePaths2(m - 1, n) + uniquePaths2(m, n - 1)
    return  array[m - 1][n - 1]
}

lateinit var array:Array<IntArray>