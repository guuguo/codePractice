package com.company

import java.util.*


/**
 * @author guuguo
 * @see <a href="https://leetcode-cn.com/problems/unique-paths-ii/">leetcode链接</a>*/
fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
    val m=obstacleGrid.size-1
    val n=obstacleGrid[0].size-1
    if(obstacleGrid[0][0]==1) return 0
    if(obstacleGrid[m][n]==1) return 0
    obstacleGrid[0][0]=1
    for(i in 0..m) {
        for(j in 0..n) {
            if(i==0&&j==0) continue
            if(obstacleGrid[i][j]==1) obstacleGrid[i][j]=0
            else obstacleGrid[i][j]=( if(i==0) 0 else obstacleGrid[i-1][j] )+ (if(j==0) 0 else obstacleGrid[i][j-1])
        }
    }
    return obstacleGrid[m][n]
}