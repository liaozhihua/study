//package com.example.study.rxjava1;
//
//import android.graphics.Bitmap;
//
//import java.io.File;
//
//import rx.Observable;
//import rx.Observer;
//import rx.Scheduler;
//import rx.Subscriber;
//import rx.android.schedulers.AndroidSchedulers;
//import rx.functions.Action0;
//import rx.functions.Action1;
//import rx.functions.Func1;
//import rx.schedulers.Schedulers;

/**
 * 参考文章 ： 扔物线：给 Android 开发者的 RxJava1 详解  https://segmentfault.com/a/1190000011358934
 *
 * RxJava 好在哪 简洁 RxJava 的优势也是简洁，但它的简洁的与众不同之处在于，随着程序逻辑变得越来越复杂，它依然能够保持简洁。
 * --------------------------------------------------------------
 * onCompleted(): 事件队列完结。RxJava 不仅把每个事件单独处理，还会把它们看做一个队列。RxJava 规定，当不会再有新的 onNext() 发出时，需要触发 onCompleted() 方法作为标志。
 * onError(): 事件队列异常。在事件处理过程中出异常时，onError() 会被触发，同时队列自动终止，不允许再有事件发出。
 * 需要注意的是，onCompleted() 和 onError() 二者也是互斥的
 */
//public class Rxjava1Example {
//    //正常文件加载图片展示
//    public void method() {
//        File[] files = new File[0];
//        Observable.from(files).flatMap(new Func1<File, Observable<File>>() {
//            @Override
//            public Observable<File> call(File s) {
//                return Observable.from(s.listFiles());
//            }
//
//        }).filter(new Func1<File, Boolean>() {
//            @Override
//            public Boolean call(File file) {
//                return file.getName().endsWith(".png");
//            }
//        }).map(new Func1<File, Bitmap>() {
//            @Override
//            public Bitmap call(File file) {
//                return null;
//            }
//        }).subscribeOn(Schedulers.io()).
//                observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<Bitmap>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(Bitmap bitmap) {
//
//            }
//        });
//        Observable.create(new Observable.OnSubscribe<String>() {
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//
//            }
//        });
//
//    }
//}
