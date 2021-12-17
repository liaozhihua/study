package com.example.study.rxjava;

import android.util.Log;

import org.jetbrains.annotations.NotNull;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

import static android.content.ContentValues.TAG;

public class Rxjava2Example {
    /**
     * create 操作符应该是最常见的操作符了，主要用于产生一个 Obserable 被观察者对象
     */
    public void create() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NotNull ObservableEmitter<String> e) throws Exception {
                e.onNext("lalala");
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(@NotNull String s) throws Exception {

            }
        });

    }
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
                d.dispose();
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
        });
    }

    //zip 专用于合并事件，该合并不是连接（连接操作符后面会说），而是两两配对，也就意味着，最终配对出的 Observable 发射事件数目只和少的那个相同。

    /**
     * zip 组合事件的过程就是分别从发射器 A 和发射器 B 各取出一个事件来组合，并且一个事件只能被使用一次，组合的顺序是严格按照事件发送的顺序来进行的，所以上面截图中，可以看到，1 永远是和 A 结合的，2 永远是和 B 结合的。
     *
     * 最终接收器收到的事件数量是和发送器发送事件最少的那个发送器的发送事件数目相同，所以如截图中，5 很孤单，没有人愿意和它交往，孤独终老的单身狗。
     *
     * 作者：nanchen2251
     * 链接：https://www.jianshu.com/p/b39afa92807e
     * 来源：简书
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public void zip() {
        Observable.zip(getStringObservable(), getIntegerObservable(), new BiFunction<String, Integer, String>() {
            @NotNull
            @Override
            public String apply(@NotNull String s, @NotNull Integer integer) throws Exception {
                return null;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(@NotNull String s) throws Exception {

            }
        });
    }

    //发射器 B 把自己的三个孩子送给了发射器 A，让他们组合成了一个新的发射器，非常懂事的孩子，有条不紊的排序接收。
    public void concat() {
        Observable.concat(Observable.just(1,2,3), Observable.just(4,5,6))
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer integer) throws Exception {
                        Log.e(TAG, "concat : "+ integer + "\n" );
                    }
                });
    }

    private Observable<String> getStringObservable() {
        return Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                if (!e.isDisposed()) {
                    e.onNext("A");
                    Log.e(TAG, "String emit : A \n");
                    e.onNext("B");
                    Log.e(TAG, "String emit : B \n");
                    e.onNext("C");
                    Log.e(TAG, "String emit : C \n");
                }
            }
        });
    }

    private Observable<Integer> getIntegerObservable() {
        return Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                if (!e.isDisposed()) {
                    e.onNext(1);
                    Log.e(TAG, "Integer emit : 1 \n");
                    e.onNext(2);
                    Log.e(TAG, "Integer emit : 2 \n");
                    e.onNext(3);
                    Log.e(TAG, "Integer emit : 3 \n");
                    e.onNext(4);
                    Log.e(TAG, "Integer emit : 4 \n");
                    e.onNext(5);
                    Log.e(TAG, "Integer emit : 5 \n");
                }
            }
        });
    }

    public void method1() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                Log.e(TAG, "subscribe:" + Thread.currentThread().getName() + "\n");
                e.onNext("啦啦啦");
            }
        }).map(new Function<String, String>() {
            @Override
            public String apply(@NonNull String response) throws Exception {

                Log.e(TAG, "map 线程:" + Thread.currentThread().getName() + "\n");

                return "Function";
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(@NonNull String s) throws Exception {
                        Log.e(TAG, "doOnNext 线程:" + Thread.currentThread().getName() + "\n");
                        Log.e(TAG, "doOnNext: 保存成功：" + s.toString() + "\n");

                    }
                })
                //.observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(@NonNull String data) throws Exception {
                        Log.e(TAG, "subscribe 线程:" + Thread.currentThread().getName() + "\n");
                        Log.e(TAG, "成功:" + data.toString() + "\n");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        Log.e(TAG, "subscribe 线程:" + Thread.currentThread().getName() + "\n");

                        Log.e(TAG, "失败：" + throwable.getMessage() + "\n");
                    }
                });
    }

    public void method2() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NotNull ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1000);
                Log.e(TAG,"subscribe:"+Thread.currentThread().getName()+"\n");
            }
        })
                .observeOn(AndroidSchedulers.mainThread()) // 为doOnNext() 指定在主线程，否则报错
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(@NonNull Integer data) throws Exception {
                        Log.e(TAG, "doOnNext:"+Thread.currentThread().getName()+"\n" );
                        Log.e(TAG,"doOnNext:"+data.toString()+"\n");
                    }
                })
                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(@NonNull Integer mobileAddress) throws Exception {
                        Log.e(TAG, "\n" );
                        Log.e(TAG, "map:"+Thread.currentThread().getName()+"\n" );
                        return "mobileAddress.getResult()";
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(@NonNull String data) throws Exception {
                        Log.e(TAG, "subscribe 成功:"+Thread.currentThread().getName()+"\n" );
                        Log.e(TAG, "成功:" + data.toString() + "\n");
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        Log.e(TAG, "subscribe 失败:"+Thread.currentThread().getName()+"\n" );
                        Log.e(TAG, "失败："+ throwable.getMessage()+"\n" );
                    }
                });
    }
}
