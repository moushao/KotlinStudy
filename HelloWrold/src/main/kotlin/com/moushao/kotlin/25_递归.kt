package com.moushao.kotlin

import java.math.BigInteger


fun main(args: Array<String>) {
    println(fact(BigInteger("70")))
    //递归算法优化
    println(ollAdd(100000, result = 0))
}

fun fact(num: BigInteger): BigInteger {
    if (num == BigInteger.ONE) {
        return BigInteger.ONE
    } else {
        return num * fact(num - BigInteger.ONE)
    }
}

//伪递归优化
tailrec fun ollAdd(num: Int, result: Int): Int {
    println("第${num}次计算")
    if (num == 0) {
        return 1
    } else {
        return ollAdd(num - 1, result + num)
    }
}