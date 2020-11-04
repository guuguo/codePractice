package com.company


/**
 * @author guuguo
 * On*/
fun solveSudoku(board: Array<CharArray>): Unit {
    for (i in 0 until 9) {
        for (j in 0 until 9) {
            val char = board[i][j]
            if (char == '.') continue
            val num = char - '1'

            horizontalArray[i][num] = true
            verticalArray[j][num] = true
            sqArray[i / 3 + j / 3 * 3][num] = true
        }
    }
    solveSudokuValid(board, 0, 0)
}

val horizontalArray = Array(9) { BooleanArray(9) }
val verticalArray = Array(9) { BooleanArray(9) }
val sqArray = Array(9) { BooleanArray(9) }

fun solveSudokuValid(board: Array<CharArray>, i: Int, j: Int): Boolean {
    val char = board[i][j]
    val sqIndex = i / 3 + j / 3 * 3
    if (char != '.') {
        val nextI: Int
        val nextJ: Int
        if (j + 1 >= 9) {
            nextI = i + 1
            nextJ = 0
        } else {
            nextI = i
            nextJ = j + 1
        }
        val num = char - '1'
        if (nextI >= 9) return true
        return solveSudokuValid(board, nextI, nextJ)
    }

    for (checkNum in 0 until 9) {
        if (horizontalArray[i][checkNum]) continue

        if (verticalArray[j][checkNum]) continue

        if (sqArray[i / 3 + j / 3 * 3][checkNum]) continue

        board[i][j] = '1' + checkNum

        val nextI: Int
        val nextJ: Int
        if (j + 1 >= 9) {
            nextI = i + 1
            nextJ = 0
        } else {
            nextI = i
            nextJ = j + 1
        }
        horizontalArray[i][checkNum] = true
        verticalArray[j][checkNum] = true
        sqArray[sqIndex][checkNum] = true

        if (nextI >= 9) return true
        if (solveSudokuValid(board, nextI, nextJ)) {
            return true
        } else {
            horizontalArray[i][checkNum] = false
            verticalArray[j][checkNum] = false
            sqArray[sqIndex][checkNum] = false
        }
    }
    board[i][j] = '.'
    return false
}