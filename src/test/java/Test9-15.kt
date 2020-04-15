import com.company.*
import org.junit.Assert.assertEquals
import org.junit.Test

class `Test9-15` {
    @Test
    fun test9() {
        assertEquals(true, isPalindrome(121))
        assertEquals(true, isPalindrome(12121))
        assertEquals(false, isPalindrome(123))
        assertEquals(false, isPalindrome(-121))
        assertEquals(false, isPalindrome(10))
        assertEquals(true, isPalindrome(0))
    }

    @Test
    fun test10() {
        {
            repeat(10000) {
                assertEquals(false, isMatch("a", ".*..a*"))
                assertEquals(false, isMatch("aa", "a"))
                assertEquals(true, isMatch("aa", "a*"))
                assertEquals(true, isMatch("abc", ".*"))
                assertEquals(false, isMatch("abc", ".*d"))
                assertEquals(true, isMatch("abcd", ".*d"))
                assertEquals(false, isMatch("abc", ".."))
                assertEquals(true, isMatch("abc", "..."))
                assertEquals(true, isMatch("abc", "abc***"))
                assertEquals(false, isMatch("a", "***"))
                assertEquals(true, isMatch("aab", "c*a*b"))
                assertEquals(false, isMatch("mississippi", "mis*is*p*."))
                assertEquals(true, isMatch("mississippi", "mi.*pi"))
            }
        }.checkTime()
    }
    @Test
    fun test11() {
        {
            repeat(10000) {
                assertEquals(49, maxArea(intArrayOf(1,8,6,2,5,4,8,3,7)))
                assertEquals(1, maxArea(intArrayOf(1,2)))
                assertEquals(2, maxArea(intArrayOf(1,2,5)))
            }
        }.checkTime()
    }
    @Test
    fun test12() {
        {
            repeat(10000) {
                assertEquals("III", intToRoman(3))
                assertEquals("IV", intToRoman(4))
                assertEquals("V", intToRoman(5))
                assertEquals("MCMXCIV", intToRoman(1994))
                assertEquals("LVIII", intToRoman(58))
                assertEquals("MMCMXCIX", intToRoman(2999))
                assertEquals("LXXXI", intToRoman(81))
            }
        }.checkTime()
    }
}