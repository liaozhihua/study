package com.example.study.design_pattern.chain;

import static android.content.ContentValues.TAG;

import android.util.Log;

/**
 * <pre>
 *     author : liaozh
 *     e-mail : xxx@xx
 *     time   : 2022/04/08
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public abstract class AbstractHandler {

    private AbstractHandler nextHandler;

    public  void handleRequest(AbstractRequest request) {
        if (request.getContent().equals(getHandleContent())) {
            handle(request);
        } else {
           if (nextHandler !=null) {
               nextHandler.handleRequest(request);
           } else {
               //当所有处理者对象均不能处理该请求时输出
               Log.d(TAG,"All of handler can not handle the request");
           }
        }
    }

    public abstract String getHandleContent();
    public abstract void handle(AbstractRequest request);

    public void setNextHandler(AbstractHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
