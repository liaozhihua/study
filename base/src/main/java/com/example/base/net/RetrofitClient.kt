package com.example.base.net

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.InvocationHandler
import java.lang.reflect.Method
import java.lang.reflect.Proxy
import java.util.*

/**
 * <pre>
 *     author : liaozh
 *     e-mail : xxx@xx
 *     time   : 2022/09/15
 *     desc   :
 *     version: 1.0
 * </pre>
 */
object RetrofitClient {
    private const val BASE_URL : String = "http://mock-api.com/2vKVbXK8.mock/"
    private var retrofit : Retrofit? = null

    private fun init() {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }

    fun <T>  create(service : Class<T>) : T {
        init()
       return retrofit!!.create(service)
    }

    fun ProxyInstance2(service : Class<Objects>) {
        Proxy.newProxyInstance(service.classLoader,[service],object : InvocationHandler {
            override fun invoke(proxy: Any?, method: Method?, args: Array<out Any>?): Any {

            }

        })
    }
}