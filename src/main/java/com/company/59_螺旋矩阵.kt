package com.company

import java.lang.StringBuilder
import kotlin.math.min


/**
 * @author guuguo
 * @see <a href="https://leetcode-cn.com/problems/spiral-matrix-ii/">leetcode链接</a>*/
fun generateMatrix(n: Int): Array<IntArray> {
    val res = Array(n) { IntArray(n) }
    var border = 0;
    var i = 0;
    var j = 0;
    var num = 1;
    res[i][j] = num
    val max=n*n
    var arrow=0
    while (num<max) {
        when (arrow) {
            //右
            0 -> {
                    num++
                    i++
                    if(i+border==n-1){
                        arrow=1
                    }
            }
            //下
            1 -> {
                num++
                j++
                if (j + border == n - 1)
                    arrow = 2
            }
            2->{
                num++
                i--
                if(i == border) {
                    border++
                    arrow = 3
                }
            }
            3->{
                num++
                j--
                if(j == border)
                    arrow=0
            }
        }
        res[j][i] = num
    }
    return res
}