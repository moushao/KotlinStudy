package com.moushao.kotlin.枚举

enum class Week {
    星期一,
    星期二,
    星期三,
    星期四,
    星期五,
    星期六,
    星期天

}

fun main(args: Array<String>) {
    //打出当前枚举位置
    println(Week.星期一.ordinal)
}