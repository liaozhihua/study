package com.example.study.rxjava;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import static android.content.ContentValues.TAG;

public class RxjavaExample {
    /**
     * 2021-12-14 19:47:57.052 21237-21237/com.example.study E/ContentValues: currentThread2:main
     * 2021-12-14 19:47:57.052 21237-21237/com.example.study E/ContentValues: Disposable
     * 2021-12-14 19:47:57.054 21237-29026/com.example.study E/ContentValues: currentThread1:RxCachedThreadScheduler-1
     * 2021-12-14 19:47:57.054 21237-29026/com.example.study E/ContentValues: Observable emit 1
     * 2021-12-14 19:47:57.054 21237-29026/com.example.study E/ContentValues: onNext:1
     * 2021-12-14 19:47:57.054 21237-29026/com.example.study E/ContentValues: Observable emit 2
     * 2021-12-14 19:47:57.054 21237-29026/com.example.study E/ContentValues: onNext:2
     * 2021-12-14 19:47:57.054 21237-29026/com.example.study E/ContentValues: Observable emit 3
     * 2021-12-14 19:47:57.054 21237-29026/com.example.study E/ContentValues: onNext:3
     * 2021-12-14 19:47:57.055 21237-29026/com.example.study E/ContentValues: onComplete:
     * 2021-12-14 19:47:57.055 21237-29026/com.example.study E/ContentValues: Observable emit 4
     * 2021-12-14 19:48:03.307 21237-21237/com.example.study E/ContentValues: currentThread2:main
     * 2021-12-14 19:48:03.307 21237-21237/com.example.study E/ContentValues: Disposable
     * 2021-12-14 19:48:03.308 21237-29026/com.example.study E/ContentValues: currentThread1:RxCachedThreadScheduler-1
     * 2021-12-14 19:48:03.308 21237-29026/com.example.study E/ContentValues: Observable emit 1
     * 2021-12-14 19:48:03.309 21237-29026/com.example.study E/ContentValues: onNext:1
     * 2021-12-14 19:48:03.309 21237-29026/com.example.study E/ContentValues: Observable emit 2
     * 2021-12-14 19:48:03.309 21237-29026/com.example.study E/ContentValues: onNext:2
     * 2021-12-14 19:48:03.309 21237-29026/com.example.study E/ContentValues: Observable emit 3
     * 2021-12-14 19:48:03.309 21237-29026/com.example.study E/ContentValues: onNext:3
     * 2021-12-14 19:48:03.309 21237-29026/com.example.study E/ContentValues: onComplete:
     * 2021-12-14 19:48:03.309 21237-29026/com.example.study E/ContentValues: Observable emit 4
     */
    public static void normal() {//为啥会走2遍？？？
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NotNull ObservableEmitter<Integer> e) throws Exception {
                Log.e(TAG, "currentThread1:"+Thread.currentThread().getName());
                Log.e(TAG, "Observable emit 1" + "\n");
                e.onNext(1);
                Log.e(TAG, "Observable emit 2" + "\n");
                e.onNext(2);
                Log.e(TAG, "Observable emit 3" + "\n");
                e.onNext(3);
                e.onComplete();
                Log.e(TAG, "Observable emit 4" + "\n" );
                e.onNext(4);
            }
        }).subscribeOn(Schedulers.io()).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NotNull Disposable d) {
                Log.e(TAG, "currentThread2:"+Thread.currentThread().getName());
                Log.e(TAG, "Disposable" + "\n");
            }

            @Override
            public void onNext(@NotNull Integer integer) {
                Log.e(TAG, "onNext:" + integer+"\n");
            }

            @Override
            public void onError(@NotNull Throwable e) {

            }

            @Override
            public void onComplete() {
                Log.e(TAG, "onComplete:" + "\n");
            }
        });
    }

    //map 操作符可以将一个 Observable 对象通过某种关系转换为另一个Observable 对象
    public static void map() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NotNull ObservableEmitter<Integer> e) throws Exception {

            }
        }).map(new Function<Integer, String>() {
            @NotNull
            @Override
            public String apply(@NotNull Integer integer) throws Exception {
                return null;
            }
        }).subscribeOn(Schedulers.io()).doOnNext(new Consumer<String>() {
            @Override
            public void accept(@NotNull String s) throws Exception {

            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NotNull Disposable d) {

            }

            @Override
            public void onNext(@NotNull String s) {

            }

            @Override
            public void onError(@NotNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        })
    }
}
