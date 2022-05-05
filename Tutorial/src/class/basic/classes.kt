package `class`.basic

fun main() {
    var user = User(firstName = "Sage", lastName = "Guo")
    user.phoneNum = "123455"
    println(user)
    println(user::class)

//    user.firstName = "Sage"
//    user.lastName = "Guo"

    user.printName()
    user.updateName("SageCat")
    user.printName()
    user.firstNameLength()

    println(">>>>>>>>>>>>>>>>>")
    var userSister = User("Lily")
    userSister.printName()
    userSister.firstNameLength()
    println(userSister.fullName)
    userSister.fullName = "sss"
    println(userSister.fullName)

    println(">>>>>>>>>半生对象>>>>>>>>")
    /**
     * 可以通过类名调用半生对象中的方法，相当于 Java 的 static 方法
     */
    val userTom = User.createUser("Tom", "Liu")
    userTom.printName()
    userTom.isHappy = true
    userTom.printName()
    println()
    // 创建多个对象
    val usersList = User.creatUsers(5)
    println(usersList)
    usersList.forEach { println(it) }

    println("the MAX_AGE is ${User.MAX_AGE}")
    userTom.test()

    println(">>>>>>>>>单例>>>>>>>>")
    Car.printColor()
    Car.color = "Red"
    Car.printColor()
}

/** 带 primary constructor 的类，
 *若对其中某些参数给定默认值，则创建对象时，不必显式地填入值，可以省去创建 secondary constructor 的麻烦
 */
class User(var firstName: String, var lastName: String, var isHappy: Boolean) {
    lateinit var phoneNum: String
    //    var firstName = ""
//    var lastName = ""
    /**
     * 重写 成员变量的 set 和 get 方法
     */
    var fullName = "$firstName $lastName"
        get() = "Full Name is : $field"
        set(value) {
            if (value.length === 3) {
                field = "Sage Guo"
            }
        }

    /**
     * init 代码块中的语句在调用 primary constructor 后会立即执行， 可以有多个 init 代码块，会按照代码的顺序来执行
     */
    init {
        println("this is the primary constructor")
        println("this is the information of $fullName")
    }

    // secondary constructor 必须调用 primary constructor，对未被调用到的参数必须设置默认值
    constructor(firstName: String, lastName: String) : this(firstName, lastName, false) {
        println("this is the secondary constructor")
    }

    // third constructor, 调用 secondary constructor 或 primary constructor 都可以
    constructor(firstName: String) : this(firstName, "Guo") {
        println("this is the third constructor")
    }

    fun printName() {
        println("$firstName $lastName, happy?: $isHappy")
    }

    fun updateName(newName: String) {
        firstName = newName
    }

    fun firstNameLength() {
        println("firstName length is ${firstName.length}")
    }

    override fun toString(): String {
        return "$firstName - $lastName, the phone number is $phoneNum"
    }

    /**
     * 仅在当前类中共享的常量采用下面的方法来定义
     */
    private val MAX_GRADE = 100

    /**
     * 定义一个半生对象，用来创建 User 对象
     */
    companion object {
        /**
         * 类中 =对外公开的常量= 最好定义在 半生对象 中 （调用者可以通过类名直接获得）
         */
        const val MAX_AGE = 18
        const val MIN_AGE = 5

        /**
         * 创建一个对象
         */
        fun createUser(firstName: String, lastName: String): User {
            return User(firstName, lastName)
        }

        private val users = mutableListOf<User>()

        /**
         * 创建对个对象
         */
        fun creatUsers(number: Int): List<User> {
            for (i in 1..number) {
                users.add(User("firstname $i", "lastname $i"))
            }
            return users
        }
    }

    fun test() {
        println(MAX_AGE)
    }
}

/**
 * 使用 object 关键字可以实现单例
 */
object Car {
    var color = "unknown"

    fun printColor() {
        println("the color is $color")
    }
}