package `class`.basic

import java.util.DoubleSummaryStatistics

/*

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
}

public fun myNothing(reason: String): Nothing = throw Exception("the reason of this exception is $reason")