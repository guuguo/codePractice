import com.company.*
import org.junit.Assert.assertEquals
import org.junit.Test

class `Test21-40` {
    @Test
    fun test21() {
        {
            repeat(1) {
                assertEquals(ListNode(1) + 1 + 2 + 3 + 4 + 4, mergeTwoLists(ListNode(1) + 2 + 4, ListNode(1) + 3 + 4))
                assertEquals(ListNode(1) + 2 + 4, mergeTwoLists(ListNode(1) + 2 + 4, null))
                assertEquals(ListNode(1) + 2 + 3 + 4, mergeTwoLists(ListNode(1) + 2 + 4, ListNode(3)))
                assertEquals(null, mergeTwoLists(null, null))
            }
        }.checkTime()
    }

    @Test
    fun test22() {
        {
            repeat(10000) {
                assertEquals(listOf("((()))", "(()())", "(())()", "()(())", "()()()"), generateParenthesis(3))
                assertEquals(listOf("()"), generateParenthesis(1))
            }
        }.checkTime()
    }
    @Test
    fun test23() {
        {
            repeat(10000) {
                assertEquals(ListNode(1) + 1 + 2 + 3 + 4 + 4 + 5 + 6, mergeKLists(arrayOf(ListNode(1) + 4 + 5, ListNode(1) + 3 + 4, ListNode(2) + 6)))
                assertEquals(null, mergeKLists(arrayOf(null, null, null)))
                assertEquals(null, mergeKLists(arrayOf()))
                assertEquals(ListNode(1) + 1, mergeKLists(arrayOf(ListNode(1) + 1, null, null)))
                assertEquals(ListNode(1) + 2 + 3, mergeKLists(arrayOf(ListNode(1) + 3, null, ListNode(2))))
            }
        }.checkTime()
    }
    @Test
    fun test24() {
        {
            repeat(10000) {
                assertEquals(ListNode(2) + 1 + 4 + 3, swapPairs(ListNode(1) + 2 + 3 + 4))
                assertEquals(null, swapPairs(null))
                assertEquals(ListNode(2), swapPairs(ListNode(2)))
                assertEquals(ListNode(1) + 2 + 3, swapPairs(ListNode(2) + 1 + 3))
            }
        }.checkTime()
    }
    @Test
    fun test25() {
        {
            repeat(10000) {
                assertEquals(ListNode(2) + 1 + 4 + 3 + 5, reverseKGroup(ListNode(1) + 2 + 3 + 4 + 5, 2))
                assertEquals(ListNode(3) + 2 + 1 + 4 + 5, reverseKGroup(ListNode(1) + 2 + 3 + 4 + 5, 3))
                assertEquals(ListNode(4) + 3 + 2 + 1 + 5, reverseKGroup(ListNode(1) + 2 + 3 + 4 + 5, 4))
                assertEquals(ListNode(4) + 3 + 2 + 1, reverseKGroup(ListNode(1) + 2 + 3 + 4, 4))
                assertEquals(ListNode(2) + 1 + 4 + 3, reverseKGroup(ListNode(1) + 2 + 3 + 4, 2))
                assertEquals(ListNode(1) + 2 + 3 + 4 + 5, reverseKGroup(ListNode(1) + 2 + 3 + 4 + 5, 1))
                assertEquals(null, reverseKGroup(null, 0))
            }
        }.checkTime()
    }
    @Test
    fun test27() {
        {
            repeat(10000) {
                assertEquals(2, removeElement(intArrayOf(3, 2, 2, 3), 3))
                assertEquals(5, removeElement(intArrayOf(0, 1, 2, 2, 3, 0, 4, 2), 2))
            }
        }.checkTime()
    }
    @Test
    fun test28() {
        {
            repeat(10000) {
                assertEquals(2, strStr("hello", "ll"))
                assertEquals(-1, strStr("aaaa", "bba"))
                assertEquals(-1, strStr("", "bba"))
                assertEquals(0, strStr("aaa", ""))
            }
        }.checkTime()
    }
    @Test
    fun test29() {
        {
            repeat(10000) {
                assertEquals(715827882, divide(2147483647, 3))
                assertEquals(2147483647, divide(-2147483648, -1))
                assertEquals(-2147483648, divide(-2147483648, 1))
                assertEquals(3, divide(10, 3))
                assertEquals(-1, divide(1, -1))
                assertEquals(1, divide(2, 2))
                assertEquals(-2, divide(7, -3))
                assertEquals(0, divide(0, -3))
            }
        }.checkTime()
    }
}