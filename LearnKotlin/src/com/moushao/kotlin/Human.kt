package com.moushao.kotlin

/**
 * 方法有抽象的,类必须是抽象的
 */
abstract class Human(var name: String) {
    abstract fun eat()
    abstract fun pee()
}