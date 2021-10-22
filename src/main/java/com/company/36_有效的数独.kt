package com.company

import java.util.*


/**
 * @author guuguo
 * On*/
//fun isValidSudoku(board: Array<CharArray>): Boolean {
//    val hashSet = hashSetOf<Char>()
//    for (i in 0 until 9) {
//        ///每一横
//        hashSet.clear()
//        board[i].forEach {
//            if (it != '.') {
//                if (hashSet.contains(it)) return false
//                hashSet.add(it)
//            }
//        }
//
//        hashSet.clear()
//        val sX = i * 3 % 9
//        val sY = i / 3 * 3
//        for (j in 0 until 9) {
//            val x = sX + j % 3
//            val y = sY + j / 3
//            board[y][x].let {
//                if (it != '.') {
//                    if (hashSet.contains(it)) return false
//                    hashSet.add(it)
//                }
//            }
//        }
//
//        hashSet.clear()
//        for (j in 0 until 9) {
//            board[j][i].let {
//                if (it != '.') {
//                    if (hashSet.contains(it)) return false
//                    hashSet.add(it)
//                }
//            }
//        }
//    }
//    return true
//}
//
///三个int数组
fun isValidSudoku(board: Array<CharArray>): Boolean {
    val horizontalArray = IntArray(9)
    val verticalArray = IntArray(9)
    val sqArray = IntArray(9)
    for (i in 0 until 9) {
        for (j in 0 until 9) {
            val char = board[i][j]
            if (char == '.') continue

            val num = char - '1'
            if (horizontalArray[i] shr num and 1 == 1) return false
            horizontalArray[i] = horizontalArray[i] or (1 shl num)

            if (verticalArray[j] shr num and 1 == 1) return false
            verticalArray[j] = verticalArray[j] or (1 shl num)

            val index=i / 3 + j / 3 * 3
            if (sqArray[index] shr num and 1 == 1) return false
            sqArray[index] = sqArray[index] or (1 shl num)
        }
    }
    return true
}
/////三个数组
//fun isValidSudoku(board: Array<CharArray>): Boolean {
//    val horizontalArray = Array(9) {BooleanArray(9) }
//    val verticalArray = Array(9) { BooleanArray(9) }
//    val sqArray = Array(9) { BooleanArray(9) }
//    for (i in 0 until 9) {
//        for (j in 0 until 9) {
//            val char = board[i][j]
//            if (char == '.') continue
//
//            val num = char - '1'
//            if (horizontalArray[i][num]) return false
//            horizontalArray[i][num] = true
//
//            if (verticalArray[j][num]) return false
//            verticalArray[j][num] = true
//
//            val index=i / 3 + j / 3 * 3
//            if (sqArray[index][num]) return false
//            sqArray[index][num] = true
//        }
//    }
//    return true
//}
//fun isValidSudoku(board: Array<CharArray>): Boolean {
//    val sqArray = IntArray(243)
//    for (i in 0 until 9) {
//        for (j in 0 until 9) {
//            val char = board[i][j]
//            if (char == '.') continue
//
//            val num = char - '1'
//            val index1 = i * 9 + num
//            if (sqArray[index1] == 1) return false
//            sqArray[index1] = 1
//
//            val index2 = 81 + j * 9 +num
//            if (sqArray[index2] == 1) return false
//            sqArray[index2] = 1
//
//            val index = 162 + (i / 3 + j / 3 * 3) * 9 + num
//            if (sqArray[index] == 1) return false
//            sqArray[index] = 1
//        }
//    }
//    return true
//}