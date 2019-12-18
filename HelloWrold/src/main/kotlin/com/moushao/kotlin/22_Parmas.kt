package com.moushao.kotlin

fun main(args: Array<String>) {
    println(square(2, 4))
    println(circleSquare(3.8))
    println(long(3, 8))
}

fun square(width: Int, long: Int): Int {
    return width * long
}

fun circleSquare(r: Double): Double {
    return r * r * 3.14
}

fun long(width: Int, long: Int): Int {
    return (width + long) * 2
}