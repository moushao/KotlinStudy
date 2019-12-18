package com.moushao.kotlin

class Girl(var charactor: String, var voice: String){
    fun smile() {
        println("妹子笑了,哈哈哈!")
    }

    fun cry() {
        println("呜呜呜,人家伤心了")
    }
}

fun main(args: Array<String>) {
    var girl = Girl("彪悍", "甜美")
    println("性格" + girl.charactor)
    println("声音" + girl.voice)
    girl.smile()
    girl.cry()
}
