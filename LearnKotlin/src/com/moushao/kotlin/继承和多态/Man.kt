package com.moushao.kotlin.继承和多态

import com.moushao.kotlin.Human

class Man(name: String) : Human(name) {
    override fun pee() {
        println("${name}站着撒尿")
    }

    override fun eat() {
        println("${name}在大口吃饭")
    }
}