package com.example.base.net

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.base.R
import com.example.base.lifecycle.SampleLifecycle

/**
 * <pre>
 *     author : liaozh
 *     e-mail : xxx@xx
 *     time   : 2022/05/19
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        //绑定生命周期
        lifecycle.addObserver(SampleLifecycle())
    }
}