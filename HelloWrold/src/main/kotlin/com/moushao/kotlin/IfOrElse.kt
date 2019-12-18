package com.moushao.kotlin

fun main(args: Array<String>) {
    var str1 = "张三"
    var str2 = "张二"
    println(str1 == str2)
    var str3 = "abc"
    var str4 = "ABC"
    println(str3 == str4)
    println(str3.equals(str4, false))
    println(str3.equals(str4, true))
}

fun returnBig(age: Int, b: Int): Int {
    if (age > b) return age else return b

}