package com.moushao.kotlin

fun main(args: Array<String>) {
    println(add(3, 8))

    var i={a:Int,s:Int->a+s}
    println(i(4,89))
}

//fun add(a: Int, b: Int): Int {
//    return a + b
//}
/**
 * 如果函数里只有一行代码,且就是返回值,所以可以直接将结果
 * 赋值到函数申明体
 */
fun add(a: Int, b: Int):Int = a+b

