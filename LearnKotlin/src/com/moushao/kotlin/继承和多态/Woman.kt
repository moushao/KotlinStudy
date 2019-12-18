package com.moushao.kotlin.继承和多态

import com.moushao.kotlin.Human

class Woman(name: String) : Human(name) {
    override fun pee() {
        println("${name}蹲着撒尿")
    }

    override fun eat() {
        println("${name}在小口吃饭")
    }
}