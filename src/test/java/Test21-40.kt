import com.company.*
import kotlinx.coroutines.coroutineScope
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

    @Test
    fun test30() {
        {
            repeat(10000) {
                assertEquals(listOf(0, 9), findSubstring("barfoothefoobarman", arrayOf("foo", "bar")))
                assertEquals(listOf<Int>(), findSubstring("wordgoodgoodgoodbestword", arrayOf("word", "good", "best", "word")))
                assertEquals(listOf(0, 1, 2, 3), findSubstring("aaaaa", arrayOf("a", "a")))
            }
        }.checkTime()
    }

    @Test
    fun test31() {
        {
            repeat(10000) {

                assertEquals(intArrayOf(2, 2, 1, 1, 2, 2, 2, 2).toList().toString(), intArrayOf(2, 1, 2, 2, 2, 2, 2, 1).also { nextPermutation(it) }.toList().toString())
                assertEquals(intArrayOf(2, 3, 3, 1, 3).toList().toString(), intArrayOf(2, 3, 1, 3, 3).also { nextPermutation(it) }.toList().toString())
                assertEquals(intArrayOf(2, 3, 1, 2, 2, 2, 4, 5, 7).toList().toString(), intArrayOf(2, 2, 7, 5, 4, 3, 2, 2, 1).also { nextPermutation(it) }.toList().toString())
                assertEquals(intArrayOf(3, 1, 2).toList().toString(), intArrayOf(2, 3, 1).also { nextPermutation(it) }.toList().toString())
                assertEquals(intArrayOf(2, 1, 3).toList().toString(), intArrayOf(1, 3, 2).also { nextPermutation(it) }.toList().toString())
                assertEquals(intArrayOf(1, 3, 2).toList().toString(), intArrayOf(1, 2, 3).also { nextPermutation(it) }.toList().toString())
                assertEquals(intArrayOf(1, 2, 3).toList().toString(), intArrayOf(3, 2, 1).also { nextPermutation(it) }.toList().toString())
                assertEquals(intArrayOf(1, 5, 1).toList().toString(), intArrayOf(1, 1, 5).also { nextPermutation(it) }.toList().toString())
                assertEquals(intArrayOf(1, 5, 7).toList().toString(), intArrayOf(7, 5, 1).also { nextPermutation(it) }.toList().toString())
                assertEquals(intArrayOf().toList().toString(), intArrayOf().also { nextPermutation(it) }.toList().toString())
                assertEquals(intArrayOf(1).toList().toString(), intArrayOf(1).also { nextPermutation(it) }.toList().toString())
                assertEquals(intArrayOf(1, 2, 3, 4, 6, 5).toList().toString(), intArrayOf(1, 2, 3, 4, 5, 6).also { nextPermutation(it) }.toList().toString())
            }
        }.checkTime()
    }

    @Test
    fun test32() {
        {
            repeat(10000) {
                assertEquals(2, longestValidParentheses("()"))
                assertEquals(20, longestValidParentheses("(()(((()()()()())))))()())()(())(()"))
                assertEquals(4, longestValidParentheses("))()(()()"))
                assertEquals(2, longestValidParentheses("(()(((()"))
                assertEquals(2, longestValidParentheses("()(()"))
                assertEquals(2, longestValidParentheses("(()"))
                assertEquals(4, longestValidParentheses(")()())"))
                assertEquals(0, longestValidParentheses(""))
                assertEquals(0, longestValidParentheses(")"))
                assertEquals(2, longestValidParentheses(")()("))
                assertEquals(10, longestValidParentheses("((()))()()))()"))
            }
        }.checkTime()
    }

    @Test
    fun test33() {
        {
            repeat(10000) {
                assertEquals(4, search(intArrayOf(4, 5, 6, 7, 0, 1, 2), target = 0))
                assertEquals(0, search(intArrayOf(3, 5, 1), target = 3))
                assertEquals(1, search(intArrayOf(2, 3, 4, 5, 6, 7, 8, 9, 1), target = 3))
                assertEquals(5, search(intArrayOf(6, 7, 1, 2, 3, 4, 5), target = 4))
                assertEquals(2, search(intArrayOf(5, 7, 2), target = 2))
                assertEquals(-1, search(intArrayOf(4, 5, 6, 7, 0, 1, 2), target = 3))
                assertEquals(-1, search(intArrayOf(1), target = 0))
                assertEquals(-1, search(intArrayOf(), target = 0))
            }
        }.checkTime()
    }

    @Test
    fun test34() {
        {
            repeat(10000) {
                assertEquals(intArrayOf(1, 1).joinToString(), searchRange(intArrayOf(1, 4), target = 4).joinToString())
                assertEquals(intArrayOf(3, 4).joinToString(), searchRange(intArrayOf(5, 7, 7, 8, 8, 10), target = 8).joinToString())
                assertEquals(intArrayOf(-1, -1).joinToString(), searchRange(intArrayOf(5, 7, 7, 8, 8, 10), target = 6).joinToString())
                assertEquals(intArrayOf(-1, -1).joinToString(), searchRange(intArrayOf(), target = 6).joinToString())
                assertEquals(intArrayOf(1, 6).joinToString(), searchRange(intArrayOf(1, 2, 2, 2, 2, 2, 2, 4), target = 2).joinToString())
                assertEquals(intArrayOf(0, 6).joinToString(), searchRange(intArrayOf(2, 2, 2, 2, 2, 2, 2, 4), target = 2).joinToString())
                assertEquals(intArrayOf(0, 7).joinToString(), searchRange(intArrayOf(2, 2, 2, 2, 2, 2, 2, 2), target = 2).joinToString())
            }
        }.checkTime()
    }

    @Test
    fun test35() {
        {
            repeat(10000) {
                assertEquals(4, searchInsert(intArrayOf(1, 3, 5, 6), target = 7))
                assertEquals(2, searchInsert(intArrayOf(1, 3, 5, 6), target = 5))
                assertEquals(1, searchInsert(intArrayOf(1, 3, 5, 6), target = 2))
                assertEquals(0, searchInsert(intArrayOf(1, 3, 5, 6), target = 0))
                assertEquals(2, searchInsert(intArrayOf(1, 3, 5, 7, 9), target = 5))
            }
        }.checkTime()
    }

    @Test
    fun test36() {
        {
            repeat(10000) {
                assertEquals(true, isValidSudoku(arrayOf(
                        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
                        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
                        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
                        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
                        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
                        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
                        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
                        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
                        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
                )))
                assertEquals(false, isValidSudoku(arrayOf(
                        charArrayOf('8', '3', '.', '.', '7', '.', '.', '.', '.'),
                        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
                        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
                        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
                        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
                        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
                        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
                        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
                        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
                )))
            }
        }.checkTime()
    }

    @Test
    fun test37() {
        {
            repeat(1) {
                assertEquals(arrayOf(
                        charArrayOf('5', '3', '4', '6', '7', '8', '9', '1', '2'),
                        charArrayOf('6', '7', '2', '1', '9', '5', '3', '4', '8'),
                        charArrayOf('1', '9', '8', '3', '4', '2', '5', '6', '7'),
                        charArrayOf('8', '5', '9', '7', '6', '1', '4', '2', '3'),
                        charArrayOf('4', '2', '6', '8', '5', '3', '7', '9', '1'),
                        charArrayOf('7', '1', '3', '9', '2', '4', '8', '5', '6'),
                        charArrayOf('9', '6', '1', '5', '3', '7', '2', '8', '4'),
                        charArrayOf('2', '8', '7', '4', '1', '9', '6', '3', '5'),
                        charArrayOf('3', '4', '5', '2', '8', '6', '1', '7', '9')
                ).joinToString {it.joinToString()}, arrayOf(
                        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
                        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
                        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
                        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
                        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
                        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
                        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
                        charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
                        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
                ).also { solveSudoku(it) }.joinToString {it.joinToString()})
            }
        }.checkTime()
    }
}