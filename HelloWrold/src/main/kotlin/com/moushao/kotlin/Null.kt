package com.moushao.kotlin

fun main(args: Array<String>) {
    println(heat("水"))
    println(heat(null))
}

fun heat(string: String?):String {
    return "热" + string
}