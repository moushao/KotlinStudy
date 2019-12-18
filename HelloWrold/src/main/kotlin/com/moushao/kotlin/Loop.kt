package com.moushao.kotlin

fun main(args: Array<String>) {
//    for (arg in args) {
//        println(arg)
//    }
//    for ((index, value) in args.withIndex()) {
//        println("$index position value is ${args[index]}")
//        println("$index-> $value")
//    }

    for (s in args.withIndex()) {
        println("${s.index} position value is ${s.value}")
    }

    args.forEach(::println)

}