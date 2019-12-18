package com.moushao.kotlin

fun main(args: Array<String>) {
    var list = listOf("鸡蛋","杜蕾斯","酱油","冰淇淋")
    for ((i,e) in list.withIndex()) {
        println("第${i+1}件事情是买$e")
    }
}