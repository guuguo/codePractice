import com.company.checkTime
import com.company.isMatch
import com.company.isPalindrome
import org.junit.Assert.assertEquals
import org.junit.Test

class TestClass {
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
}