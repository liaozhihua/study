package com.example.study.kotlin.plate1

/**
 * <pre>
 *     author : liaozh
 *     e-mail : xxx@xx
 *     time   : 2022/09/02
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class Chart2 {
    var age :Int = 0

    //几种自定义get方法

    //写法1
    fun isAdult() : Boolean {
        return age>18
    }
    //写法2
    fun isAdult2() = age>18
    //写法3
    val isAdult3
    get() = age>18
    //写法4
    val isAdult4:Boolean
    get() {
        return age>18
    }
    //setter方法
    var isAdult5 =false
        set(value) {
          age>18
          field = value
      }

    //抽象类与继承
    //注意：如果一个类不是抽象类，并且没有用 open 修饰的话，它是无法被继承的。
    //所以，Kotlin 的类，默认是不允许继承的，除非这个类明确被 open 关键字修饰了。另外，对于被 open 修饰的普通类，它内部的方法和属性，默认也是不允许重写的，除非它们也被 open 修饰了：
    abstract class Person(var name:String) {
        abstract fun walk()
    }
    class PersonImpl(name: String) : Person(name) {
        override fun walk() {
        }

    }

    //接口的方法 Kotlin 的接口，跟 Java 最大的差异就在于，接口的方法可以有默认实现，同时，它也可以有属性
    interface Behavior {
        // 接口内的可以有属性
       val canWalk: Boolean
       fun walk() {
           if (canWalk) {

           }
       }
    }
    class Person2 : Behavior {
        override val canWalk: Boolean
            get() = true

    }
    //嵌套
    //Kotlin 当中的普通嵌套类，它的本质是静态的。相应地，如果想在 Kotlin 当中定义一个普通的内部类，我们需要在嵌套类的前面加上 inner 关键字。class A { val name: String = "" fun foo() = 1// 增加了一个关键字// ↓ inner class B { val a = name // 通过 val b = foo() // 通过 }}
    companion object {
        val name: String = ""
        fun foowwww() = 1
        // 增加了一个关键字
//    ↓
//       inner class B {
//            val a = name   // 通过
//            val b = foo()  // 通过
//        }
    }
    //数据类
    data class Per(val value: Boolean, val name: String){

    }
    //密封类 密封类，是更强大的枚举类
    enum class Human {
        MAN,WOMAN
    }//
    //这个密封类，我们是专门用于封装网络请求结果的。可以看到，在 Result 类当中，分别有三个数据类，分别是 Success、Error、Loading
    sealed class Result<out R> {
        data class Success<out T>(val data: T, val message: String = "") : Result<T>()

        data class Error(val exception: Exception) : Result<Nothing>()

        data class Loading(val time: Long = System.currentTimeMillis()) : Result<Nothing>()
    }
    object ddd {
        fun d() {}
    }

}