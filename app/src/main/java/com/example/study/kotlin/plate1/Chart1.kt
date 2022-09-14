package com.example.study.kotlin.plate1

/**
 * <pre>
 * author : liaozh
 * e-mail : xxx@xx
 * time   : 2022/08/11
 * desc   : 1、基础语法
 * version: 1.0
</pre> *
 */
class Chart1 {
    //可变变量
    var  a = 45
    var  b = 1.4
    var c : Float = 1.4F
    var c1 = 1.4
    var d : Long = 45
    var d2 = 45
    var e : Int = 100
    //不可变变量
    val  f = "dddd"
    //
    val g = d.toDouble()
//    val i : Double = null 编译器报错
    val i : Double? = null
    //字符串
    private val s = "Hello Kotlin!"
    val name = "dd $s"
    //数组
    val array = arrayOf("ddd","eeee")
    //复杂的变量
    val name2 = "dd ${array[0]}"
    //原始字符串
    val s2 = """
       当我们的字符串有复杂的格式时
       原始字符串非常的方便
       因为它可以做到所见即所得。 """

    /*
    关键字    函数名          参数类型   返回值类型
     ↓        ↓                ↓       ↓      */
    fun helloFunction(name: String): String {
        return "Hello $name !"
    }/*   ↑
   花括号内为：函数体*/

    //单一表达式函数
    fun hello(name: String) : String = "Hello $name !"

    //多个命名参数
    fun createUser(
        name: String,
        age: Int,
        gender: Int,
        friendCount: Int,
        feedCount: Int,
        likeCount: Long,
        commentCount: Int
    ) {
        //..
    }

    //Kotlin 还支持参数默认值，这个特性在参数较多的情况下同样有很大的优势：
    fun createUser2(
        name: String,
        age: Int =0,
        gender: Int=0,
        friendCount: Int =0,
        feedCount: Int=0,
        likeCount: Long,
        commentCount: Int =0
    ) {
        //..
    }

    fun invoke() {
        Chart2.name
        createUser("Tom", 30, 1, 78, 2093, 10937, 3285)
        //可读性
        createUser(name = "tomm",age = 30,gender = 34,friendCount = 23,feedCount = 44,likeCount = 133,commentCount = 40)
        createUser2("dddd",likeCount = 30)
    }
    //if语句
    val m = 0
    val msg = if (m > 0) "Big" else "Small"
    //判空
    fun getLength(text : String?) : Int = text?.length ?: 0
    //when语句
    fun fff(value : Int) {
        when(value) {
            1 -> print(1)
            2 -> "ddddd"
            3 -> print(1)
            else -> print(4)
        }
    }
    //for循环
    fun for2() {
        val array = arrayOf(1, 2, 3)
        for (i in array) {
            println(i)
        }
        val one = 1..10
        for (i in one) {
            println(i)
        }
        //逆序迭代一个区间
        for (i in 100 downTo 2 step 2) {
            println(i)
        }
    }

}