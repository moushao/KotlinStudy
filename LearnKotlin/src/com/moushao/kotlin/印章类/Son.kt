package com.moushao.kotlin.印章类

/**
 * 印章类也叫密封类
 * 关键字sealed 印章
 */
sealed class Son {
    fun sayHello() {
        println("hello")
    }

    class 小小驴() : Son()
    class 小骡子() : Son()
}