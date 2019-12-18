package com.moushao.kotlin

fun main(args: Array<String>) {
   // when1(args)
    when2(100)
}

fun when2(score: Int) {
    when(score) {
        10 -> println("满分")
        9 -> println("不错")
        8 -> println("还可以")
        7 -> println("努力吧孩子")
        6 -> println("及格")
        else -> println("还需要加油")
    }
}

private fun when1(args: Array<String>) {
    val x = 5
    when (x) {
        is Int -> print("Hello $x")
        in 1..100 -> println("$x is in 1..100")
        !in 1..100 -> println("$x is ont in 1..100")
        args[0].toInt() -> println("x == args[0]")
    }
    val model = when {
        args.isNotEmpty() && args[0] == "1" -> 1
        else -> 0
    }
}