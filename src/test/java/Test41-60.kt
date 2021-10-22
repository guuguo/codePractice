import com.company.*
import kotlinx.coroutines.coroutineScope
import org.junit.Assert.assertEquals
import org.junit.Test

class `Test41-60` {
//    @Test
//    fun test41() {
//        {
//            repeat(1) {
//                assertEquals(3, firstMissingPositive(intArrayOf(1, 2, 0)))
//                assertEquals(2, firstMissingPositive(intArrayOf(1, 1)))
//                assertEquals(2, firstMissingPositive(intArrayOf(3, 4, -1, 1)))
//                assertEquals(1, firstMissingPositive(intArrayOf(7, 8, 9, 11, 12)))
//                assertEquals(6, firstMissingPositive(intArrayOf(2, 4, 1, 3, 5)))
//            }
//        }.checkTime()
//    }

    @Test
    fun test42() {
        {
            repeat(10000) {
                assertEquals(23, trap(intArrayOf(4, 3, 3, 9, 3, 0, 9, 2, 8, 3)))
                assertEquals(0, trap(intArrayOf(7, 9, 7, 3)))
                assertEquals(2, trap(intArrayOf(2, 0, 2)))
                assertEquals(1, trap(intArrayOf(2, 3, 2, 6, 9)))
                assertEquals(6, trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
                assertEquals(9, trap(intArrayOf(4, 2, 0, 3, 2, 5)))
                assertEquals(8, trap(intArrayOf(4, 2, 7, 3, 2, 5, 2, 3)))
                assertEquals(0, trap(intArrayOf(1092)))
                assertEquals(0, trap(intArrayOf(1092, 1239)))
                assertEquals(0, trap(intArrayOf(1092, 1092, 1092)))
                assertEquals(0, trap(intArrayOf(80, 81, 1093)))
                assertEquals(1, trap(intArrayOf(80, 79, 1093)))
                assertEquals(0, trap(intArrayOf(1000, 999, 998, 997, 996, 995, 994, 993, 992, 991, 990, 989, 988, 987, 986, 985, 984, 983, 982, 981, 980, 979, 978, 977, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966, 966)))
            }
        }.checkTime()
    }

    @Test
    fun test43() {
        {
            repeat(10000) {
                assertEquals("121", multiply("11", "11"))
                assertEquals("144", multiply("12", "12"))
                assertEquals("6", multiply("2", "3"))
                assertEquals("2312", multiply("1", "2312"))
                assertEquals("56088", multiply("456", "123"))
                assertEquals("40000", multiply("200", "200"))
                assertEquals("100940", multiply("140", "721"))
                assertEquals("0", multiply("0", "2312"))
                assertEquals("121932631112635269", multiply("123456789", "987654321"))
            }
        }.checkTime()
    }

    @Test
    fun test44() {
        {
            repeat(1) {
                assertEquals(false, isMatch2("ab", "*a"))
                assertEquals(false, isMatch2("aa", "a"))
                assertEquals(false, isMatch2("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb", "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"))
                assertEquals(true, isMatch2("abceb", "*a*b"))
                assertEquals(true, isMatch2("aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba", "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a****"))
                assertEquals(true, isMatch2("woshinibaba", "wo*ni*ba"))
                assertEquals(false, isMatch2("woshinibaba", "wo*ni*?c"))
                assertEquals(true, isMatch2("woshinibaba", "?*"))
                assertEquals(false, isMatch2("woshinibaba", ""))
                assertEquals(true, isMatch2("", ""))
                assertEquals(true, isMatch2("woshinibaba", "*???"))
                assertEquals(false, isMatch2("abc", "abd"))
                assertEquals(true, isMatch2("aa", "*"))
                assertEquals(false, isMatch2("abc", "ab"))
                assertEquals(true, isMatch2("abc", "abc"))

            }
        }.checkTime()
    }


}