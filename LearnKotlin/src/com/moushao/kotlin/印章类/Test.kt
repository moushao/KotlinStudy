package com.moushao.kotlin.印章类

fun main(args: Array<String>) {
    var son1 = Son.小小驴()
    var son3 = Son.小小驴()
    var son2 = Son.小骡子()
    son1.sayHello()

    var list = listOf<Son>(son1, son2, son3)
    for (son in list) {
        if (son is Son.小骡子) {
            println("我是小骡子")
        } else {
            println("我是小驴子")
        }
    }
}