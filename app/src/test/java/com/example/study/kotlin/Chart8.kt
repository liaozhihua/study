package com.example.study.kotlin

import com.example.study.kotlin.plate1.chat8.TextProcessorV1
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * <pre>
 *     author : liaozh
 *     e-mail : xxx@xx
 *     time   : 2022/09/05
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class Chart8 {
    @Test
    fun testProcessText() {
        val textProcessorV1 = TextProcessorV1()
        val processText =
            textProcessorV1.processText("Kotlin is my favorite language. I love Kotlin!")
        assertEquals(0,processText[0].frequency)
    }
}