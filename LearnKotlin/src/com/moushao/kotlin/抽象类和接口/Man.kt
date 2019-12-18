package com.moushao.kotlin.抽象类和接口

import com.moushao.kotlin.Human

class Man : Human(""), IMan {
    override fun pee() {
    }

    override fun eat() {
    }

    override fun xiaodidi() {
        println("18cm是我的")
    }

}