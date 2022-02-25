package com.company


/**
 * @author guuguo
 * @see <a href="https://leetcode-cn.com/problems/set-matrix-zeroes/">leetcode链接</a>*/
//fun setZeroes(matrix: Array<IntArray>): Unit {
//    val column = IntArray(7)
//    val row = IntArray(7)
//    fun setX(x: Int, array: IntArray) {
//        (x / 32).let { array[it] = array[it] or (1 shl x % 32) }
//    }
//    fun checkX(x: Int, array: IntArray)= (x / 32).let { array[it] and (1 shl x % 32)!=0 }
//    for (i in matrix.indices) {
//        for (j in matrix[0].indices) {
//            if (matrix[i][j] == 0) {
//                setX(i,row)
//                setX(j,column)
//            }
//        }
//    }
//    for (i in matrix.indices) {
//        for (j in matrix[0].indices) {
//            if (checkX(i, row) || checkX(j, column)) {
//                matrix[i][j] = 0
//            }
//        }
//    }
//}
fun setZeroes(matrix: Array<IntArray>): Unit {
    var row = -1
    var col = -1
    for (i in matrix.indices) {
        for (j in matrix[0].indices) {
            if (matrix[i][j] == 0) {
                if(row==-1) {
                    row = i
                    col = j
                }
                matrix[row][j]=0
                matrix[i][col]=0
            }
        }
    }
    if(row==-1){
        return
    }
    for (i in matrix.indices) {
        for (j in matrix[0].indices) {
            if(row==i||col==j){
                continue
            }
            if (matrix[row][j]==0 || matrix[i][col]==0) {
                matrix[i][j] = 0
            }
        }
    }
    for(i in matrix[0].indices){
        matrix[row][i]=0
    }
    for(i in matrix.indices){
        matrix[i][col]=0
    }
}