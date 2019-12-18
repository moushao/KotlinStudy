package com.moushao.kotlin

fun main(args: Array<String>) {
    println("请输入一个数字")
    var num1 = readLine()?.toInt()
    println("请输入第二个数字")
    var num2 = readLine()?.toInt()

    println("${num1}+$num2=${num1!! + num2!!}")

}