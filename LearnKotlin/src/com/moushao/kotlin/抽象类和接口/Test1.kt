package com.moushao.kotlin.抽象类和接口

import com.moushao.kotlin.Human

fun main(args: Array<String>) {
    var man1 = Man()
    man1.xiaodidi()

    var man2 = Taijian()
    man2.eat()

    var house = listOf<Human>(man1,man2)
    for (p in house) {
        p.eat()
        if (p is Taijian) {
            println("我不能撒尿")
        }
    }
}