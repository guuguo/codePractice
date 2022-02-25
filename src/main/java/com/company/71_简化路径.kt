package com.company

import java.util.*


/**
 * @author guuguo
 * @see <a href="https://leetcode-cn.com/problems/simplify-path/">leetcode链接</a>*/
fun simplifyPath(path: String): String {
    val stack= Stack<String>()
    var currentStr=""
    path.forEach {
        if (it == '/') {
            when{
                currentStr ==".."->if(stack.isNotEmpty())stack.pop()
                currentStr =="."->{}
                currentStr.isNotEmpty()->stack.push(currentStr)
            }
            currentStr=""
        } else {
            currentStr+=it
        }
    }
    when{
        currentStr ==".."->if(stack.isNotEmpty())stack.pop()
        currentStr =="."->{}
        currentStr.isNotEmpty()->stack.push(currentStr)
    }

    val resStr=StringBuilder()
    while (stack.isNotEmpty()) {
        resStr.insert(0, stack.pop())
        resStr.insert(0, '/')
    }
    if (resStr.firstOrNull() != '/') {
        resStr.insert(0, '/')
    }
    return resStr.toString()
}