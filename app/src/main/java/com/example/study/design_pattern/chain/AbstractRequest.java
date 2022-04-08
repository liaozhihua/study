package com.example.study.design_pattern.chain;

/**
 * <pre>
 *     author : liaozh
 *     e-mail : xxx@xx
 *     time   : 2022/04/06
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public abstract class AbstractRequest {

    private String object;

    public AbstractRequest(String object){
        this.object = object;
    }

    public abstract String getContent();
}
