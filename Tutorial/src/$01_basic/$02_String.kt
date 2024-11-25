package `$01_basic`

import java.util.*

const val hi = "String"

fun main() {
    /**
     * 1. 字符串具有不可变性，一旦被创建，则不能再修改
     * 如果对字符串进行拼接、替换等操作，会返回一个新的字符串
     */
    val sayHi = "Hello"
    val sayHi2Sage = "$sayHi Sage"
    println(sayHi)
    println(sayHi2Sage)
    println()
    /**
     * 对于频繁修改的字符串，使用StringBuilder可以提高性能
     */
    val sb = StringBuilder("Sage")
    println(sb)
    sb.append(" hello")
    println(sb)
    println()

    /**
     * 多行字符串，使用 trimMargin()格式化，去除多余的空格前缀
     */
    val multiLine = """
        hi 兄弟，
        你好吗
        最近
    """.trimIndent()
    println(multiLine)
}