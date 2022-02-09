package com.company

import java.util.*
import kotlin.math.min


/**
 * @author guuguo
 * @see <a href="https://leetcode-cn.com/problems/minimum-path-sum/">leetcode链接</a>*/
fun minPathSum(grid: Array<IntArray>): Int {
    for (i in grid.size - 1 downTo 0) {
        for (j in grid[0].size - 1 downTo 0) {
            if (j < grid[0].size - 1&& i < grid.size - 1){
                grid[i][j] += min(grid[i][j + 1],grid[i + 1][j])
            }else if(j < grid[0].size - 1){
                grid[i][j] +=grid[i][j + 1]
            }else if(i < grid.size - 1){
                grid[i][j] +=grid[i+1][j]
            }
        }
    }
    return grid[0][0]
}