package `class`.basic

import java.util.StringJoiner

/*
介绍Kotlin最最基本的语法，包括变量，常量，数据类型等
 */

fun main() {
    val name = "sage"
    println(name::class)
    println("==================")

//    数据类型汇总
    val myByte: Byte = 8  // 8 bits signed integer
    val myShort: Short = 16  // 16 bits signed integer
    val myInt: Int = 32  // 32 bits signed integer
    val myLong: Long = 64  // 64 bits signed integer

    println(myByte::class)
    println(myByte::class)
    println(myShort::class)
    println(myInt::class)
    println(myLong::class)

    val myFloat: Float = 32.2F
    val myDouble: Double = 45.3
    println(myFloat::class)
    println(myDouble::class)

    println("==================")

    val myName: String = "Sage Guo"
    val myFirstName = "Sage"
    val myLastName = "Guo"
    // Char 类型的值必须使用单引号括起来，双引号会报错
    val c: Char = 'G'
    println(myName::class)
    println(c::class)
    // trimIndent() 去除空格，制表符，换行符等等
    val message = """
        Hello,
        Sage,
        How are you?
    """.trimIndent()
    println(message)

    println("=========流程控制语句=========")
    val age = 10
    if (age < 0) println("illegal age")
    // age ∈ (60, ...)
    else if (age > 60) println("you are an old man")
    // age ∈ (30, 60]
    else if (age > 30) println("you are an young man")
    // age ∈ (18, 30]
    else if (age > 18) println("you are just an adult")
    // age ∈ (12, 18]
    else if (age > 12) println("you are young")
    // age ∈ [0, 12]
    else println("you are a child")

    println("=========对象比较=========")
    val a = 10
    val b = 10
    // true
    println(a === b)
    val nameA = "sage"
    val nameB = "sage"
    // true， 字符串常量池
    println(nameA === nameB)

    val personA = Person("sage")
    val personB = Person("sage")
    // false, 属于2个不同的对象
    println(personA === personB)

    println("=========空安全特性=========")
    var nameC: String? = "sage"
    nameC = null
    println("nameC is $nameC")

    var nameD = "John"
    println("the length of nameD is ${nameD.length}")
    // 当变量为可空类型时，使用变量时要做检验
    var nameE: String? = "Jack Li"
    // 为可控变量赋值为 null
    if (true) nameE = null
    // 检验方法一： 在变量名后面增加 ? 号， 当变量为空时， 返回结果为 null， 当变量不为空时，返回变量所指向的字符串长度
    println("方法一： the length of nameE is ${nameE?.length}")
    // 检验方法二： 直接增加非空判断，只有变量所指对象不为空时，才执行接下来的命令
    if (nameE != null) {
        println("方法二： the length of nameE is ${nameE.length}")
    }
    // 方法二也可以这样写 (推荐)
    if (nameE != null) println("方法二： the length of nameE is ${nameE.length}") else println("方法二： the length of nameE is 0")
    // 检验方法三： 增加非空断言，当变量所指的对象为空时，会抛出 NullPointerException 空指针异常
    println("方法三： the length of nameE is ${nameE!!.length}")

}


class Person(var name: String)

public fun myNothing(reason: String): Nothing = throw Exception("the reason of this exception is $reason")