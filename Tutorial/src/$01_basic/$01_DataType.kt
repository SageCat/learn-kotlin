package `$01_basic`

fun main() {
    printBasicDataType()

    printStringDataType()

    printCollectionDataType()

    printOtherDataType()
}


fun printBasicDataType() {
    println("${"=".repeat(20)} Basic Data Type ${"=".repeat(20)}")
    println("Byte: ${Byte.MIN_VALUE} to ${Byte.MAX_VALUE}")
    println("Short: ${Short.MIN_VALUE} to ${Short.MAX_VALUE}")
    println("Int: ${Int.MIN_VALUE} to ${Int.MAX_VALUE}")
    println("Long: ${Long.MIN_VALUE} to ${Long.MAX_VALUE}")
    println("Float: ${Float.MIN_VALUE} to ${Float.MAX_VALUE}")
    println("Double: ${Double.MIN_VALUE} to ${Double.MAX_VALUE}")
    println("Char: Example -> ${'A'}")
    println("Boolean: Example -> ${true}")
    println()
}


fun printStringDataType() {
    println("${"=".repeat(20)} String Data Type ${"=".repeat(20)}")
    println("String: Example -> ${"Hello, Kotlin!"}")
    println()
}


fun printCollectionDataType() {
    println("${"=".repeat(20)} Collection Data Type ${"=".repeat(20)}")
    println("List: Example -> ${listOf(1, 2, 3)}")
    println("Set: Example -> ${setOf(1, 2, 3)}")
    println("Map: Example -> ${mapOf(1 to "One", 2 to "Two")}")
    println()
}


fun printOtherDataType() {
    println("${"=".repeat(20)} Other Data Type ${"=".repeat(20)}")
    println("Any: Example -> ${42 as Any}")
    println("Unit: Example -> ${Unit}")
    println("Nothing: This type cannot have a value (used for exceptions).")
    println()
}