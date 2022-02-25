package com.company

import kotlin.math.min


/**
 * @author guuguo
 * @see <a href="https://leetcode-cn.com/problems/edit-distance/">leetcode链接</a>*/
lateinit var ds: Array<IntArray>
fun minDistance(word1: String, word2: String): Int {
    if (word1.isEmpty()) return word2.length
    if (word2.isEmpty()) return word1.length
    ds = Array(word1.length+1) {
        IntArray(word2.length+1) {
            -1
        }
    }
    return minDistance(word1, word2, 0, 0);
}

fun minDistance(word1: String, word2: String, i: Int, j: Int): Int {
    if (ds[i][j] != -1) return ds[i][j]
    if (i>word1.lastIndex) return (word2.length-j).also { ds[i][j] = it }
    if (j>word2.lastIndex) return (word1.length-i).also { ds[i][j] = it }

    val d1 = (if (word1[i] == word2[j]) 0 else 1) + minDistance(word1, word2, i + 1, j + 1)
    val d2 = 1 + minDistance(word1, word2, i + 1, j)
    val d3 = 1 + minDistance(word1, word2, i, j+1)

    val res = min(d1, min(d2, d3))
    ds[i][j] = res
    return res
}