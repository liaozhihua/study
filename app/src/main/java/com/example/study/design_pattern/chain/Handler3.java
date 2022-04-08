package com.example.study.design_pattern.chain;

/**
 * <pre>
 *     author : liaozh
 *     e-mail : xxx@xx
 *     time   : 2022/04/08
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Handler3 extends AbstractHandler{
    @Override
    public String getHandleContent() {
        return "3";
    }

    @Override
    public void handle(AbstractRequest request) {
        //处理3
    }
}
