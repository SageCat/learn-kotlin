package `class`.basic

import java.util.StringJoiner

fun main() {
    // 调用单行函数体函数
    sayHi()
    println(">>>>>>>>>>>>>>>>>>>>>>>")
    doWork(
        age = 23,
        name = "sage"
    )
    println(">>>>>>>>>>>调用 vararg>>>>>>>>>>>>")
    personInfo(
        "sage",
        "beijing",
        "shanghai",
        "shenzhen"
    )
}

// 单行函数体的函数
fun sayHi() = println("hello")

fun doWork(age: Int, name: String) {
    println("my name is $name, and I'm $age years old!")
}

// 带有 vararg 类型的参数的函数, vararg 参数必须在函数的参数列表的最后一个
fun personInfo(name: String, vararg address: String) {
    println("my name is $name, and my address is $address")
    address.forEach { println(it) }
}