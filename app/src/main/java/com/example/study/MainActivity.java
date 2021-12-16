package com.example.study;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.study.entity.User;
import com.example.study.model.UserModel;
import com.example.study.rxjava.RxjavaExample;


public class MainActivity extends AppCompatActivity {
    private boolean flag;
    private UserModel userModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RxjavaExample.normal();
        Intent intent = new Intent();
//        intent.setAction("dddddddddddddddddddd");
//        startActivity(intent);
        //1、不通过ViewModel方式
//        MutableLiveData mutableLiveData = new MutableLiveData<String>();
//        mutableLiveData.observe(this, new Observer() {
//            @Override
//            public void onChanged(Object o) {
//
//            }
//        });
//        mutableLiveData.setValue("sss");
        //2 通过ViewModel
//        ViewModelProvider of = ViewModelProviders.of(this);
//        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
//        userModel = viewModelProvider.get(UserModel.class);
//         mutableLiveData = new MutableLiveData<>();
//        mutableLiveData.observe(this, new Observer<User>() {
//            @Override
//            public void onChanged(User user) {
//                Log.i("MainActivity.this", "onChanged: "+"age:" + user.age + ":name:" + user.name);
//            }
//        });
//        findViewById(R.id.btn_click).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mutableLiveData.setValue(new User(30,"aaa"));
//            }
//        });

//        FragmentManager manager = getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        //创建fragment但是不绘制UI
//        transaction.add(R.id.fl_container,new BlankFragment(),"");
//        transaction.commit();
//        String aa = "赵xx";
//        userModel.mutableLiveData.setValue(new User(30,aa));
    }

//    private MutableLiveData<User> mutableLiveData;

    @Override
    protected void onDestroy() {
//       mutableLiveData.setValue(new User(50,"aaabbbbbb"));
        super.onDestroy();
    }
}