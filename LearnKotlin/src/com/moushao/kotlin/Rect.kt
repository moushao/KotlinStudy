package com.moushao.kotlin

class Rect(var height: Int, var width: Int)

fun main(args: Array<String>) {
    var rect = Rect(20, 10)
    println("矩形的高度是${rect.height}")
    println("矩形的高度是${rect.width}")
}
