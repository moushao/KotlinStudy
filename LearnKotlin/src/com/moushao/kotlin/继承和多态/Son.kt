package com.moushao.kotlin.继承和多态

/**
 * 知识点:
 * 1:父类必须返回构造对象,如Father()
 * 2:父类和父类中被继承的方法,必须是open 关键字申明
 */
class Son : Father (){

    override fun action() {
        println("受过高等教育的良好行为")
    }
}