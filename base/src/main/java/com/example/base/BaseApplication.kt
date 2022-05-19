package com.example.base

import android.app.Application
import com.github.moduth.blockcanary.BlockCanary

/**
 * <pre>
 *     author : liaozh
 *     e-mail : xxx@xx
 *     time   : 2022/04/11
 *     desc   :
 *     version: 1.0
 * </pre>
 */
class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        BlockCanary.install(this, AppBlockCanaryContext()).start()
    }

}