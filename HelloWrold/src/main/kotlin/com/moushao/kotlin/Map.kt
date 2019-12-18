package com.moushao.kotlin

import java.util.*


fun main(args: Array<String>) {
    var map = TreeMap<String, String>()
    map.put("好", "good ")
    map.put("学习", "study ")
    map.put("天", "day ")
    map.put("向上", "up ")

    print(map["好"])
    print(map["好"])
    print(map["学习"])
    print(",")
    print(map["天"])
    print(map["天"])
    print(map["向上"])
    println()
    println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -")

    map["好"] = "good "
    map["学习"] = "study "
    map["天"] = "day "
    map["向上"] = "up "
    print(map.get("好"))
    print(map.get("好"))
    print(map.get("学习"))
    print(",")
    print(map.get("天"))
    print(map.get("天"))
    print(map.get("向上"))

}