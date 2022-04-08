package com.example.study.design_pattern.chain;

/**
 * <pre>  责任链模式
 * 如果这种结构用在编程领域，则每个节点可以看做一个对象，每个对象有不同的处理逻辑，将一个请求从链的首端发出，沿着链的路径依次传递每个节点对象，直到有对象处理这个请求为止，我们将这样一种模式称为责任链模式。
 * 参考地址https://blog.csdn.net/u011897062/article/details/89457070
 *     author : liaozh
 *     e-mail : xxx@xx
 *     time   : 2022/04/08
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Client {
    private AbstractHandler handler;

    public Client() {
        handler = init();
    }

    private AbstractHandler init() {
        Handler1 handler1 = new Handler1();
        Handler2 handler2 = new Handler2();
        Handler3 handler3 = new Handler3();
        handler1.setNextHandler(handler2);
        handler2.setNextHandler(handler3);
        return handler1;
    }

    public void handleRequest(AbstractRequest abstractRequest) {
        handler.handleRequest(abstractRequest);
    }
}
