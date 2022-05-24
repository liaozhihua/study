package com.example.study.design_pattern.mvp;

/**
 * <pre>
 *     author : liaozh
 *     e-mail : xxx@xx
 *     time   : 2022/05/23
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Presenter {

    private Model model;
    private IView iView;

    public Presenter(IView iView) {
        model = new Model(this);
        iView = iView;
    }

    public void handleData(String toString) {
        //处理后 调用后台进行请求
        handlerBefore();
        model.postData(toString);
    }

    private void handlerBefore() {

    }

    public void clearData() {
        //处理后 调用后台进行请求
        handlerBefore();
        model.clearData();
    }

    public void setMsgTextView(String toString) {
        iView.setMsgTextView(toString);
    }

    public void clearTextData() {
        iView.clearTextData();
    }
}
