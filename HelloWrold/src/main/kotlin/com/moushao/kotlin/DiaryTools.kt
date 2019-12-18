package com.moushao.kotlin

fun diaryGenerator(placeName: String): String {
    var temple = """
        今天天气晴朗,万里无云,我们去${placeName}游玩,
        首先映入眼帘的是,${placeName} ${numToChinese(placeName.length)}个鎏金大字
    """
    return temple
}

fun numToChinese(num: Int): String {
    return when (num) {
        1 -> "一"
        2 -> "二"
        3 -> "三"
        4 -> "四"
        5 -> "五"
        else -> "名字太长了"
    }
}

fun main(args: Array<String>) {
    var diary = diaryGenerator("中山感觉公园")
    println(diary)
}