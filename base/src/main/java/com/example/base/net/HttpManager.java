package com.example.base.net;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * <pre>
 *     author : liaozh
 *     e-mail : xxx@xx
 *     time   : 2022/04/20
 *     desc   :支持HTTP/2，允许所有同一个主机地址的请求共享同一个socket连接
 *             使用连接池减少请求延时
 *             透明的GZIP压缩减少响应数据的大小
 *             缓存响应内容，避免一些完全重复的请求
 *     version: 1.0
 * </pre>
 */
public class HttpManager {

    private OkHttpClient httpClient;
    private Request.Builder builder;
    private static HttpManager httpManager;

    private HttpManager() {
        initHttpClient();
    }

    private void initHttpClient() {
        httpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
//                .cache(new Cache())
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        String url = request.url().toString();
                        Response response = chain.proceed(request);
                        ResponseBody body = response.body();
                        return response;
                    }
                })
                .build();
        builder = new Request.Builder();
    }

    public static HttpManager getInstance() {
        if (httpManager == null) {
            synchronized (HttpManager.class) {
                if (httpManager == null) {
                    httpManager = new HttpManager();
                }
            }
        }
        return httpManager;
    }

    public void execute(String url) {
        Call call = httpClient.newCall(builder.url(url).get().build());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response execute = call.execute();
                    Log.i(TAG, "okHttpGet execute: onResponse:" + execute.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void enqueue(String url) {
        Call call = httpClient.newCall(builder.url(url).get().build());
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //在子线程中
                Log.i(TAG, "okHttpGet enqueue: onResponse:" + response.body().string());
                ResponseBody body = response.body();
                String string = body.string();
                byte[] bytes = body.bytes();
                InputStream inputStream = body.byteStream();
            }
        });
    }

    public void postAsync() {
        MediaType parse = MediaType.parse("text/x-markdown;charset=utf-8");
        RequestBody body = RequestBody.create(parse, "hello");

        MediaType parse1 = MediaType.parse("application/json; charset=utf-8");
        RequestBody body1 = RequestBody.create(parse1, "jsonString");

        File file = new File(Environment.getExternalStorageDirectory(), "1.png");
        RequestBody.create(MediaType.parse("image/png"),file);

        Request request = builder.url("https://api.github.com/markdown/raw").post(body).build();
        Call call = httpClient.newCall(request);
        inn.Companion.mehtod();
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }

    public void postForm(String url) {
        FormBody formBody = new FormBody.Builder().add("username", "hfy").add("password", "qaz").build();
        Request request = builder.post(formBody).url(url).build();
        Call call = httpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }

    public void postMultipart(String url) {
        MultipartBody multipartBody = new MultipartBody.Builder().setType(MultipartBody.FORM).addFormDataPart("username", "hufeiyang").build();
        httpClient.newCall(builder.post(multipartBody).url(url).build()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }
}
