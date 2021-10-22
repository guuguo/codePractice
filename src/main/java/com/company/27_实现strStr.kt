package com.company


/**
 * @author guuguo
 *
 * @see <a href="https://leetcode-cn.com/problems/implement-strstr/">leetcode链接</a>
 * On*/
fun strStr(haystack: String, needle: String): Int {
    if (needle.isEmpty()) return 0
    if (haystack.isEmpty()) return -1
    for (i in 0..(haystack.length - needle.length))
        if (haystack[i] == needle[0]) {
            var equal = true
            for (j in 1 until needle.length) {
                if (haystack[i + j] != needle[j]) {
                    equal = false
                    break
                }
            }
            if (equal) return i
        }
    return -1
}