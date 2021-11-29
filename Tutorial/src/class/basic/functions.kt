package `class`.basic

fun main() {
    val strLength = "HebeiHubeiShanghai".count()

    /*
    匿名函数
     */
    val specialCharLength = "HebeiHubeiShanghai".count { it == 'h' }

    println(strLength)
    println(specialCharLength)

    /*
    无参的匿名函数
     */
    val myFunction: () -> Int = { 3 * 4 }
    println(myFunction.invoke())

    /*
    有大于一个参数的匿名函数
     */
    val myFunctionTwo: (Int, Int) -> Int = { a, b -> a * b }
    /*
    也可以省去类型的声明
     */
    val myFunctionTwoOther = { a: Int, b: Int -> a * b }

    // 当匿名函数只有一个参数时，可以使用 it 关键字代替参数的名字
    val mySquare: (Int) -> Int = { it * it }
    val mySquareOther = { it: Int -> it * it }

    println(myFunctionTwo.invoke(5, 10))
    println(myFunctionTwoOther.invoke(5, 10))
    println("3 square is ${mySquare.invoke(3)}")
    println("3 square is ${mySquareOther.invoke(3)}")
}