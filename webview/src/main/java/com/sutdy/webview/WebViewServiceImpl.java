package com.sutdy.webview;

import android.content.Context;
import android.content.Intent;

import com.study.common.autoservice.IWebVewInterface;

public class WebViewServiceImpl implements IWebVewInterface {
    @Override
    public void startWebActivity(Context context, String url, String title) {
        if (context != null) {
            context.startActivity(new Intent(context,WebviewActivity.class));
        }
    }
}
