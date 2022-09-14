package com.example.study.kotlin.plate1

import android.view.View

/**
 * <pre>
 *     author : liaozh
 *     e-mail : xxx@xx
 *     time   : 2022/09/05
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class Chart7 {
    private var image :View? = null
    fun set(image :View) {
        image.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {

            }

        })
        image.setOnClickListener(View.OnClickListener {
            v: View?-> set()
        })
        image.setOnClickListener({
            v: View? -> set()
        })
        image.setOnClickListener { set() }
    }
}