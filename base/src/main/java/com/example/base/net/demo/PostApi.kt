package com.example.base.net.demo

import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*


/**
 * <pre>
 *     author : liaozh
 *     e-mail : xxx@xx
 *     time   : 2022/09/15
 *     desc   :
 *     version: 1.0
 * </pre>
 */
interface PostApi {
    //@Field 对应@Query @Field注解添加的参数是写在body中而不是直接拼接在Url后面
    //@FieldMap 对应@QueryMap
    //@Body 对应@Url

//    @FormUrlEncoded 用于修饰@Field注解和@FieldMap注解，将会自动将请求参数的类型调整为
//    application/x-www-form-urlencoded
    @FormUrlEncoded
    @POST("api/fieldMapParam")
    fun postFileFun(@Field("key") key : String) : Call<ResponseBody>

    @FormUrlEncoded
    @POST("api/fieldMapParam")
    fun postFileFun(@FieldMap key : Map<String,String>): Call<ResponseBody>


//    --------------------------------------------------------------------
    //以下是难点
    //@Body
    //可以看到@FieldMap注解适合多个相同类型参数的传递，如果多个不同类型传递的话，总不能写多个@Field吧
    //如果要更多种类型的话那就更繁琐了，所以这里我们可以用@Body注解，直接传入一个对象过去，对象内可包含多种类型数据
    //注意
    //使用@Body注解一定在创建Retrofit的时候加上.addConverterFactory(GsonConverterFactory.create()),目的是将对象转化为json字符串进行传递，
    // 否则会报以下错误 Unable to create @Body converter for class PostBodyBean
    //GET请求不能使用@Body注解
    @POST("api/fieldMapParam")
    fun postFileFun(@Body postBody : BaseBean) : Call<ResponseBody>

    //@Multipart 表示请求体是一个支持文件上传的Form表单
    //每个键值对需要用请求参数@Part来注解键名，随后的对象是需要提供值。
    // @Part后面支持三种类型，RequestBody、 okhttp3.MultipartBody.Part 、任意类型
    //         * 除okhttp3.MultipartBody.Part以外，其它类型都必须带上表单字段(okhttp3.MultipartBody.Part中已经包含了表单字段的信息)，
    @Multipart
    @POST("form")
    fun testFileUpload1(@Part("name") name : RequestBody,@Part("age") age : RequestBody,
    @Part file: MultipartBody.Part) : Call<ResponseBody>

    @Multipart
    @POST("form")
    fun postFile(@PartMap request : Map<String,RequestBody>) : Call<ResponseBody>

    //表示响应体的数据用流的方式返回，使用于返回数据比较大，该注解在下载大文件时特别有用 我们在使用下载比较大的文件的时候需要添加@Streaming注解
    @Streaming
    @GET("/update_apk")
    fun downloadFile(@Url fileUrl: String?): Call<ResponseBody?>?

}