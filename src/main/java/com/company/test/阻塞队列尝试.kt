package com.company.test

import java.util.*
import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.thread


val q = ArrayDeque<String>()
//申明锁
val lock: Lock = ReentrantLock()
//标识，可以表示具体的线程
val conditionNull: Condition = lock.newCondition()

fun takeQ() {
    lock.lockInterruptibly();
    try {
        while (q.none()) {
            conditionNull.await()
        }
        print("拿出了${q.first}")
    } catch (e: InterruptedException) {
        println("出现异常，唤醒阻塞线程conditionNull");
        conditionNull.signal();
        throw e
    }
    conditionNull.signal();
    lock.unlock()
}

fun addQ(e: String) {
    q.add(e)
}

fun main(args: Array<String>) {
    println("开始")
    thread {
        var s = 0
        repeat(100) {
            s++
            Thread.sleep(1000)
            println("${s}秒后")
        }

    }
    thread {
        takeQ()
    }
    thread {
        Thread.sleep(5000)
        println("插入")
        addQ("1")
        runCatching {
            conditionNull.signal()
        }
    }
}