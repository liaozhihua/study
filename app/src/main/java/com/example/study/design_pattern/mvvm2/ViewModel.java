package com.example.study.design_pattern.mvvm2;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

/**
 * <pre>
 *     author : liaozh
 *     e-mail : xxx@xx
 *     time   : 2022/05/24
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class ViewModel {
    private HandleModel handleModel;

    // View 绑定的数据，inputText 和 handledText 更新后会自动通知 View 更新界面
    private MutableLiveData<String> inputText = new MutableLiveData<>();

    private MutableLiveData<String> handledText = new MutableLiveData<>();

    public ViewModel(HandleModel handleModel) {
        this.handleModel = handleModel;
        handleModel.setViewModel(this);
        inputText.observeForever(s -> handleText(s));
    }

    private void handleText(String s) {
        handledText.postValue(s);
        handleModel.handleData(s);
    }

    public void clearData() {
        handleModel.clearData();
    }


    public void dataCleared() {
        inputText.postValue("");
    }

    public void dataHandled(String s) {
        handledText.postValue(s);
    }
}
