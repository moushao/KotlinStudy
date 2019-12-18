package com.moushao.kotlin.委托和代理

class SmallHeadFather : IWashBowl by BigHeadSon {
    override fun washing() {
        println("小头爸爸洗碗,妈妈就给啪啪啪")
        println("爸爸不想啪啪啪,拿了10块钱让儿子洗碗")
        BigHeadSon.washing()
    }
}