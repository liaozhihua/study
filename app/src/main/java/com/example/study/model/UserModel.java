package com.example.study.model;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.study.entity.User;

public class UserModel extends ViewModel {
    public MutableLiveData<User> mutableLiveData = new MutableLiveData<>();

    public UserModel() {
//        mutableLiveData.postValue(new User(1, "name1"));
    }
    //模拟 进行一些数据骚操作
    public void doSomething() {
        User user = mutableLiveData.getValue();
        if (user != null) {
            user.age = 15;
            user.name = "name15";
            mutableLiveData.setValue(user);
        }

    }
}
