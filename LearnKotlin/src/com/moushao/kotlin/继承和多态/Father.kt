package com.moushao.kotlin.继承和多态

open class Father/*(var charactor: String, var action: String)*/ {

    var character = "性格内向"
    open fun action() {
        println("喜欢在公共场合大声说话")
    }
}