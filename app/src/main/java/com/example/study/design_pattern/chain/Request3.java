package com.example.study.design_pattern.chain;

/**
 * <pre>
 *     author : liaozh
 *     e-mail : xxx@xx
 *     time   : 2022/04/07
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class Request3 extends AbstractRequest{

    public Request3(String object) {
        super(object);
    }

    @Override
    public String getContent() {
        return "3";
    }
}
