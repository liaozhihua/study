package com.example.study.kotlin.plate1.chat8

/**
 * <pre>
 *     author : liaozh
 *     e-mail : xxx@xx
 *     time   : 2022/09/05
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class char8<T> {
    fun turnOn(tv : T) {

    }

    fun turnOff(tv : T) {

    }

    fun main() {
        val char8 = char8<Car>()
        char8.turnOff()

    }

    inner class Car{

    }
}