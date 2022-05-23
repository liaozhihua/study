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
public class Controller {

    private ControlModel controlModel;

    public Controller(ControlModel controlModel) {
        this.controlModel = controlModel;
    }

    public void handleData(String toString) {
        //处理后 调用后台进行请求
        handlerBefore();
        controlModel.postData(toString);
    }

    private void handlerBefore() {

    }

    public void clearData() {
        //处理后 调用后台进行请求
        handlerBefore();
        controlModel.clearData();
    }
}
