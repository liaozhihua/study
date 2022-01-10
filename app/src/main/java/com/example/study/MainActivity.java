package com.example.study;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.study.model.UserModel;
import com.example.study.rxjava.Rxjava2Example;

import static android.content.ContentValues.TAG;


public class MainActivity extends AppCompatActivity {
    private boolean flag;
    private UserModel userModel;
    WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webview = findViewById(R.id.webview);
        initWebView();
//        Rxjava2Example rxjava2Example = new Rxjava2Example();
//        Log.e(TAG, "MainActivity:" + Thread.currentThread().getName() + "\n");
//        rxjava2Example.method2();
//        Intent intent = new Intent();
//        intent.setAction("dddddddddddddddddddd");
//        startActivity(intent);
        //1、不通过ViewModel方式
//        MutableLiveData mutableLiveData = new MutableLiveData<String>();
//        mutableLiveData.observe(this, new Observer() {
//            @Override
//            public void onChanged(Object o) {
//
//            }
//        });
//        mutableLiveData.setValue("sss");
        //2 通过ViewModel
//        ViewModelProvider of = ViewModelProviders.of(this);
//        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
//        userModel = viewModelProvider.get(UserModel.class);
//         mutableLiveData = new MutableLiveData<>();
//        mutableLiveData.observe(this, new Observer<User>() {
//            @Override
//            public void onChanged(User user) {
//                Log.i("MainActivity.this", "onChanged: "+"age:" + user.age + ":name:" + user.name);
//            }
//        });
//        findViewById(R.id.btn_click).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mutableLiveData.setValue(new User(30,"aaa"));
//            }
//        });

//        FragmentManager manager = getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        //创建fragment但是不绘制UI
//        transaction.add(R.id.fl_container,new BlankFragment(),"");
//        transaction.commit();
//        String aa = "赵xx";
//        userModel.mutableLiveData.setValue(new User(30,aa));
    }

//    private MutableLiveData<User> mutableLiveData;

    @Override
    protected void onDestroy() {
//       mutableLiveData.setValue(new User(50,"aaabbbbbb"));
        super.onDestroy();
    }

    private void initWebView() {
        WebSettings mWebSettings = webview.getSettings();
        mWebSettings.setDefaultTextEncodingName("utf-8");//字符编码UTF-8
        webview.requestFocusFromTouch();
        mWebSettings.setSupportZoom(false);//不支持缩放
        mWebSettings.setTextZoom(100);
        mWebSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
        mWebSettings.setUseWideViewPort(true); //将图片调整到适合webView的大小
        mWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        mWebSettings.setNeedInitialFocus(true); //当webView调用requestFocus时为webView设置节点

        mWebSettings.setLoadsImagesAutomatically(true);
        mWebSettings.setBlockNetworkImage(false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mWebSettings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }

        mWebSettings.setJavaScriptEnabled(true);//支持javascript

        mWebSettings.setRenderPriority(WebSettings.RenderPriority.HIGH);//提高渲染等级
        webview.setFitsSystemWindows(true);
        mWebSettings.setSavePassword(false);
        mWebSettings.setSaveFormData(true);
        mWebSettings.setDomStorageEnabled(true);
        mWebSettings.setDatabaseEnabled(true);
        mWebSettings.setAppCacheEnabled(true);
        mWebSettings.setAppCacheMaxSize(1024 * 1024 * 8);

        mWebSettings.setAllowFileAccess(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }

        webview.setWebChromeClient(new WebChromeClient());
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                //返回true
                return true;
            }

            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                handler.proceed();
            }
        });
        webview.loadUrl("https://www.jianshu.com/p/6c84097bfb9b");
    }
}