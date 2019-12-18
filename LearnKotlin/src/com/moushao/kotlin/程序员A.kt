package com.moushao.kotlin

fun main(args: Array<String>) {
    var washMachine = WashMachine("小天鹅", 12)
    washMachine.openDoor()
    println("洗一条内裤")
    washMachine.closeDoor()
    washMachine.selectMode(1)
    washMachine.start()
}