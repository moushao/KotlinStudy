package com.moushao.kotlin.继承和多态

import com.moushao.kotlin.Human

fun main(args: Array<String>) {
    var person1 = Man("金三胖")
    var person4 = Man("贝克汉姆")
    person1.eat()
    person1.pee()
    var person2 = Woman("武则天")
    person2.eat()
    person2.pee()
    var person3 = Woman("维多利亚")

    var humanList = listOf<Human>(person1, person2, person3, person4)
    for (a in humanList) {
        a.pee()
    }
}