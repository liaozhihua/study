package com.example.study

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.ref.PhantomReference
import java.lang.ref.ReferenceQueue

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.study", appContext.packageName)
        val referenceQueuee = ReferenceQueue<Any?>()
        var phantomObject: Any? = Any()
        val phantomReference: PhantomReference<*> = PhantomReference(phantomObject, referenceQueuee)
        phantomObject = null
        println("phantomObject:$phantomObject") //null

        println("phantomReference" + referenceQueuee.poll()) //null

        System.gc()
        try {
            Thread.sleep(20000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }
}