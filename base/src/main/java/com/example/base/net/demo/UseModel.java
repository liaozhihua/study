package com.example.base.net.demo;

import com.example.base.net.RetrofitClient;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * <pre>
 *     author : liaozh
 *     e-mail : xxx@xx
 *     time   : 2022/09/15
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class UseModel {
    private void uploadFile() {
        PostApi postApi = RetrofitClient.INSTANCE.create(PostApi.class);
        RequestBody name = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), "lza");
        RequestBody age = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), "26");

        File file = new File("fileUrl"); //上传一个文件
        // 创建 RequestBody，用于封装构建RequestBody
        // RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpg"), file);
        MultipartBody.Part part = MultipartBody.Part.createFormData("file", "test.txt", requestFile);
        Call<ResponseBody> bodyCall = postApi.testFileUpload1(name, age, part);
        bodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }
}
