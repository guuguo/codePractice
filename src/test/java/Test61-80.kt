import com.company.*
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test

class `Test61-80` {

    @Test
    fun test61() {
        {
            repeat(10000) {
                assertEquals(ListNode(2)+3+4+5+1, rotateRight(ListNode(1)+2+3+4+5,4))
                assertEquals(ListNode(3)+4+5+1+2, rotateRight(ListNode(1)+2+3+4+5,3))
                assertEquals(ListNode(3)+4+5+1+2, rotateRight(ListNode(1)+2+3+4+5,8))
                assertEquals(ListNode(3), rotateRight(ListNode(3),100))
                assertEquals(ListNode(3)+4+5+1+2, rotateRight(ListNode(3)+4+5+1+2,0))
                assertEquals(null, rotateRight(null,93))
            }
        }.checkTime()
    }
    @Test
    fun test62() {
        {
            repeat(10000) {
                assertEquals(ListNode(2)+3+4+5+1, uniquePaths(2))
                assertEquals(ListNode(3)+4+5+1+2, rotateRight(ListNode(1)+2+3+4+5,3))
                assertEquals(ListNode(3)+4+5+1+2, rotateRight(ListNode(1)+2+3+4+5,8))
                assertEquals(ListNode(3), rotateRight(ListNode(3),100))
                assertEquals(ListNode(3)+4+5+1+2, rotateRight(ListNode(3)+4+5+1+2,0))
                assertEquals(null, rotateRight(null,93))
            }
        }.checkTime()
    }

}