package com.company

fun (() -> Unit).checkTime() {
    Runnable {
        val startTime = System.currentTimeMillis()
        println("--------开始时间:$startTime")
        this()
        val endTime = System.currentTimeMillis()
        println("--------结束时间:$endTime")
        println("--------耗时:${endTime - startTime}毫秒--------")
    }.run()
}

fun <T> T.checkTime(block: () -> Unit) {
    Runnable {
        val startTime = System.currentTimeMillis()
        println("--------开始时间:$startTime")
        block()
        val endTime = System.currentTimeMillis()
        println("--------结束时间:$endTime")
        println("--------耗时:${endTime - startTime}毫秒--------")
    }.run()
}