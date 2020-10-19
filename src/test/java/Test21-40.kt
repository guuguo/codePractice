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
                assertEquals(ListNode(1)+1+2+3+4+4+5+6, mergeKLists(arrayOf(ListNode(1)+4+5,ListNode(1)+3+4,ListNode(2)+6)))
                assertEquals(null, mergeKLists(arrayOf(null,null,null)))
                assertEquals(null, mergeKLists(arrayOf()))
                assertEquals(ListNode(1)+1, mergeKLists(arrayOf(ListNode(1)+1,null,null)))
                assertEquals(ListNode(1)+2+3, mergeKLists(arrayOf(ListNode(1)+3,null,ListNode(2))))
            }
        }.checkTime()
    }

}