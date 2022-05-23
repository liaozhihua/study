package com.example.study.design_pattern.mvc;

public class NumModel {
    private int num = 0;

    public void add(ContorllerActivity activity) {
        num = ++num;//更新数据
        activity.updateUI(num + "");//更新UI
    }
}
