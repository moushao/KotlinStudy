package com.moushao.kotlin.非诚勿扰


data class Girl(var name: String, var age: Int, var height: Int, var address: String)

var 非诚勿扰 = listOf<Girl>(
    Girl("恨桃", 20, 160, "河北省"),
    Girl("依秋", 30, 160, "山西省"),
    Girl("依波", 20, 170, "辽宁省"),
    Girl("香巧", 22, 160, "吉林省"),
    Girl("紫涵", 33, 180, "黑龙江"),
    Girl("忆之", 41, 160, "江苏省"),
    Girl("幻巧", 18, 160, "浙江省"),
    Girl("美倩", 20, 167, "安徽省"),
    Girl("安寒", 30, 166, "福建省"),
    Girl("白亦", 40, 160, "江西省"),
    Girl("惜玉", 10, 160, "山东省"),
    Girl("碧春", 31, 160, "台湾省"),
    Girl("怜雪", 20, 160, "河南省"),
    Girl("听南", 20, 160, "湖北省"),
    Girl("念蕾", 19, 160, "湖南省"),
    Girl("听南", 17, 160, "湖南省"),
    Girl("念蕾", 20, 160, "湖南省"),
    Girl("碧春", 42, 160, "湖南省"),
    Girl("凌寒", 31, 160, "湖南省"),
    Girl("凌旋", 22, 160, "湖南省"),
    Girl("紫夏", 20, 160, "广东省"),
    Girl("凌旋", 20, 160, "海南省"),
    Girl("芷梦", 20, 160, "四川省"),
    Girl("凌寒", 20, 160, "贵州省"),
    Girl("梦竹", 20, 160, "云南省"),
    Girl("千凡", 20, 160, "陕西省"),
    Girl("丹蓉", 20, 160, "甘肃省"),
    Girl("慧贞", 99, 160, "青海省")
)


infix fun List<Girl>.查找嫩妹子的年龄(age: Int) {
    filter {
        it.age < age
    }.forEach(::println)
}

infix fun List<Girl>.查找老妹子(age: Int) {
    filter {
        it.age > age
    }.forEach(::println)
}

infix fun List<Girl>.查找老妹子(address: String) {
    filter {
        it.address.equals(address)
    }.forEach(::println)
}

fun List<Girl>.查找老妹子(age: Int, address: String) {
    filter {
        it.address.equals(address) and (it.age > 17) and (it.age < 30)
    }.forEach(::println)
}













































