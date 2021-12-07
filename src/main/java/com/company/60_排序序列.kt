package com.company

import java.lang.StringBuilder
import kotlin.math.min


/**
 * @author guuguo
 * @see <a href="https://leetcode-cn.com/problems/permutation-sequence/">leetcode链接</a>*/
val res =IntArray(9).apply { this[0]=1 }

fun getPermutation(n: Int, k: Int): String {
    val numChars= CharArray(n){
        '1'+it
    }

    for (i in 1 until n) {
        if (res[i] == 0)
            res[i] = res[i - 1] * (i + 1)
    }
    getPermutation(numChars,0,k-1)
    return String(numChars)
}
fun getPermutation(array: CharArray,arrayStart:Int, k: Int) {
    val n=array.size-arrayStart-1
    if(n==0) return
    if(k>=res[n-1]){
        (k/res[n-1]+arrayStart).let {
            val current=array[it]
            for(i in it downTo arrayStart+1){
                array[i]=array[i-1]
            }
            array[arrayStart]=current
        }
    }
    getPermutation(array,arrayStart+1,k%res[n-1])

}