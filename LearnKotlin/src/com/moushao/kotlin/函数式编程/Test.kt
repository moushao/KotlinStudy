package com.moushao.kotlin.函数式编程


fun main(args: Array<String>) {
    var names = listOf<String>("tom", "dsfads", "hfdhdf")
    /**
     * ForEach 函数类型 参数为List的泛型,返回值为Unit,空值
     */
    names.forEach(print)

    names.forEach {
        /* a->   //a 这个参数,在forEach中有个默认值叫it
         println(a)*/
        println(it)
    }
}

var print = fun(name: String): Unit {
    println(name)
}