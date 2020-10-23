package com.company


/**
 * @author guuguo
 *
 * @see <a href="https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/">leetcode链接</a>
 * On*/
fun findSubstring(s: String, words: Array<String>): List<Int> {
    if (words.isEmpty() || s.isEmpty()) return listOf()
    val length = words[0].length
    val wordMap = hashMapOf<String, Int>()
    val tempMap = hashMapOf<String, Int>()

    words.forEach {
        wordMap[it] = (wordMap[it] ?: 0) + 1
    }
    val result = mutableListOf<Int>()
    for (i in 0 .. (s.length - words.size * length)) {
        tempMap.clear()
        for (j in words.indices) {
            val subWord = s.substring(i + j * length, i + j * length + length)
            val wordCount = wordMap[subWord]
            if (wordCount == null) {
                tempMap.clear()
                break
            } else {
                val count = (tempMap[subWord] ?: 0) + 1
                if (count > wordCount) {
                    tempMap.clear()
                    break
                } else {
                    tempMap[subWord] = count
                }
            }
        }
        if (tempMap.isNotEmpty()) {
            result += i
        }
    }
    return result
}