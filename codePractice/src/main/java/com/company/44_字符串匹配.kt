package com.company

import java.lang.StringBuilder
import kotlin.math.min


/**
 * @author guuguo
 * On*/
fun isMatch2(s: String, p: String): Boolean {
    if (s.isNotEmpty() && p.isEmpty()) return false
    if (s == p) return true
    val ps = mutableListOf<String>()
    val sb = StringBuilder()
    var noStarCount = 0
    p.forEach {
        if (it != '*') {
            sb.append(it)
            noStarCount++
        } else if (sb.isNotEmpty()) {
            ps.add(sb.toString())
            sb.clear()
        }
    }
    if (sb.isNotEmpty()) ps.add(sb.toString())

    ///s 的长度不够的话  肯定匹配失败
    if (s.length < noStarCount) return false

    ////第一个或转而最后一个不是通配符的时候，不能匹配上肯定就不是了
    if (p.first() != '*' && !match(s, ps[0], 0, 0)) return false
    if (noStarCount == p.length) return p.length == s.length

    if (p.last() != '*' && !match(s, ps.last(), s.length - ps.last().length, 0)) return false

    return isMatch2(s, ps, 0, 0, noStarCount)
}

private fun isMatch2(s: String, ps: List<String>, i1: Int, i2: Int, noStarCount: Int): Boolean {
    if (i2 >= ps.size) return true
    for (i in i1 until s.length) {
        val p = ps[i2]
        ///剩下匹配长度不够的话，不用再匹配了
        if (s.length - i < noStarCount) {
            return false
        }
        if (!match(s, p, i, 0)) continue
        else {
            return isMatch2(s, ps, i + p.length, i2 + 1, noStarCount - p.length)
        }
    }
    return false
}

private fun match(s: String, p: String, i1: Int, i2: Int): Boolean {
    for (i in i2 until p.length) {
        return if (s[i1] == p[i2] || p[i2] == '?') {
            if (i2 == p.lastIndex) return true
            else match(s, p, i1 + 1, i2 + 1)
        } else false;
    }
    return false
}