package com.company

import java.lang.StringBuilder
import java.util.*


/**
 * @author guuguo
 * On*/
fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    if (candidates.isEmpty()) return listOf()
    candidates.sort()
    val maxN = target / candidates.first()
    val minN = target / candidates.last()
    if (maxN == 0) return listOf()
    val result = mutableListOf<List<Int>>()
    for (i in minN..maxN) {
        finNList(candidates, target, 0, i, path = Stack(), result = result)
    }
    return result
}

fun finNList(candidates: IntArray, target: Int, start: Int, n: Int, path: Stack<Int>, result: MutableList<List<Int>>) {
    for (i in start until candidates.size) {
        if (candidates[i] * n > target) return
        val newTarget = target - candidates[i]
        if (newTarget < 0) return
        if (n == 1) {
            if (newTarget == 0)
                result.add(path.toMutableList().apply { add(candidates[i]) })
            else continue
        } else {
            path.add(candidates[i])
            finNList(candidates,newTarget,i,n-1,path,result)
            path.pop()
        }
    }
    return
}