package com.company

class LengthOfLongestSubstring {
    /**
     * 递归计算next
     * */
    fun lengthOfLongestSubstring(s: String): Int {
        var iStart = 0
        var maxLength = 0
        var cLength = 0
        for ((i, v) in s.withIndex()) {
            var isBreak = false
            for (j in iStart until i) {
                if (s[j] == v) {
                    iStart = j+1
                    if (cLength > maxLength)
                        maxLength = cLength
                    cLength = i - j
                    isBreak = true
                    break
                }
            }
            if(!isBreak){
                cLength++
            }
        }
        if (cLength > maxLength)
            maxLength = cLength
        return maxLength
    }
}

//fun main(args: Array<String>) {
//    {
//        val obj = LengthOfLongestSubstring()
//        assertEquals(3, obj.lengthOfLongestSubstring("dvdf"))
//        assertEquals(7, obj.lengthOfLongestSubstring("abcdefg"))
//        assertEquals(0, obj.lengthOfLongestSubstring(""))
//        assertEquals(2, obj.lengthOfLongestSubstring("au"))
//        assertEquals(1, obj.lengthOfLongestSubstring(" "))
//        assertEquals(3, obj.lengthOfLongestSubstring("abcabcbb"))
//        assertEquals(1, obj.lengthOfLongestSubstring("bbbbb"))
//        assertEquals(3, obj.lengthOfLongestSubstring("pwwkew"))
//    }.checkTime()
//}