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
                assertEquals(1, uniquePaths(2,1))
                assertEquals(28, uniquePaths(3,7))
                assertEquals(3, uniquePaths(3,2))
                assertEquals(6, uniquePaths(3,3))
                assertEquals(1916797311, uniquePaths(51,9))
            }
        }.checkTime()
    }
    @Test
    fun test63() {
        {
            repeat(10000) {
                assertEquals(2, uniquePathsWithObstacles(arrayOf(intArrayOf(0,0,0),intArrayOf(0,1,0),intArrayOf(0,0,0))))
                assertEquals(0, uniquePathsWithObstacles(arrayOf(intArrayOf(1,0,0),intArrayOf(0,1,0),intArrayOf(0,0,0))))
                assertEquals(0, uniquePathsWithObstacles(arrayOf(intArrayOf(0,0,0),intArrayOf(0,1,0),intArrayOf(0,0,1))))
            }
        }.checkTime()
    }
    @Test
    fun test64() {
        {
            repeat(10000) {
                assertEquals(7, minPathSum(arrayOf(intArrayOf(1,3,1),intArrayOf(1,5,1),intArrayOf(4,2,1))))
                assertEquals(12, minPathSum(arrayOf(intArrayOf(1,2,3),intArrayOf(4,5,6))))
            }
        }.checkTime()
    }
    @Test
    fun test65() {
        {
            repeat(10000) {
                assertEquals(true, isNumber("53.5e93"))
                assertEquals(true, isNumber("-123.456e789"))
                assertEquals(false, isNumber("99e2.5"))
                assertEquals(false, isNumber("--6"))
                assertEquals(false, isNumber("95a54e53"))
                assertEquals(false, isNumber("."))
                assertEquals(false, isNumber(".5e"))
                assertEquals(true, isNumber(".5e1"))
                assertEquals(false, isNumber(".e"))
                assertEquals(false, isNumber(".e1"))
            }
        }.checkTime()
    }

}