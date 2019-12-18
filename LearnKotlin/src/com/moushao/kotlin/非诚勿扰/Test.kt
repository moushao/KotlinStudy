package com.moushao.kotlin.非诚勿扰

import com.moushao.kotlin.非诚勿扰.Girl

fun main(args: Array<String>) {
    filterGirl("", 1)
}

fun filterGirl(address: String, height: Int) {
    println(非诚勿扰.minBy { it.age })
    println()

    println(非诚勿扰.filter {
        (it.age > 18) and (it.age < 25)
    })

    println(listToMap())

    //判断年龄是否有25岁的
    println(非诚勿扰.any {
        it.age == 17
    })

    //计算年龄等于20的人的数量
    println(非诚勿扰.count {
        it.age == 20
    })

    //分组
    println(非诚勿扰.groupBy {
        it.address
    }.containsKey("甘肃省"))

    非诚勿扰 查找嫩妹子的年龄 20
    println()
    非诚勿扰 查找老妹子 50
    println()
    非诚勿扰 查找老妹子 "河南省"
    println()
    非诚勿扰.查找老妹子(18, "湖南省")
}

//遍历转换
fun listToMap(): List<String> {
    return 非诚勿扰.map {
        "${it.name}: ${it.age}"
    }
}
