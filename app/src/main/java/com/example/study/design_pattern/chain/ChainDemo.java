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
public class ChainDemo {

    public void handle() {
        Client client = new Client();
        client.handleRequest(new Request1("1"));
        client.handleRequest(new Request1("2"));
        client.handleRequest(new Request1("3"));
    }
}
