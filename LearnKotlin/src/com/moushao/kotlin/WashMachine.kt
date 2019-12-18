package com.moushao.kotlin

class WashMachine(var name: String, var size: Int) {
    var currentMode = 0
    var isDoorOpen = true
    fun openDoor() {
        isDoorOpen = true
        println("打开门")
    }

    fun closeDoor() {
        isDoorOpen = false
        println("关门")
    }

    fun start() {
        if (!isDoorOpen) {
            when (currentMode) {
                0 -> {
                    println("初始模式")
                    println("选择洗衣模式,否则不能洗衣服")
                }
                1 -> {
                    println("轻柔,放水洗衣服")
                    setMotorSpeed(300)
                    println("洗完了")
                }
                2 -> {
                    println("狂躁,放水洗衣服")
                    setMotorSpeed(1000)
                    println("洗完了")
                }
                else -> println("位置模式不能识别")
            }
        } else {
            println("请先关好门")
        }
    }

    private fun startWash() {
        println("通电")
        println("防水")
        println("洗衣")
        println("洗好了...")
    }

    fun selectMode(mode: Int) {
        currentMode = mode
        when (mode) {
            0 -> println("初始模式,请你选择模式")
            1 -> println("轻柔")
            2 -> println("狂砸")
            else -> println("不要乱来,坏了不保修的")
        }
    }

    private fun setMotorSpeed(speed: Int) {
        println("当前转速${speed}圈/分钟")
    }
}