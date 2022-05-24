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
public class Model {
    private Presenter presenter;

    public Model(Presenter presenter) {
        this.presenter = presenter;
    }

    public void postData(String toString) {
        //请求数据后，作用于view上面
        presenter.setMsgTextView(toString);
    }

    public void clearData() {
        //把数据清空
        presenter.clearTextData();
    }
}
