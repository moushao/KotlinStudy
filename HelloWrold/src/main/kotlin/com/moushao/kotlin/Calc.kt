package com.moushao.kotlin


fun main(args: Array<String>) {
    println("请输入算式,例如:3+4")
    val a = readLine()
    if (a != null) {
        val splits = a.split(" ")
        val lef = splits[0].toDouble()
        val op = splits[1].toString()
        val right = splits[2].toDouble()
        var ops = Operator(op)
        println(ops.apply(lef, right))
    }

}

class Operator(op: String) {
    val opFun: (left: Double, right: Double) -> Double

    init {
        opFun = when (op) {
            "+" -> { l, r -> l + r }
            "-" -> { l, r -> l - r }
            "*" -> { l, r -> l * r }
            "/" -> { l, r -> l / r }
            "%" -> { l, r -> l % r }
            else -> {
                throw UnsupportedOperationException(op)
            }
        }
    }

    fun apply(left: Double, right: Double): Double {
        return opFun(left, right)
    }
}