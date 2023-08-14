# Kotlin 中的类

## 1. 创建一个类
```kotlin
// 第一种写法： 形参
class User(firstName: String, lastName: String, isHappy: Boolean) {
    var firstName = firstName
    var lastName = lastName
    var isHappy = isHappy
}
// 第二种写法： 直接将属性写入到参数的位置
class User(var firstName: String, var lastName: String, var isHappy: Boolean)
```
上面代码，构造了一个带有主构造函数 `(var firstName: String, var lastName: String, var isHappy: Boolean)`的 `User` 类，并省略了 `constructor`关键字
也可以对构造函数的参数指定默认值，如 `(var firstName: String, var lastName: String, var isHappy: Boolean = false)`

## 2. 关于构造函数的种种
### a. 主构造函数
已在上述的`创建类`部分做出说明
> 一个类只有一个主构造函数，且必须在类名后声明，如果未声明主构造函数，则系统会为其默认分配一个不带任何参数的主构造函数
> `init {}`代码块会在主构造函数执行完毕后立即执行，且一个类中可以有多个 `init {}`代码块，会按照代码块的先后顺序依次执行
### b. 次构造函数
- 次构造函数需要在类体中声明，并且需要 直接或间接使用 `this`关键字 委托 主构造函数
- 一个类可以有多个次构造函数
#### 关于`委托`的解释

```kotlin
class User(var firstName: String, var lastName: String, var isHappy: Boolean) {
    // 第一个次构造函数， 必须通过 this 关键字调用 主构造函数，对未被调用到的参数必须设置默认值
    constructor(firstName: String, lastName: String) : this(firstName, lastName, false) {
        println("this is the secondary constructor")
    }

    // 第二个次构造函数, 调用 次构造函数 或 主构造函数 都可以，下面调用的是第一个次构造函数（间接委托），通过链式调用，最终会还是会调用主构造函数的
    constructor(firstName: String) : this(firstName, "Guo") {
        println("this is the third constructor")
    }
    // 第二个次构造函数, 调用 次构造函数 或 主构造函数 都可以，下面调用的是主构造函数（直接委托）
    constructor(firstName: String) : this(firstName, "Guo", false) {
        println("this is the third constructor")
    }
}
```

## 3. 单例
通过 `object` 关键字快速创建单例类，需要通过类名调用成员变量和方法，类名就是一个实例
```kotlin
object Car {
    var color = "unknown"

    fun printColor() {
        println("the color is $color")
    }
}
```

## 4. 伴生对象
    由于 kotlin 中没有 static 关键字，若想实现 类名.方法，则需要用到伴生对象，相当于一个静态内部类实例
> 一个类只能有一个伴生对象，因为伴生对象也是一种单例
> 
> `可对外公开的常量 和 方法`一般都定义在 伴生对象中，可以通过类名直接调用
> 
> `私有的常量 和 方法`一般都定义在 类体中，只在当前类中可见
```kotlin
class User(var firstName: String, var lastName: String, var isHappy: Boolean) {
    /**
     * 定义一个伴生对象，用来创建 User 对象
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
}
```

## 5. 内部类
- 静态内部类 (无法访问外部类的成员变量)
- 非静态内部类 (可以访问外部类的成员变量，需要用 inner 关键字修饰)

```kotlin
class Outer(var name: String) {
    /**
     * 可以通过 外部类名.内部类名 直接调用
     */
    class StaticInner {
        /**
         * 无法访问外部类的成员变量，下述代码会报错
        fun printName() {
            println("name is $name")
        }
        */
    }

    /**
     * 需要通过 外部类对象.内部类名 才能调用，比静态内部类多了一个 inner 关键字
     */
    inner class GeneralInner {
        /**
         * 可以访问外部类的成员变量
         */
        fun printName() {
            println("name is $name")
        }
    }
}
```

