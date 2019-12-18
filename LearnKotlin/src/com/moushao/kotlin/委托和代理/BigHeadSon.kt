package com.moushao.kotlin.委托和代理

object BigHeadSon : IWashBowl {
    override fun washing() {
        println("大头儿子洗碗,妈妈给十块钱")
    }
}