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
}