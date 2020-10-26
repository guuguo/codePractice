package com.company


/**
 * @author guuguo
 * On*/
fun isValidSudoku(board: Array<CharArray>): Boolean {
    val hashSet = hashSetOf<Char>()
    for (i in 0 until 9) {
        ///每一横
        hashSet.clear()
        board[i].forEach {
            if (it != '.') {
                if (hashSet.contains(it)) return false
                hashSet.add(it)
            }
        }

        hashSet.clear()
        val sX = i * 3 % 9
        val sY = i / 3 * 3
        for (j in 0 until 9) {
            val x = sX + j % 3
            val y = sY + j / 3
            board[y][x].let {
                if (it != '.') {
                    if (hashSet.contains(it)) return false
                    hashSet.add(it)
                }
            }
        }

        hashSet.clear()
        for (j in 0 until 9) {
            board[j][i].let {
                if (it != '.') {
                    if (hashSet.contains(it)) return false
                    hashSet.add(it)
                }
            }
        }
    }
    return true
}