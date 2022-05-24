package com.example.study.design_pattern.mvvm2;

/**
 * <pre>
 *     author : liaozh
 *     e-mail : xxx@xx
 *     time   : 2022/05/24
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class HandleModel {
    private ViewModel viewModel;

    public HandleModel() {
    }

    public void clearData() {
        viewModel.dataCleared();
    }

    public void setViewModel(ViewModel viewModel) {
        this.viewModel = viewModel;
    }

    public void handleData(String s) {
        viewModel.dataHandled("handled data: "+s);
    }
}
