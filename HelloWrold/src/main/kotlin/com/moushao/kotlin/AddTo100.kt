package com.moushao.kotlin

fun main(args: Array<String>) {
    var num = (1..10)
    num.forEach(::print)
    println()
    println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -")
    var num2 = 1 until 10
    num2.forEach(::print)
    println()
    println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -")
    //num2.reversed().forEach(::println)
    for (a in num2 step 2) {
        print(("${a} "))
    }
}
