package com.example.study.design_pattern.mvc;

/**
 * <pre>
 *     author : liaozh
 *     e-mail : xxx@xx
 *     time   : 2022/05/23
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class ControlModel {
    private IView view;

    public ControlModel(IView view) {
        this.view = view;
    }

    public void postData(String toString) {
        //请求数据后，作用于view上面
        view.setMsgTextView(toString);
    }

    public void clearData() {
        //把数据清空
        view.clearData();
    }
}
