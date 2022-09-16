package com.example.base.net.demo

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

/**
 * <pre>
 *     author : liaozh
 *     e-mail : xxx@xx
 *     time   : 2022/09/15
 *     desc   : 网络请求使用 参考文章 https://juejin.cn/post/6844903876559110151
 *     version: 1.0
 * </pre>
 */
interface GetApi {

    @GET("getUser/Info")
    fun getUserInfo() : Call<BaseBean>

    @GET("getUser/Info")
    fun getUserInfo(@Query("userId") userId : String) : Call<BaseBean>

    @GET("getUser/Info")
    fun getUserInfo(@QueryMap param : Map<String,String>) : Call<BaseBean>

    @GET("api/getDynamicInfo/{path}/data")
    fun getDynamicInfo(@Path("path") pathAdress : String) : Call<BaseBean>

    //这里填入的是ResponseBody，当返回的具体数据不是我们知道的Bean类时可以用这个，这样，我们可以通过上述字符串的形式获取到返回的内容。
    @GET("api/getDynamicBody/{path}/data")
    fun getDynamicBody(@Path("path") pathAdress : String) : Call<ResponseBody>

    //当要访问的地址不只是动态的变几个参数，而是整个地址都要变化，甚至是基类地址也要变化时，这种动态地址就要用到@Url注解
    //虽然说最终访问的地址与原先的baseUrl无关，但是baseUrl还是要以http://或https://开头，并且后面至少要跟一个字母或者其他东西，不然就会报错
    @GET
    fun  getDynamicUrl(@Url url: String)


    //静态添加头部信息：包含添加单个头部、添加多个头部
    //通过@Headers("")注解，内部以key:value的方式填写内容
    @Headers("version : 1.1")//单个头
    @GET("api/staticHeaderInfo")
    fun getStaticHeadersInfo() : Call<GetBean>

    //静态添加多个头部
    @Headers("version:1.1", "type:android")
    @GET("api/staticHeadersInfo")
    fun getStaticMoreHeadersInfo() : Call<GetBean>

    //动态添加单个头部信息
    @GET("api/dynamicHeadersInfo")
    fun getDynamicHeaderInfo(@Header("version") version: String) : Call<ResponseBody>

    //动态添加多个头部信息
    @GET("api/dynamicHeadersInfo")
    fun getDynamicHeadersInfo(@HeaderMap headers: Map<String,String>)
}