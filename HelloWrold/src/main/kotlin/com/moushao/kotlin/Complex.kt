package com.moushao.kotlin

class Complex (var real:Double,var imaginary:Double){
    operator fun plus(other:Complex):Complex{
        return Complex(real+other.real,imaginary+other.imaginary)
    }
}

fun main(args:Array<String>) {
    var c1 =Complex(1.00,2.00)
    var c2 =Complex(9.00,8.0)
    println(c1+c2)
    var c3 = c1+c2
    println(c3.real)
    println(c3.imaginary)
}