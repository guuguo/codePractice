package com.company.test

import kotlinx.coroutines.delay
import kotlin.coroutines.*


val sus = suspend {
    println("协程执行")
    delay(100)
    5
}
val continuation = sus.createCoroutine(object : Continuation<Int> {
    override val context: CoroutineContext
        get() = EmptyCoroutineContext

    override fun resumeWith(result: Result<Int>) {
        println("协程执行完成$result")
    }
})

fun <R, T> launchCoroutine(receiver: R,block:(suspend R.() -> T)) = block.startCoroutine(receiver,object : Continuation<T> {
    override val context: CoroutineContext
        get() = EmptyCoroutineContext

    override fun resumeWith(result: Result<T>) {
        println("协程执行完成$result")
    }
})

suspend fun main(args: Array<String>) {
    launchCoroutine("作用域"){
        println("协程执行launchCoroutine")
        delay(100)
        toString()
    }
}